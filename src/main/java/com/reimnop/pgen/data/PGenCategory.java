package com.reimnop.pgen.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.reimnop.pgen.PGenSerializable;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class PGenCategory implements PGenSerializable {
    public String id;

    public String name;
    public String description;
    public ResourceLocation icon;

    @Nullable
    public ResourceLocation parent;

    @Nullable
    public String flag;

    @Nullable
    public Integer sortnum;

    @Nullable
    public Boolean secret;

    public PGenCategory(
            String id,
            String name,
            String description,
            ResourceLocation icon,
            @Nullable ResourceLocation parent,
            @Nullable String flag,
            @Nullable Integer sortnum,
            @Nullable Boolean secret) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.parent = parent;
        this.flag = flag;
        this.sortnum = sortnum;
        this.secret = secret;
    }

    @Override
    public JsonElement serialize() {
        var obj = new JsonObject();
        obj.add("name", new JsonPrimitive(name));
        obj.add("description", new JsonPrimitive(description));
        obj.add("icon", new JsonPrimitive(icon.toString()));
        if (parent != null) {
            obj.add("parent", new JsonPrimitive(parent.toString()));
        }
        if (flag != null) {
            obj.add("flag", new JsonPrimitive(flag));
        }
        if (sortnum != null) {
            obj.add("sortnum", new JsonPrimitive(sortnum));
        }
        if (secret != null) {
            obj.add("secret", new JsonPrimitive(secret));
        }
        return obj;
    }
}
