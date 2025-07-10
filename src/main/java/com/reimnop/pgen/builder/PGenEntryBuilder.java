package com.reimnop.pgen.builder;

import com.reimnop.pgen.builder.page.*;
import com.reimnop.pgen.data.PGenEntityDefinition;
import com.reimnop.pgen.data.PGenEntry;
import com.reimnop.pgen.data.page.PGenPage;
import com.reimnop.pgen.data.page.PGenSpotlightPage;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class PGenEntryBuilder {
    public String modId;

    public String id;

    public String name;
    public ResourceLocation icon;
    public ResourceLocation category;
    public List<PGenPage> pages = new ArrayList<>();

    @Nullable
    public ResourceLocation advancement;

    @Nullable
    public String flag;

    @Nullable
    public Boolean priority;

    @Nullable
    public Boolean secret;

    @Nullable
    public Boolean readByDefault;

    @Nullable
    public Integer sortnum;

    @Nullable
    public ResourceLocation turnin;

    @Nullable
    public Map<String, Integer> extraRecipeMappings = new HashMap<>();

    @Nullable
    public String entryColor;

    public PGenEntryBuilder(String modId, String id, String name, ResourceLocation icon, ResourceLocation category) {
        this.modId = modId;
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.category = category;
    }

    public PGenEntryBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public PGenEntryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PGenEntryBuilder withIcon(ResourceLocation icon) {
        this.icon = icon;
        return this;
    }

    public PGenEntryBuilder withIcon(String icon) {
        return withIcon(ResourceLocation.fromNamespaceAndPath(modId, icon));
    }

    public PGenEntryBuilder withCategory(ResourceLocation category) {
        this.category = category;
        return this;
    }

    public PGenEntryBuilder withCategory(String category) {
        return withCategory(ResourceLocation.fromNamespaceAndPath(modId, category));
    }

    public PGenEntryBuilder addPage(PGenPage page) {
        this.pages.add(page);
        return this;
    }

    public PGenEntryBuilder addTextPage(String text, Consumer<PGenTextPageBuilder> consumer) {
        var builder = new PGenTextPageBuilder(modId, text);
        consumer.accept(builder);
        return addPage(builder.build());
    }

    public PGenEntryBuilder addImagePage(Consumer<PGenImagePageBuilder> consumer) {
        var builder = new PGenImagePageBuilder(modId);
        consumer.accept(builder);
        return addPage(builder.build());
    }

    public PGenEntryBuilder addCraftingPage(ResourceLocation recipe, Consumer<PGenCraftingPageBuilder> consumer) {
        var builder = new PGenCraftingPageBuilder(modId, recipe);
        consumer.accept(builder);
        return addPage(builder.build());
    }

    public PGenEntryBuilder addCraftingPage(String recipe, Consumer<PGenCraftingPageBuilder> consumer) {
        return addCraftingPage(ResourceLocation.fromNamespaceAndPath(modId, recipe), consumer);
    }

    public PGenEntryBuilder addSmeltingPage(ResourceLocation recipe, Consumer<PGenSmeltingPageBuilder> consumer) {
        var builder = new PGenSmeltingPageBuilder(modId, recipe);
        consumer.accept(builder);
        return addPage(builder.build());
    }

    public PGenEntryBuilder addSmeltingPage(String recipe, Consumer<PGenSmeltingPageBuilder> consumer) {
        return addSmeltingPage(ResourceLocation.fromNamespaceAndPath(modId, recipe), consumer);
    }

    public PGenEntryBuilder addMultiblockPage(String name, Consumer<PGenMultiblockPageBuilder> consumer) {
        var builder = new PGenMultiblockPageBuilder(modId, name);
        consumer.accept(builder);
        return addPage(builder.build());
    }

    public PGenEntryBuilder addEntityPage(ResourceLocation entity, CompoundTag nbtData, Consumer<PGenEntityPageBuilder> consumer) {
        var builder = new PGenEntityPageBuilder(modId, new PGenEntityDefinition(entity, nbtData));
        consumer.accept(builder);
        return addPage(builder.build());
    }

    public PGenEntryBuilder addEntityPage(String entity, Consumer<PGenEntityPageBuilder> consumer) {
        return addEntityPage(ResourceLocation.fromNamespaceAndPath(modId, entity), null, consumer);
    }

    public PGenEntryBuilder addSpotlightPage(PGenSpotlightPage.Item item, Consumer<PGenSpotlightPageBuilder> consumer) {
        var builder = new PGenSpotlightPageBuilder(modId, item);
        consumer.accept(builder);
        return addPage(builder.build());
    }

    public PGenEntryBuilder addSpotlightPage(Consumer<PGenSpotlightPageBuilder.ItemBuilder> itemBuilderConsumer, Consumer<PGenSpotlightPageBuilder> consumer) {
        var builder = new PGenSpotlightPageBuilder(modId, itemBuilderConsumer);
        consumer.accept(builder);
        return addPage(builder.build());
    }

    public PGenEntryBuilder addLinkPage(String url, String linkText, String text, Consumer<PGenLinkPageBuilder> consumer) {
        var builder = new PGenLinkPageBuilder(modId, url, linkText, text);
        consumer.accept(builder);
        return addPage(builder.build());
    }

    public PGenEntryBuilder addRelationsPage(Consumer<PGenRelationsPageBuilder> consumer) {
        var builder = new PGenRelationsPageBuilder(modId);
        consumer.accept(builder);
        return addPage(builder.build());
    }

    public PGenEntryBuilder addQuestPage(Consumer<PGenQuestPageBuilder> consumer) {
        var builder = new PGenQuestPageBuilder(modId);
        consumer.accept(builder);
        return addPage(builder.build());
    }

    public PGenEntryBuilder addEmptyPage(Consumer<PGenEmptyPageBuilder> consumer) {
        var builder = new PGenEmptyPageBuilder(modId);
        consumer.accept(builder);
        return addPage(builder.build());
    }

    public PGenEntryBuilder withAdvancement(@Nullable ResourceLocation advancement) {
        this.advancement = advancement;
        return this;
    }

    public PGenEntryBuilder withAdvancement(@Nullable String advancement) {
        return withAdvancement(advancement != null ? ResourceLocation.fromNamespaceAndPath(modId, advancement) : null);
    }

    public PGenEntryBuilder withFlag(@Nullable String flag) {
        this.flag = flag;
        return this;
    }

    public PGenEntryBuilder withPriority(@Nullable Boolean priority) {
        this.priority = priority;
        return this;
    }

    public PGenEntryBuilder withSecret(@Nullable Boolean secret) {
        this.secret = secret;
        return this;
    }

    public PGenEntryBuilder withReadByDefault(@Nullable Boolean readByDefault) {
        this.readByDefault = readByDefault;
        return this;
    }

    public PGenEntryBuilder withSortnum(@Nullable Integer sortnum) {
        this.sortnum = sortnum;
        return this;
    }

    public PGenEntryBuilder withTurnin(@Nullable ResourceLocation turnin) {
        this.turnin = turnin;
        return this;
    }

    public PGenEntryBuilder withTurnin(@Nullable String turnin) {
        return withTurnin(turnin != null ? ResourceLocation.fromNamespaceAndPath(modId, turnin) : null);
    }

    public PGenEntryBuilder withExtraRecipeMappings(@Nullable Map<String, Integer> extraRecipeMappings) {
        this.extraRecipeMappings = extraRecipeMappings;
        return this;
    }

    public PGenEntryBuilder addExtraRecipeMapping(String recipeId, Integer count) {
        if (this.extraRecipeMappings == null) {
            this.extraRecipeMappings = new HashMap<>();
        }
        this.extraRecipeMappings.put(recipeId, count);
        return this;
    }

    public PGenEntryBuilder withEntryColor(@Nullable String entryColor) {
        this.entryColor = entryColor;
        return this;
    }

    public PGenEntry build() {
        return new PGenEntry(
                id,
                name,
                icon,
                category,
                pages,
                advancement,
                flag,
                priority,
                secret,
                readByDefault,
                sortnum,
                turnin,
                extraRecipeMappings,
                entryColor);
    }
}
