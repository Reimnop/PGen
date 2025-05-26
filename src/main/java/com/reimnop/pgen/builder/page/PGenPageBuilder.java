package com.reimnop.pgen.builder.page;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unchecked")
public abstract class PGenPageBuilder<T extends PGenPageBuilder<T>> {
    public String modId;

    @Nullable
    public ResourceLocation advancement;

    @Nullable
    public String flag;

    @Nullable
    public String anchor;

    protected PGenPageBuilder(String modId) {
        this.modId = modId;
    }

    public T withAdvancement(@Nullable ResourceLocation advancement) {
        this.advancement = advancement;
        return (T)this;
    }

    public T withAdvancement(@Nullable String advancement) {
        return withAdvancement(advancement != null ? ResourceLocation.fromNamespaceAndPath(modId, advancement) : null);
    }

    public T withFlag(@Nullable String flag) {
        this.flag = flag;
        return (T)this;
    }

    public T withAnchor(@Nullable String anchor) {
        this.anchor = anchor;
        return (T)this;
    }
}
