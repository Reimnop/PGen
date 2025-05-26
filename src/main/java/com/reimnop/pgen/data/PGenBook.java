package com.reimnop.pgen.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.reimnop.pgen.PGenSerializable;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PGenBook implements PGenSerializable {
    public ResourceLocation id;

    public String name;
    public String landingText;
    public Boolean useResourcePack;

    @Nullable
    public ResourceLocation bookTexture;

    @Nullable
    public ResourceLocation fillerTexture;

    @Nullable
    public ResourceLocation craftingTexture;

    @Nullable
    public ResourceLocation model;

    @Nullable
    public String textColor;

    @Nullable
    public String headerColor;

    @Nullable
    public String nameplateColor;

    @Nullable
    public String linkColor;

    @Nullable
    public String linkHoverColor;

    @Nullable
    public String progressBarColor;

    @Nullable
    public String progressBarBackground;

    @Nullable
    public ResourceLocation openSound;

    @Nullable
    public ResourceLocation flipSound;

    @Nullable
    public ResourceLocation indexIcon;

    @Nullable
    public Boolean pamphlet;

    @Nullable
    public Boolean showProgress;

    @Nullable
    public String version;

    @Nullable
    public String subtitle;

    @Nullable
    public ResourceLocation creativeTab;

    public List<PGenLang> languages;

    public PGenBook(
            ResourceLocation id,
            String name,
            String landingText,
            Boolean useResourcePack,
            @Nullable ResourceLocation bookTexture,
            @Nullable ResourceLocation fillerTexture,
            @Nullable ResourceLocation craftingTexture,
            @Nullable ResourceLocation model,
            @Nullable String textColor,
            @Nullable String headerColor,
            @Nullable String nameplateColor,
            @Nullable String linkColor,
            @Nullable String linkHoverColor,
            @Nullable String progressBarColor,
            @Nullable String progressBarBackground,
            @Nullable ResourceLocation openSound,
            @Nullable ResourceLocation flipSound,
            @Nullable ResourceLocation indexIcon,
            @Nullable Boolean pamphlet,
            @Nullable Boolean showProgress,
            @Nullable String version,
            @Nullable String subtitle,
            @Nullable ResourceLocation creativeTab,
            List<PGenLang> languages) {
        this.id = id;
        this.name = name;
        this.landingText = landingText;
        this.useResourcePack = useResourcePack;
        this.bookTexture = bookTexture;
        this.fillerTexture = fillerTexture;
        this.craftingTexture = craftingTexture;
        this.model = model;
        this.textColor = textColor;
        this.headerColor = headerColor;
        this.nameplateColor = nameplateColor;
        this.linkColor = linkColor;
        this.linkHoverColor = linkHoverColor;
        this.progressBarColor = progressBarColor;
        this.progressBarBackground = progressBarBackground;
        this.openSound = openSound;
        this.flipSound = flipSound;
        this.indexIcon = indexIcon;
        this.pamphlet = pamphlet;
        this.showProgress = showProgress;
        this.version = version;
        this.subtitle = subtitle;
        this.creativeTab = creativeTab;
        this.languages = languages;
    }

    public JsonElement serialize() {
        var obj = new JsonObject();
        obj.add("name", new JsonPrimitive(name));
        obj.add("landing_text", new JsonPrimitive(landingText));
        obj.add("use_resource_pack", new JsonPrimitive(useResourcePack));
        if (bookTexture != null) {
            obj.add("book_texture", new JsonPrimitive(bookTexture.toString()));
        }
        if (fillerTexture != null) {
            obj.add("filler_texture", new JsonPrimitive(fillerTexture.toString()));
        }
        if (craftingTexture != null) {
            obj.add("crafting_texture", new JsonPrimitive(craftingTexture.toString()));
        }
        if (model != null) {
            obj.add("model", new JsonPrimitive(model.toString()));
        }
        if (textColor != null) {
            obj.add("text_color", new JsonPrimitive(textColor));
        }
        if (headerColor != null) {
            obj.add("header_color", new JsonPrimitive(headerColor));
        }
        if (nameplateColor != null) {
            obj.add("nameplate_color", new JsonPrimitive(nameplateColor));
        }
        if (linkColor != null) {
            obj.add("link_color", new JsonPrimitive(linkColor));
        }
        if (linkHoverColor != null) {
            obj.add("link_hover_color", new JsonPrimitive(linkHoverColor));
        }
        if (progressBarColor != null) {
            obj.add("progress_bar_color", new JsonPrimitive(progressBarColor));
        }
        if (progressBarBackground != null) {
            obj.add("progress_bar_background", new JsonPrimitive(progressBarBackground));
        }
        if (openSound != null) {
            obj.add("open_sound", new JsonPrimitive(openSound.toString()));
        }
        if (flipSound != null) {
            obj.add("flip_sound", new JsonPrimitive(flipSound.toString()));
        }
        if (indexIcon != null) {
            obj.add("index_icon", new JsonPrimitive(indexIcon.toString()));
        }
        if (pamphlet != null) {
            obj.add("pamphlet", new JsonPrimitive(pamphlet));
        }
        if (showProgress != null) {
            obj.add("show_progress", new JsonPrimitive(showProgress));
        }
        if (version != null) {
            obj.add("version", new JsonPrimitive(version));
        }
        if (subtitle != null) {
            obj.add("subtitle", new JsonPrimitive(subtitle));
        }
        if (creativeTab != null) {
            obj.add("creative_tab", new JsonPrimitive(creativeTab.toString()));
        }
        return obj;
    }
}
