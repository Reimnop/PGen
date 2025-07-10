package com.reimnop.pgen.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

public class PGenItemStackDefinition {
    public ResourceLocation id;

    @Nullable
    public Integer count;

    @Nullable
    public CompoundTag nbtData;

    public PGenItemStackDefinition(ResourceLocation id, @Nullable Integer count, @Nullable CompoundTag nbtData) {
        this.id = id;
        this.count = count;
        this.nbtData = nbtData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(id.toString());
        if (count != null) {
            sb.append("#").append(count);
        }
        if (nbtData != null) {
            sb.append(nbtData);
        }
        return sb.toString();
    }
}
