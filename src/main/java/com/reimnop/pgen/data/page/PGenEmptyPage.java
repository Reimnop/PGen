package com.reimnop.pgen.data.page;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class PGenEmptyPage extends PGenPage {

    @Nullable
    public Boolean drawFiller;

    public PGenEmptyPage(
            @Nullable Boolean drawFiller,
            @Nullable ResourceLocation advancement,
            @Nullable String flag,
            @Nullable String anchor) {
        super(advancement, flag, anchor);
        this.drawFiller = drawFiller;
    }

    @Override
    protected ResourceLocation getType() {
        return patchouliPageType("empty");
    }

    @Override
    protected void writeToJson(JsonObject obj) {
        if (drawFiller != null) {
            obj.add("draw_filler", new JsonPrimitive(drawFiller));
        }
    }
}
