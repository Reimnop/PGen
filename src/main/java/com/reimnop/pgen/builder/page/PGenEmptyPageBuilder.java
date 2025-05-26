package com.reimnop.pgen.builder.page;

import com.reimnop.pgen.data.page.PGenEmptyPage;
import org.jetbrains.annotations.Nullable;

public class PGenEmptyPageBuilder extends PGenPageBuilder<PGenEmptyPageBuilder> {

    @Nullable
    public Boolean drawFiller;

    public PGenEmptyPageBuilder(String modId) {
        super(modId);
    }

    public PGenEmptyPageBuilder withDrawFiller(@Nullable Boolean drawFiller) {
        this.drawFiller = drawFiller;
        return this;
    }

    public PGenEmptyPage build() {
        return new PGenEmptyPage(drawFiller, advancement, flag, anchor);
    }
}
