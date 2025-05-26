package com.reimnop.pgen.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.reimnop.pgen.PGenSerializable;
import com.reimnop.pgen.data.page.PGenPage;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class PGenEntry implements PGenSerializable {
    public String id;

    public String name;
    public ResourceLocation icon;
    public ResourceLocation category;
    public List<PGenPage> pages;

    @Nullable
    public ResourceLocation advancement;

    @Nullable
    public String flag;

    @Nullable
    public Boolean priority;

    @Nullable
    public Boolean secret;

    @Nullable
    public Boolean readByDefault;

    @Nullable
    public Integer sortnum;

    @Nullable
    public ResourceLocation turnin;

    @Nullable
    public Map<String, Integer> extraRecipeMappings;

    @Nullable
    public String entryColor;

    public PGenEntry(
            String id,
            String name,
            ResourceLocation icon,
            ResourceLocation category,
            List<PGenPage> pages,
            @Nullable ResourceLocation advancement,
            @Nullable String flag,
            @Nullable Boolean priority,
            @Nullable Boolean secret,
            @Nullable Boolean readByDefault,
            @Nullable Integer sortnum,
            @Nullable ResourceLocation turnin,
            @Nullable Map<String, Integer> extraRecipeMappings,
            @Nullable String entryColor) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.category = category;
        this.pages = pages;
        this.advancement = advancement;
        this.flag = flag;
        this.priority = priority;
        this.secret = secret;
        this.readByDefault = readByDefault;
        this.sortnum = sortnum;
        this.turnin = turnin;
        this.extraRecipeMappings = extraRecipeMappings;
        this.entryColor = entryColor;
    }

    @Override
    public JsonElement serialize() {
        var obj = new JsonObject();
        obj.add("name", new JsonPrimitive(name));
        obj.add("icon", new JsonPrimitive(icon.toString()));
        obj.add("category", new JsonPrimitive(category.toString()));
        obj.add("pages", serializePages());
        if (advancement != null) {
            obj.add("advancement", new JsonPrimitive(advancement.toString()));
        }
        if (flag != null) {
            obj.add("flag", new JsonPrimitive(flag));
        }
        if (priority != null) {
            obj.add("priority", new JsonPrimitive(priority));
        }
        if (secret != null) {
            obj.add("secret", new JsonPrimitive(secret));
        }
        if (readByDefault != null) {
            obj.add("read_by_default", new JsonPrimitive(readByDefault));
        }
        if (sortnum != null) {
            obj.add("sortnum", new JsonPrimitive(sortnum));
        }
        if (turnin != null) {
            obj.add("turnin", new JsonPrimitive(turnin.toString()));
        }
        if (extraRecipeMappings != null && !extraRecipeMappings.isEmpty()) {
            obj.add("extra_recipe_mappings", serializeExtraRecipeMappings(extraRecipeMappings));
        }
        return obj;
    }

    private JsonArray serializePages() {
        var array = new JsonArray(pages.size());
        for (var page : pages) {
            array.add(page.serialize());
        }
        return array;
    }

    private static JsonObject serializeExtraRecipeMappings(Map<String, Integer> extraRecipeMappings) {
        var obj = new JsonObject();
        for (var entry : extraRecipeMappings.entrySet()) {
            obj.add(entry.getKey(), new JsonPrimitive(entry.getValue()));
        }
        return obj;
    }
}
