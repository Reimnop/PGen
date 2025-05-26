package com.reimnop.pgen.builder.page;

import com.reimnop.pgen.data.page.PGenTextPage;
import org.jetbrains.annotations.Nullable;

public class PGenTextPageBuilder extends PGenPageBuilder<PGenTextPageBuilder> {

    public String text;

    @Nullable
    public String title;

    public PGenTextPageBuilder(String modId, String text) {
        super(modId);
        this.text = text;
    }

    public PGenTextPageBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public PGenTextPageBuilder withTitle(@Nullable String title) {
        this.title = title;
        return this;
    }

    public PGenTextPage build() {
        return new PGenTextPage(text, title, advancement, flag, anchor);
    }
}
