package com.reimnop.pgen.builder.page;

import com.reimnop.pgen.data.page.PGenQuestPage;
import org.jetbrains.annotations.Nullable;

public class PGenQuestPageBuilder extends PGenPageBuilder<PGenQuestPageBuilder> {

    @Nullable
    public String trigger;

    @Nullable
    public String text;

    @Nullable
    public String title;

    public PGenQuestPageBuilder(String modId) {
        super(modId);
    }

    public PGenQuestPageBuilder withTrigger(@Nullable String trigger) {
        this.trigger = trigger;
        return this;
    }

    public PGenQuestPageBuilder withText(@Nullable String text) {
        this.text = text;
        return this;
    }

    public PGenQuestPageBuilder withTitle(@Nullable String title) {
        this.title = title;
        return this;
    }

    public PGenQuestPage build() {
        return new PGenQuestPage(trigger, text, title, advancement, flag, anchor);
    }
}
