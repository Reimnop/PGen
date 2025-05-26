package com.reimnop.pgen.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.reimnop.pgen.PGenSerializable;

import java.util.List;
import java.util.Map;

public class PGenMultiblock implements PGenSerializable {
    public List<List<String>> pattern;
    public Map<String, String> mapping;

    public PGenMultiblock(List<List<String>> pattern, Map<String, String> mapping) {
        this.pattern = pattern;
        this.mapping = mapping;
    }

    @Override
    public JsonElement serialize() {
        var obj = new JsonObject();
        obj.add("pattern", serializePattern());
        obj.add("mapping", serializeMapping());
        return obj;
    }

    private JsonArray serializePattern() {
        var arr = new JsonArray(pattern.size());
        for (var pattern1 : pattern) {
            var arr1 = new JsonArray(pattern1.size());
            for (var pattern2 : pattern1) {
                arr1.add(pattern2);
            }
            arr.add(arr1);
        }
        return arr;
    }

    private JsonObject serializeMapping() {
        var obj = new JsonObject();
        for (var entry : mapping.entrySet()) {
            obj.addProperty(entry.getKey(), entry.getValue());
        }
        return obj;
    }
}
