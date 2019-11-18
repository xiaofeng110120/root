package com.local.admin.service.util;

import java.util.HashMap;
import java.util.Map;

public class MapContext {

    private static final MapThreadLocal MAP_CONTEXT = new MapThreadLocal();

    private static class MapThreadLocal extends ThreadLocal<Map<String, Object>> {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<String, Object>(16) {
                @Override
                public Object put(String key, Object value) {
                    return super.put(key, value);
                }
            };
        }
    }

    public static Object get(String key) {
        return getContextMap().get(key);
    }

    public static void set(String key, Object value) {
        getContextMap().put(key, value);
    }

    public static void remove() {
        getContextMap().clear();
    }

    private static Map<String, Object> getContextMap() {
        return MAP_CONTEXT.get();
    }


}
