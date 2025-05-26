package com.reimnop.pgen.data.page;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PGenRelationsPage extends PGenPage {

    @Nullable
    public List<ResourceLocation> entries;

    @Nullable
    public String text;

    @Nullable
    public String title;

    public PGenRelationsPage(
            @Nullable List<ResourceLocation> entries,
            @Nullable String text,
            @Nullable String title,
            @Nullable ResourceLocation advancement,
            @Nullable String flag,
            @Nullable String anchor) {
        super(advancement, flag, anchor);
        this.entries = entries;
        this.text = text;
        this.title = title;
    }

    @Override
    protected ResourceLocation getType() {
        return patchouliPageType("relations");
    }

    @Override
    protected void writeToJson(JsonObject obj) {
        if (entries != null) {
            obj.add("entries", serializeEntries(entries));
        }
        if (text != null) {
            obj.add("text", new JsonPrimitive(text));
        }
        if (title != null) {
            obj.add("title", new JsonPrimitive(title));
        }
    }

    private static JsonArray serializeEntries(List<ResourceLocation> entries) {
        JsonArray array = new JsonArray();
        for (ResourceLocation entry : entries) {
            array.add(new JsonPrimitive(entry.toString()));
        }
        return array;
    }
}
