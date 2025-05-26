package com.reimnop.pgen.data.page;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.reimnop.pgen.PGenSerializable;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public abstract class PGenPage implements PGenSerializable {

    @Nullable
    public ResourceLocation advancement;

    @Nullable
    public String flag;

    @Nullable
    public String anchor;

    protected PGenPage(
            @Nullable ResourceLocation advancement,
            @Nullable String flag,
            @Nullable String anchor) {
        this.advancement = advancement;
        this.flag = flag;
        this.anchor = anchor;
    }

    @Override
    public JsonElement serialize() {
        var obj = new JsonObject();
        obj.add("type", new JsonPrimitive(getType().toString()));
        if (advancement != null) {
            obj.add("advancement", new JsonPrimitive(advancement.toString()));
        }
        if (flag != null) {
            obj.add("flag", new JsonPrimitive(flag));
        }
        if (anchor != null) {
            obj.add("anchor", new JsonPrimitive(anchor));
        }
        writeToJson(obj);
        return obj;
    }

    protected abstract ResourceLocation getType();
    protected abstract void writeToJson(JsonObject obj);

    protected static ResourceLocation patchouliPageType(String type) {
        return ResourceLocation.fromNamespaceAndPath("patchouli", type);
    }
}
