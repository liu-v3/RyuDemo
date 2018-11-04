package com.demo.android.ryu.utils;

/**
 * @author liuweishan on 2018/9/28.
 */

public class StringUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }
}
