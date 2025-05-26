package com.reimnop.pgen;

import com.reimnop.pgen.builder.PGenBookBuilder;
import com.reimnop.pgen.data.PGenBook;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public abstract class PGenBookProvider implements DataProvider {
    private final String modId;
    private final CompletableFuture<HolderLookup.Provider> lookupProvider;
    private final PackOutput.PathProvider dataPathProvider;
    private final PackOutput.PathProvider assetsPathProvider;

    private final Map<ResourceLocation, PGenBook> books = new HashMap<>();

    public PGenBookProvider(String modId, CompletableFuture<HolderLookup.Provider> lookupProvider, PackOutput packOutput) {
        this.modId = modId;
        this.lookupProvider = lookupProvider;
        this.dataPathProvider = packOutput.createPathProvider(PackOutput.Target.DATA_PACK, "patchouli_books");
        this.assetsPathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "patchouli_books");
    }

    protected abstract void generate(HolderLookup.Provider provider);

    protected void addBook(PGenBook book) {
        this.books.put(book.id, book);
    }

    protected void addBook(String id, String name, String landingText, Boolean useResourcePack, Consumer<PGenBookBuilder> consumer) {
        var builder = new PGenBookBuilder(
                ResourceLocation.fromNamespaceAndPath(modId, id),
                name,
                landingText,
                useResourcePack);
        consumer.accept(builder);
        this.addBook(builder.build());
    }

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput pOutput) {
        return this.createContentsProvider().thenCompose((provider) ->
                CompletableFuture.allOf(this.books.values().stream().map(book -> {
                    var futures = new ArrayList<CompletableFuture<?>>();

                    // serialize book
                    var bookPath = ResourceLocation.fromNamespaceAndPath(
                            book.id.getNamespace(),
                            book.id.getPath() + "/book");

                    var bookFilePath = this.dataPathProvider.json(bookPath);
                    futures.add(DataProvider.saveStable(pOutput, book.serialize(), bookFilePath));

                    // decide if we should serialize into assets or data next
                    var contentProvider = (book.useResourcePack != null ? book.useResourcePack : false)
                            ? this.assetsPathProvider
                            : this.dataPathProvider;

                    // serialize langs
                    for (var lang : book.languages) {
                        var langBasePath = ResourceLocation.fromNamespaceAndPath(
                            book.id.getNamespace(),
                            book.id.getPath() + "/" + lang.name);

                        // serialize categories
                        var categoriesPath = ResourceLocation.fromNamespaceAndPath(
                                langBasePath.getNamespace(),
                                langBasePath.getPath() + "/categories");

                        for (var category : lang.categories) {
                            var categoryPath = ResourceLocation.fromNamespaceAndPath(
                                    categoriesPath.getNamespace(),
                                    categoriesPath.getPath() + "/" + category.id);
                            var categoryFilePath = contentProvider.json(categoryPath);
                            futures.add(DataProvider.saveStable(pOutput, category.serialize(), categoryFilePath));
                        }

                        // serialize entries
                        var entriesPath = ResourceLocation.fromNamespaceAndPath(
                                langBasePath.getNamespace(),
                                langBasePath.getPath() + "/entries");

                        for (var entry : lang.entries) {
                            var entryPath = ResourceLocation.fromNamespaceAndPath(
                                    entriesPath.getNamespace(),
                                    entriesPath.getPath() + "/" + entry.id);
                            var entryFilePath = contentProvider.json(entryPath);
                            futures.add(DataProvider.saveStable(pOutput, entry.serialize(), entryFilePath));
                        }
                    }

                    return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
                }).toArray(CompletableFuture[]::new)));
    }

    @Override
    public @NotNull String getName() {
        return String.format("PGen book provider for mod id %s", modId);
    }

    protected CompletableFuture<HolderLookup.Provider> createContentsProvider() {
        return this.lookupProvider.thenApply((provider) -> {
            this.generate(provider);
            return provider;
        });
    }
}
