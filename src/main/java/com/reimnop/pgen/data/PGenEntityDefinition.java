package com.reimnop.pgen.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

public class PGenEntityDefinition {
    public ResourceLocation id;

    @Nullable
    public CompoundTag nbtData;

    public PGenEntityDefinition(ResourceLocation id, @Nullable CompoundTag nbtData) {
        this.id = id;
        this.nbtData = nbtData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(id.toString());
        if (nbtData != null) {
            sb.append(nbtData);
        }
        return sb.toString();
    }
}
