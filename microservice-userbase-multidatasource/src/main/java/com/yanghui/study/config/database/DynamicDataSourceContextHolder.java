package com.yanghui.study.config.database;

public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> CURRENT = new ThreadLocal<>();

    /**
     * 清除当前数据源
     */
    public static void clear() {
        CURRENT.remove();
    }

    /**
     * 获取当前使用的数据源
     *
     * @return 当前使用数据源的ID
     */
    public static String get() {
        return CURRENT.get();
    }

    /**
     * 设置当前使用的数据源
     *
     * @param value 需要设置的数据源ID
     */
    public static void set(String value) {
        CURRENT.set(value);
    }
}