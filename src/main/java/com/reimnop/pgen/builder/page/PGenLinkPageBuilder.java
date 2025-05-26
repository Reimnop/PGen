package com.reimnop.pgen.builder.page;

import com.reimnop.pgen.data.page.PGenLinkPage;
import org.jetbrains.annotations.Nullable;

public class PGenLinkPageBuilder extends PGenPageBuilder<PGenLinkPageBuilder> {

    public String url;
    public String linkText;
    public String text;

    @Nullable
    public String title;

    public PGenLinkPageBuilder(String modId, String url, String linkText, String text) {
        super(modId);
        this.url = url;
        this.linkText = linkText;
        this.text = text;
    }

    public PGenLinkPageBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public PGenLinkPageBuilder withLinkText(String linkText) {
        this.linkText = linkText;
        return this;
    }

    public PGenLinkPageBuilder withText(String text) {
        this.text = text;
        return this;
    }

    public PGenLinkPageBuilder withTitle(@Nullable String title) {
        this.title = title;
        return this;
    }

    public PGenLinkPage build() {
        return new PGenLinkPage(
                url,
                linkText,
                text,
                title,
                advancement,
                flag,
                anchor);
    }
}
