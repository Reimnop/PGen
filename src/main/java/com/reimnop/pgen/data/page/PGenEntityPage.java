package com.reimnop.pgen.data.page;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.reimnop.pgen.data.PGenEntityDefinition;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class PGenEntityPage extends PGenPage {

    public PGenEntityDefinition entity;

    @Nullable
    public Float scale;

    @Nullable
    public Float offset;

    @Nullable
    public Boolean rotate;

    @Nullable
    public Float defaultRotation;

    @Nullable
    public String name;

    @Nullable
    public String text;

    public PGenEntityPage(
            PGenEntityDefinition entity,
            @Nullable Float scale,
            @Nullable Float offset,
            @Nullable Boolean rotate,
            @Nullable Float defaultRotation,
            @Nullable String name,
            @Nullable String text,
            @Nullable ResourceLocation advancement,
            @Nullable String flag,
            @Nullable String anchor) {
        super(advancement, flag, anchor);
        this.entity = entity;
        this.scale = scale;
        this.offset = offset;
        this.rotate = rotate;
        this.defaultRotation = defaultRotation;
        this.name = name;
        this.text = text;
    }

    @Override
    protected ResourceLocation getType() {
        return patchouliPageType("entity");
    }

    @Override
    protected void writeToJson(JsonObject obj) {
        obj.add("entity", new JsonPrimitive(entity.toString()));
        if (scale != null) {
            obj.add("scale", new JsonPrimitive(scale));
        }
        if (offset != null) {
            obj.add("offset", new JsonPrimitive(offset));
        }
        if (rotate != null) {
            obj.add("rotate", new JsonPrimitive(rotate));
        }
        if (defaultRotation != null) {
            obj.add("default_rotation", new JsonPrimitive(defaultRotation));
        }
        if (name != null) {
            obj.add("name", new JsonPrimitive(name));
        }
        if (text != null) {
            obj.add("text", new JsonPrimitive(text));
        }
    }
}
