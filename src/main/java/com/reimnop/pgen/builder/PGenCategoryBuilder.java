package com.reimnop.pgen.builder;

import com.reimnop.pgen.data.PGenCategory;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class PGenCategoryBuilder {
    public String modId;

    public String id;

    public String name;
    public String description;
    public ResourceLocation icon;

    @Nullable
    public ResourceLocation parent;

    @Nullable
    public String flag;

    @Nullable
    public Integer sortnum;

    @Nullable
    public Boolean secret;

    public PGenCategoryBuilder(String modId, String id, String name, String description, ResourceLocation icon) {
        this.modId = modId;
        this.id = id;
        this.name = name;
        this.description = description;
        this.icon = icon;
    }

    public PGenCategoryBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public PGenCategoryBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public PGenCategoryBuilder withIcon(ResourceLocation icon) {
        this.icon = icon;
        return this;
    }

    public PGenCategoryBuilder withIcon(String icon) {
        return withIcon(ResourceLocation.fromNamespaceAndPath(modId, icon));
    }

    public PGenCategoryBuilder withParent(@Nullable ResourceLocation parent) {
        this.parent = parent;
        return this;
    }

    public PGenCategoryBuilder withParent(@Nullable String parent) {
        return withParent(parent != null ? ResourceLocation.fromNamespaceAndPath(modId, parent) : null);
    }

    public PGenCategoryBuilder withFlag(@Nullable String flag) {
        this.flag = flag;
        return this;
    }

    public PGenCategoryBuilder withSortnum(@Nullable Integer sortnum) {
        this.sortnum = sortnum;
        return this;
    }

    public PGenCategoryBuilder withSecret(@Nullable Boolean secret) {
        this.secret = secret;
        return this;
    }

    public PGenCategory build() {
        return new PGenCategory(id, name, description, icon, parent, flag, sortnum, secret);
    }
}
