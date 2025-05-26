package com.reimnop.pgen.builder.page;

import com.reimnop.pgen.data.PGenMultiblock;
import com.reimnop.pgen.data.page.PGenEntityPage;
import com.reimnop.pgen.data.page.PGenMultiblockPage;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class PGenEntityPageBuilder extends PGenPageBuilder<PGenEntityPageBuilder> {

    public ResourceLocation entity;

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

    public PGenEntityPageBuilder(String modId, ResourceLocation entity) {
        super(modId);
        this.entity = entity;
    }

    public PGenEntityPageBuilder withEntity(ResourceLocation entity) {
        this.entity = entity;
        return this;
    }

    public PGenEntityPageBuilder withScale(@Nullable Float scale) {
        this.scale = scale;
        return this;
    }

    public PGenEntityPageBuilder withOffset(@Nullable Float offset) {
        this.offset = offset;
        return this;
    }

    public PGenEntityPageBuilder withRotate(@Nullable Boolean rotate) {
        this.rotate = rotate;
        return this;
    }

    public PGenEntityPageBuilder withDefaultRotation(@Nullable Float defaultRotation) {
        this.defaultRotation = defaultRotation;
        return this;
    }

    public PGenEntityPageBuilder withName(@Nullable String name) {
        this.name = name;
        return this;
    }

    public PGenEntityPageBuilder withText(@Nullable String text) {
        this.text = text;
        return this;
    }

    public PGenEntityPage build() {
        return new PGenEntityPage(entity, scale, offset, rotate, defaultRotation, name, text, advancement, flag, anchor);
    }
}
