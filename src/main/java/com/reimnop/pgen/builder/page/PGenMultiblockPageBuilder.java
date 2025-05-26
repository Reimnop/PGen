package com.reimnop.pgen.builder.page;

import com.reimnop.pgen.data.PGenMultiblock;
import com.reimnop.pgen.data.page.PGenMultiblockPage;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class PGenMultiblockPageBuilder extends PGenPageBuilder<PGenMultiblockPageBuilder> {

    public String name;

    @Nullable
    public ResourceLocation multiblockId;

    @Nullable
    public PGenMultiblock multiblock;

    @Nullable
    public Boolean enableVisualize;

    @Nullable
    public String text;

    public PGenMultiblockPageBuilder(String modId, String name) {
        super(modId);
        this.name = name;
    }

    public PGenMultiblockPageBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PGenMultiblockPageBuilder withMultiblockId(@Nullable ResourceLocation multiblockId) {
        this.multiblockId = multiblockId;
        return this;
    }

    public PGenMultiblockPageBuilder withMultiblockId(@Nullable String multiblockId) {
        return withMultiblockId(multiblockId != null ? ResourceLocation.fromNamespaceAndPath(modId, multiblockId) : null);
    }

    public PGenMultiblockPageBuilder withMultiblock(@Nullable PGenMultiblock multiblock) {
        this.multiblock = multiblock;
        return this;
    }

    public PGenMultiblockPageBuilder withEnableVisualize(@Nullable Boolean enableVisualize) {
        this.enableVisualize = enableVisualize;
        return this;
    }

    public PGenMultiblockPageBuilder withText(@Nullable String text) {
        this.text = text;
        return this;
    }

    public PGenMultiblockPage build() {
        return new PGenMultiblockPage(name, multiblockId, multiblock, enableVisualize, text, advancement, flag, anchor);
    }
}
