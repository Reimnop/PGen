package com.reimnop.pgen.data.page;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PGenSpotlightPage extends PGenPage {
    public static class Item {
        @Nullable
        public List<ResourceLocation> items;

        @Nullable
        public List<ResourceLocation> tags;

        public Item(@Nullable List<ResourceLocation> items, @Nullable List<ResourceLocation> tags) {
            this.items = items;
            this.tags = tags;
        }

        @Override
        public String toString() {
            var list = new ArrayList<String>();
            if (items != null && !items.isEmpty()) {
                list.add(items.stream().map(ResourceLocation::toString).collect(Collectors.joining(",")));
            }
            if (tags != null && !tags.isEmpty()) {
                list.add(tags.stream().map(x -> String.format("tag:%s", x.toString())).collect(Collectors.joining(",")));
            }
            return String.join(",", list);
        }
    }

    public Item item;

    @Nullable
    public Boolean linkRecipe;

    @Nullable
    public String text;

    @Nullable
    public String title;

    public PGenSpotlightPage(
            Item item,
            @Nullable Boolean linkRecipe,
            @Nullable String text,
            @Nullable String title,
            @Nullable ResourceLocation advancement,
            @Nullable String flag,
            @Nullable String anchor) {
        super(advancement, flag, anchor);
        this.item = item;
        this.linkRecipe = linkRecipe;
        this.text = text;
        this.title = title;
    }

    @Override
    protected ResourceLocation getType() {
        return patchouliPageType("spotlight");
    }

    @Override
    protected void writeToJson(JsonObject obj) {
        obj.add("item", new JsonPrimitive(item.toString()));
        if (linkRecipe != null) {
            obj.add("title", new JsonPrimitive(linkRecipe));
        }
        if (text != null) {
            obj.add("text", new JsonPrimitive(text));
        }
        if (title != null) {
            obj.add("title", new JsonPrimitive(title));
        }
    }
}
