package com.reimnop.pgen.builder.page;

import com.reimnop.pgen.data.page.PGenSmeltingPage;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class PGenSmeltingPageBuilder extends PGenPageBuilder<PGenSmeltingPageBuilder> {

    public ResourceLocation recipe;

    @Nullable
    public ResourceLocation recipe2;

    @Nullable
    public String text;

    @Nullable
    public String title;

    public PGenSmeltingPageBuilder(String modId, ResourceLocation recipe) {
        super(modId);
        this.recipe = recipe;
    }

    public PGenSmeltingPageBuilder withRecipe(ResourceLocation recipe) {
        this.recipe = recipe;
        return this;
    }

    public PGenSmeltingPageBuilder withRecipe(String recipe) {
        return withRecipe(ResourceLocation.fromNamespaceAndPath(modId, recipe));
    }

    public PGenSmeltingPageBuilder withRecipe2(ResourceLocation recipe2) {
        this.recipe2 = recipe2;
        return this;
    }

    public PGenSmeltingPageBuilder withRecipe2(String recipe2) {
        return withRecipe(ResourceLocation.fromNamespaceAndPath(modId, recipe2));
    }

    public PGenSmeltingPageBuilder withText(@Nullable String text) {
        this.text = text;
        return this;
    }

    public PGenSmeltingPageBuilder withTitle(@Nullable String title) {
        this.title = title;
        return this;
    }

    public PGenSmeltingPage build() {
        return new PGenSmeltingPage(recipe, recipe2, text, title, advancement, flag, anchor);
    }
}
