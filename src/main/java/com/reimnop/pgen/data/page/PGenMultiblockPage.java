package com.reimnop.pgen.data.page;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.reimnop.pgen.data.PGenMultiblock;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class PGenMultiblockPage extends PGenPage {

    public String name;

    @Nullable
    public ResourceLocation multiblockId;

    @Nullable
    public PGenMultiblock multiblock;

    @Nullable
    public Boolean enableVisualize;

    @Nullable
    public String text;

    public PGenMultiblockPage(
            String name,
            @Nullable ResourceLocation multiblockId,
            @Nullable PGenMultiblock multiblock,
            @Nullable Boolean enableVisualize,
            @Nullable String text,
            @Nullable ResourceLocation advancement,
            @Nullable String flag,
            @Nullable String anchor) {
        super(advancement, flag, anchor);
        this.name = name;
        this.multiblockId = multiblockId;
        this.multiblock = multiblock;
        this.enableVisualize = enableVisualize;
        this.text = text;
    }

    @Override
    protected ResourceLocation getType() {
        return patchouliPageType("multiblock");
    }

    @Override
    protected void writeToJson(JsonObject obj) {
        obj.add("name", new JsonPrimitive(name));

        if (multiblockId == null && multiblock == null) {
            throw new IllegalArgumentException("Either multiblockId or multiblock must be set");
        }

        if (multiblockId != null && multiblock != null) {
            throw new IllegalArgumentException("Only one of multiblockId or multiblock can be set");
        }

        if (multiblockId != null) {
            obj.add("multiblock_id", new JsonPrimitive(multiblockId.toString()));
        } else {
            obj.add("multiblock", multiblock.serialize());
        }

        if (enableVisualize != null) {
            obj.add("enable_visualize", new JsonPrimitive(enableVisualize));
        }

        if (text != null) {
            obj.add("text", new JsonPrimitive(text));
        }
    }
}
