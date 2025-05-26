package com.reimnop.pgen.builder.page;

import com.reimnop.pgen.data.page.PGenSpotlightPage;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PGenSpotlightPageBuilder extends PGenPageBuilder<PGenSpotlightPageBuilder> {
    public static class ItemBuilder {
        public String modId;

        public List<ResourceLocation> items = new ArrayList<>();
        public List<ResourceLocation> tags = new ArrayList<>();

        public ItemBuilder(String modId) {
            this.modId = modId;
        }

        public ItemBuilder addItem(ResourceLocation item) {
            this.items.add(item);
            return this;
        }

        public ItemBuilder addItem(String item) {
            return addItem(ResourceLocation.fromNamespaceAndPath(modId, item));
        }

        public ItemBuilder addTag(ResourceLocation tag) {
            this.tags.add(tag);
            return this;
        }

        public ItemBuilder addTag(String tag) {
            return addTag(ResourceLocation.fromNamespaceAndPath(modId, tag));
        }

        public PGenSpotlightPage.Item build() {
            return new PGenSpotlightPage.Item(items.isEmpty() ? null : items, tags.isEmpty() ? null : tags);
        }
    }

    public PGenSpotlightPage.Item item;

    @Nullable
    public Boolean linkRecipe;

    @Nullable
    public String text;

    @Nullable
    public String title;

    public PGenSpotlightPageBuilder(String modId, PGenSpotlightPage.Item item) {
        super(modId);
        this.item = item;
    }

    public PGenSpotlightPageBuilder(String modId, Consumer<ItemBuilder> consumer) {
        super(modId);
        var itemBuilder = new ItemBuilder(modId);
        consumer.accept(itemBuilder);
        this.item = itemBuilder.build();
    }

    public PGenSpotlightPageBuilder withItem(PGenSpotlightPage.Item item) {
        this.item = item;
        return this;
    }

    public PGenSpotlightPageBuilder withItem(Consumer<ItemBuilder> consumer) {
        var itemBuilder = new ItemBuilder(modId);
        consumer.accept(itemBuilder);
        return withItem(itemBuilder.build());
    }

    public PGenSpotlightPageBuilder withLinkRecipe(@Nullable Boolean linkRecipe) {
        this.linkRecipe = linkRecipe;
        return this;
    }

    public PGenSpotlightPageBuilder withText(@Nullable String text) {
        this.text = text;
        return this;
    }

    public PGenSpotlightPageBuilder withTitle(@Nullable String title) {
        this.title = title;
        return this;
    }

    public PGenSpotlightPage build() {
        return new PGenSpotlightPage(
                item,
                linkRecipe,
                text,
                title,
                advancement,
                flag,
                anchor
        );
    }
}
