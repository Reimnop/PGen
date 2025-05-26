package com.reimnop.pgen.builder;

import com.reimnop.pgen.data.PGenCategory;
import com.reimnop.pgen.data.PGenEntry;
import com.reimnop.pgen.data.PGenLang;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PGenLangBuilder {
    public String modId;

    public String name;

    public List<PGenCategory> categories = new ArrayList<>();
    public List<PGenEntry> entries = new ArrayList<>();

    public PGenLangBuilder(String modId, String name) {
        this.modId = modId;
        this.name = name;
    }

    public PGenLangBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PGenLangBuilder addCategory(PGenCategory category) {
        this.categories.add(category);
        return this;
    }

    public PGenLangBuilder addCategory(
            String id,
            String name,
            String description,
            ResourceLocation icon,
            Consumer<PGenCategoryBuilder> consumer) {
        var builder = new PGenCategoryBuilder(modId, id, name, description, icon);
        consumer.accept(builder);
        return addCategory(builder.build());
    }

    public PGenLangBuilder addEntry(PGenEntry entry) {
        this.entries.add(entry);
        return this;
    }

    public PGenLangBuilder addEntry(
            String id,
            String name,
            ResourceLocation icon,
            ResourceLocation category,
            Consumer<PGenEntryBuilder> consumer) {
        var builder = new PGenEntryBuilder(modId, id, name, icon, category);
        consumer.accept(builder);
        return addEntry(builder.build());
    }

    public PGenLang build() {
        return new PGenLang(name, categories, entries);
    }
}
