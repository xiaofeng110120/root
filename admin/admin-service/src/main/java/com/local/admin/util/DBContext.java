package com.local.admin.util;

public class DBContext {

    private static final ThreadLocal<String> DB_CONTEXT = new ThreadLocal<>();

    public static String get() {
        return DB_CONTEXT.get();
    }

    public static void set(String db) {
        DB_CONTEXT.set(db);
    }

    public static void remove() {
        DB_CONTEXT.remove();
    }

}
