package com.reimnop.pgen.data;

import java.util.List;

public class PGenLang {
    public String name;
    public List<PGenCategory> categories;
    public List<PGenEntry> entries;

    public PGenLang(String name, List<PGenCategory> categories, List<PGenEntry> entries) {
        this.name = name;
        this.categories = categories;
        this.entries = entries;
    }
}
