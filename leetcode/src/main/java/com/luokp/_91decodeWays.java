package com.luokp;

/**
 * @author: luokp
 * @date: 2019/4/2 15:56
 * @description:
 */
public class _91decodeWays {
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') {return 0;}
        return decode(s, 0);
    }

    public static int decode(String s, int start) {
        if(s == null || s.length() == 0) {return 0;}
        if(start == s.length()) {
            return 1;
        }
        if(s.charAt(start) == '0') {return 0;}
        int num1 = 0, num2 = 0, num3 = 0;
        if(start < s.length()) {
            num1 = decode(s, start+1);
        }
        if(start < s.length() - 1) {
            if(s.charAt(start) == '1') {
                num2 = decode(s, start + 2);
            }
            if(s.charAt(start) == '2' && s.charAt(start+1) - '0' < 7) {
                num3 = decode(s, start + 2);
            }
        }
        return num1 + num2 + num3;
    }

    public static void main(String[] args) {
        String s = "12120";
        System.out.println(numDecodings(s));
    }
}
