package com.luokp;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;

/**
 * @author: luokp
 * @date: 2019/4/15 00:01
 * @description:
 */
public class Test {
    public static int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int len1 = ver1.length;
        int len2 = ver2.length;
        int len = len1 < len2? len1:len2;
        int i = 0;
        for(; i < len; i++) {
            if(trimPrifix0(ver1[i]).compareTo(trimPrifix0(ver2[i])) != 0) {
                return trimPrifix0(ver1[i]).compareTo(trimPrifix0(ver2[i]));
            }
        }
        if(len1 < len2) {
            for(int j = i; j < len2; j++) {
                if(!"0".equals(ver2[j])) {
                    return -1;
                }
            }
        }else {
            for(int j = i; j < len1; j++) {
                if(!"0".equals(ver1[j])) {
                    return 1;
                }
            }
        }
        return 0;
    }

    private static String trimPrifix0(String s) {
        if(s == null) {return null;}
        int index = 0;
        while(index < s.length() && s.charAt(index) == '0') {
            index++;
        }
        return index == s.length()? "0" : s.substring(index, s.length());
    }
    public static void main(String[] args) {
//
        System.out.println(Math.random());
    }
}
