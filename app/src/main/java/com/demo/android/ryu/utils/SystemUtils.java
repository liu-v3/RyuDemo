package com.demo.android.ryu.utils;

/**
 * @author liuweishan on 2018/10/8.
 */

public class SystemUtils {
    private static final int CUP_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = Math.max(2, Math.min(CUP_COUNT - 1, 4));
    private static final long CORE_TOTAL_MEMORY = Runtime.getRuntime().totalMemory();

    public static int getCupCount() {
        return CUP_COUNT;
    }

    public static long getEnableMemory() {
        return CORE_TOTAL_MEMORY / 8;
    }
}
