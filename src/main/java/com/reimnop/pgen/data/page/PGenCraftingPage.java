package com.reimnop.pgen.data.page;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class PGenCraftingPage extends PGenPage {

    public ResourceLocation recipe;

    @Nullable
    public ResourceLocation recipe2;

    @Nullable
    public String text;

    @Nullable
    public String title;

    public PGenCraftingPage(
            ResourceLocation recipe,
            @Nullable ResourceLocation recipe2,
            @Nullable String text,
            @Nullable String title,
            @Nullable ResourceLocation advancement,
            @Nullable String flag,
            @Nullable String anchor) {
        super(advancement, flag, anchor);
        this.recipe = recipe;
        this.recipe2 = recipe2;
        this.text = text;
        this.title = title;
    }

    @Override
    protected ResourceLocation getType() {
        return patchouliPageType("crafting");
    }

    @Override
    protected void writeToJson(JsonObject obj) {
        obj.add("recipe", new JsonPrimitive(recipe.toString()));
        if (recipe2 != null) {
            obj.add("recipe2", new JsonPrimitive(recipe2.toString()));
        }
        if (text != null) {
            obj.add("text", new JsonPrimitive(text));
        }
        if (title != null) {
            obj.add("title", new JsonPrimitive(title));
        }
    }
}
