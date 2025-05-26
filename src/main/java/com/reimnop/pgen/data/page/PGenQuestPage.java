package com.reimnop.pgen.data.page;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class PGenQuestPage extends PGenPage {

    @Nullable
    public String trigger;

    @Nullable
    public String text;

    @Nullable
    public String title;

    public PGenQuestPage(
            @Nullable String trigger,
            @Nullable String text,
            @Nullable String title,
            @Nullable ResourceLocation advancement,
            @Nullable String flag,
            @Nullable String anchor) {
        super(advancement, flag, anchor);
        this.trigger = trigger;
        this.text = text;
        this.title = title;
    }

    @Override
    protected ResourceLocation getType() {
        return patchouliPageType("quest");
    }

    @Override
    protected void writeToJson(JsonObject obj) {
        if (trigger != null) {
            obj.add("trigger", new JsonPrimitive(trigger));
        }
        if (text != null) {
            obj.add("text", new JsonPrimitive(text));
        }
        if (title != null) {
            obj.add("title", new JsonPrimitive(title));
        }
    }
}
