package com.reimnop.pgen.builder.page;

import com.reimnop.pgen.data.page.PGenCraftingPage;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class PGenCraftingPageBuilder extends PGenPageBuilder<PGenCraftingPageBuilder> {

    public ResourceLocation recipe;

    @Nullable
    public ResourceLocation recipe2;

    @Nullable
    public String text;

    @Nullable
    public String title;

    public PGenCraftingPageBuilder(String modId, ResourceLocation recipe) {
        super(modId);
        this.recipe = recipe;
    }

    public PGenCraftingPageBuilder withRecipe(ResourceLocation recipe) {
        this.recipe = recipe;
        return this;
    }

    public PGenCraftingPageBuilder withRecipe(String recipe) {
        return withRecipe(ResourceLocation.fromNamespaceAndPath(modId, recipe));
    }

    public PGenCraftingPageBuilder withRecipe2(ResourceLocation recipe2) {
        this.recipe2 = recipe2;
        return this;
    }

    public PGenCraftingPageBuilder withRecipe2(String recipe2) {
        return withRecipe(ResourceLocation.fromNamespaceAndPath(modId, recipe2));
    }

    public PGenCraftingPageBuilder withText(@Nullable String text) {
        this.text = text;
        return this;
    }

    public PGenCraftingPageBuilder withTitle(@Nullable String title) {
        this.title = title;
        return this;
    }

    public PGenCraftingPage build() {
        return new PGenCraftingPage(recipe, recipe2, text, title, advancement, flag, anchor);
    }
}
