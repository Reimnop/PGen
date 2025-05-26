package com.reimnop.pgen.builder.page;

import com.reimnop.pgen.data.page.PGenImagePage;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PGenImagePageBuilder extends PGenPageBuilder<PGenImagePageBuilder> {

    public List<ResourceLocation> images = new ArrayList<>();

    @Nullable
    public Boolean border;

    @Nullable
    public String text;

    @Nullable
    public String title;

    public PGenImagePageBuilder(String modId) {
        super(modId);
    }

    public PGenImagePageBuilder addImage(ResourceLocation image) {
        this.images.add(image);
        return this;
    }

    public PGenImagePageBuilder addImage(String image) {
        return addImage(ResourceLocation.fromNamespaceAndPath(modId, image));
    }

    public PGenImagePageBuilder withBorder(@Nullable Boolean border) {
        this.border = border;
        return this;
    }

    public PGenImagePageBuilder withText(@Nullable String text) {
        this.text = text;
        return this;
    }

    public PGenImagePageBuilder withTitle(@Nullable String title) {
        this.title = title;
        return this;
    }

    public PGenImagePage build() {
        return new PGenImagePage(images, border, text, title, advancement, flag, anchor);
    }
}
