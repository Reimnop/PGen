package com.reimnop.pgen.builder;

import com.reimnop.pgen.data.PGenBook;
import com.reimnop.pgen.data.PGenLang;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PGenBookBuilder {
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

    public List<PGenLang> languages = new ArrayList<>();

    public PGenBookBuilder(ResourceLocation id, String name, String landingText, Boolean useResourcePack) {
        this.id = id;
        this.name = name;
        this.landingText = landingText;
        this.useResourcePack = useResourcePack;
    }

    public PGenBookBuilder withId(ResourceLocation id) {
        this.id = id;
        return this;
    }

    public PGenBookBuilder withId(String id) {
        return withId(ResourceLocation.fromNamespaceAndPath(this.id.getNamespace(), id));
    }

    public PGenBookBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PGenBookBuilder withLandingText(String landingText) {
        this.landingText = landingText;
        return this;
    }

    public PGenBookBuilder withUseResourcePack(Boolean useResourcePack) {
        this.useResourcePack = useResourcePack;
        return this;
    }

    public PGenBookBuilder withBookTexture(@Nullable ResourceLocation bookTexture) {
        this.bookTexture = bookTexture;
        return this;
    }

    public PGenBookBuilder withBookTexture(@Nullable String bookTexture) {
        return withBookTexture(bookTexture != null ? ResourceLocation.fromNamespaceAndPath(id.getNamespace(), bookTexture) : null);
    }

    public PGenBookBuilder withFillerTexture(@Nullable ResourceLocation fillerTexture) {
        this.fillerTexture = fillerTexture;
        return this;
    }

    public PGenBookBuilder withFillerTexture(@Nullable String fillerTexture) {
        return withFillerTexture(fillerTexture != null ? ResourceLocation.fromNamespaceAndPath(id.getNamespace(), fillerTexture) : null);
    }

    public PGenBookBuilder withCraftingTexture(@Nullable ResourceLocation craftingTexture) {
        this.craftingTexture = craftingTexture;
        return this;
    }

    public PGenBookBuilder withCraftingTexture(@Nullable String craftingTexture) {
        return withCraftingTexture(craftingTexture != null ? ResourceLocation.fromNamespaceAndPath(id.getNamespace(), craftingTexture) : null);
    }

    public PGenBookBuilder withModel(@Nullable ResourceLocation model) {
        this.model = model;
        return this;
    }

    public PGenBookBuilder withModel(@Nullable String model) {
        return withModel(model != null ? ResourceLocation.fromNamespaceAndPath(id.getNamespace(), model) : null);
    }

    public PGenBookBuilder withTextColor(@Nullable String textColor) {
        this.textColor = textColor;
        return this;
    }

    public PGenBookBuilder withHeaderColor(@Nullable String headerColor) {
        this.headerColor = headerColor;
        return this;
    }

    public PGenBookBuilder withNameplateColor(@Nullable String nameplateColor) {
        this.nameplateColor = nameplateColor;
        return this;
    }

    public PGenBookBuilder withLinkColor(@Nullable String linkColor) {
        this.linkColor = linkColor;
        return this;
    }

    public PGenBookBuilder withLinkHoverColor(@Nullable String linkHoverColor) {
        this.linkHoverColor = linkHoverColor;
        return this;
    }

    public PGenBookBuilder withProgressBarColor(@Nullable String progressBarColor) {
        this.progressBarColor = progressBarColor;
        return this;
    }

    public PGenBookBuilder withProgressBarBackground(@Nullable String progressBarBackground) {
        this.progressBarBackground = progressBarBackground;
        return this;
    }

    public PGenBookBuilder withOpenSound(@Nullable ResourceLocation openSound) {
        this.openSound = openSound;
        return this;
    }

    public PGenBookBuilder withOpenSound(@Nullable String openSound) {
        return withOpenSound(openSound != null ? ResourceLocation.fromNamespaceAndPath(id.getNamespace(), openSound) : null);
    }

    public PGenBookBuilder withFlipSound(@Nullable ResourceLocation flipSound) {
        this.flipSound = flipSound;
        return this;
    }

    public PGenBookBuilder withFlipSound(@Nullable String flipSound) {
        return withFlipSound(flipSound != null ? ResourceLocation.fromNamespaceAndPath(id.getNamespace(), flipSound) : null);
    }

    public PGenBookBuilder withIndexIcon(@Nullable ResourceLocation indexIcon) {
        this.indexIcon = indexIcon;
        return this;
    }

    public PGenBookBuilder withIndexIcon(@Nullable String indexIcon) {
        return withIndexIcon(indexIcon != null ? ResourceLocation.fromNamespaceAndPath(id.getNamespace(), indexIcon) : null);
    }

    public PGenBookBuilder withPamphlet(@Nullable Boolean pamphlet) {
        this.pamphlet = pamphlet;
        return this;
    }

    public PGenBookBuilder withShowProgress(@Nullable Boolean showProgress) {
        this.showProgress = showProgress;
        return this;
    }

    public PGenBookBuilder withVersion(@Nullable String version) {
        this.version = version;
        return this;
    }

    public PGenBookBuilder withSubtitle(@Nullable String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public PGenBookBuilder withCreativeTab(@Nullable ResourceLocation creativeTab) {
        this.creativeTab = creativeTab;
        return this;
    }

    public PGenBookBuilder withCreativeTab(@Nullable String creativeTab) {
        return withCreativeTab(creativeTab != null ? ResourceLocation.fromNamespaceAndPath(id.getNamespace(), creativeTab) : null);
    }

    public PGenBookBuilder addLanguage(PGenLang lang) {
        this.languages.add(lang);
        return this;
    }

    public PGenBookBuilder addLanguage(String name, Consumer<PGenLangBuilder> langConsumer) {
        var builder = new PGenLangBuilder(id.getNamespace(), name);
        langConsumer.accept(builder);
        return addLanguage(builder.build());
    }

    public PGenBook build() {
        return new PGenBook(
                id,
                name,
                landingText,
                useResourcePack,
                bookTexture,
                fillerTexture,
                craftingTexture,
                model,
                textColor,
                headerColor,
                nameplateColor,
                linkColor,
                linkHoverColor,
                progressBarColor,
                progressBarBackground,
                openSound,
                flipSound,
                indexIcon,
                pamphlet,
                showProgress,
                version,
                subtitle,
                creativeTab,
                languages);
    }
}
