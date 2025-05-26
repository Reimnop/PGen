package com.reimnop.pgen.data.page;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class PGenTextPage extends PGenPage {

    public String text;

    @Nullable
    public String title;

    public PGenTextPage(
            String text,
            @Nullable String title,
            @Nullable ResourceLocation advancement,
            @Nullable String flag,
            @Nullable String anchor) {
        super(advancement, flag, anchor);
        this.text = text;
        this.title = title;
    }

    @Override
    protected ResourceLocation getType() {
        return patchouliPageType("text");
    }

    @Override
    protected void writeToJson(JsonObject obj) {
        obj.add("text", new JsonPrimitive(text));
        if (title != null) {
            obj.add("title", new JsonPrimitive(title));
        }
    }
}
