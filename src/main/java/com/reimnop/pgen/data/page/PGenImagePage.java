package com.reimnop.pgen.data.page;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PGenImagePage extends PGenPage {

    public List<ResourceLocation> images;

    @Nullable
    public Boolean border;

    @Nullable
    public String text;

    @Nullable
    public String title;

    public PGenImagePage(
            List<ResourceLocation> images,
            @Nullable Boolean border,
            @Nullable String text,
            @Nullable String title,
            @Nullable ResourceLocation advancement,
            @Nullable String flag,
            @Nullable String anchor) {
        super(advancement, flag, anchor);
        this.images = images;
        this.border = border;
        this.text = text;
        this.title = title;
    }

    @Override
    protected ResourceLocation getType() {
        return patchouliPageType("image");
    }

    @Override
    protected void writeToJson(JsonObject obj) {
        obj.add("images", serializeImages());
        if (border != null) {
            obj.add("border", new JsonPrimitive(border));
        }
        if (text != null) {
            obj.add("text", new JsonPrimitive(text));
        }
        if (title != null) {
            obj.add("title", new JsonPrimitive(title));
        }
    }

    private JsonArray serializeImages() {
        JsonArray array = new JsonArray();
        for (ResourceLocation image : images) {
            array.add(new JsonPrimitive(image.toString()));
        }
        return array;
    }
}
