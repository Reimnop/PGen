package com.reimnop.pgen.data.page;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class PGenLinkPage extends PGenTextPage {

    public String url;
    public String linkText;

    public PGenLinkPage(
            String url,
            String linkText,
            String text,
            @Nullable String title,
            @Nullable ResourceLocation advancement,
            @Nullable String flag,
            @Nullable String anchor) {
        super(text, title, advancement, flag, anchor);
        this.url = url;
        this.linkText = linkText;
    }

    @Override
    protected ResourceLocation getType() {
        return patchouliPageType("link");
    }

    @Override
    protected void writeToJson(JsonObject obj) {
        super.writeToJson(obj);
        obj.add("url", new JsonPrimitive(url));
        obj.add("link_text", new JsonPrimitive(linkText));
    }
}
