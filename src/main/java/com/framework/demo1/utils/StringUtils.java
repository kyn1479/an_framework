package com.framework.demo1.utils;

/**
 * @Author: Kang Yanan
 * @Date: 2020/12/14 20:30
 * @Description:
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

    public static boolean isNotBlank(String str) {
        return !org.apache.commons.lang.StringUtils.isBlank(str);
    }
}
