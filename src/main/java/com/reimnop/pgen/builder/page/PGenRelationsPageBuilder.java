package com.reimnop.pgen.builder.page;

import com.reimnop.pgen.data.page.PGenRelationsPage;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PGenRelationsPageBuilder extends PGenPageBuilder<PGenRelationsPageBuilder> {

    public List<ResourceLocation> entries = new ArrayList<>();

    @Nullable
    public String text;

    @Nullable
    public String title;

    public PGenRelationsPageBuilder(String modId) {
        super(modId);
    }

    public PGenRelationsPageBuilder addEntry(ResourceLocation entry) {
        this.entries.add(entry);
        return this;
    }

    public PGenRelationsPageBuilder addEntry(String entry) {
        return addEntry(ResourceLocation.fromNamespaceAndPath(modId, entry));
    }

    public PGenRelationsPageBuilder withText(@Nullable String text) {
        this.text = text;
        return this;
    }

    public PGenRelationsPageBuilder withTitle(@Nullable String title) {
        this.title = title;
        return this;
    }

    public PGenRelationsPage build() {
        return new PGenRelationsPage(
                entries.isEmpty() ? null : entries,
                text,
                title,
                advancement,
                flag,
                anchor);
    }
}
