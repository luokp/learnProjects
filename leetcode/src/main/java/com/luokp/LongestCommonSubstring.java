package com.luokp;

import java.util.Arrays;

/**
 * @author: luokp
 * @date: 2019/4/10 13:39
 * @description:
 */
public class LongestCommonSubstring {

    public static String longestCommonSubstring(String s1, String s2) {
        if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return null;
        }
        int[][] C = new int[s1.length()+1][s2.length()+1];
        int biggest = 0;
        for(int i = 0; i <= s1.length(); i++)
            for (int j = 0; j <= s2.length(); j++) {
                if(i == 0 || j == 0) {
                    C[i][j] = 0;
                }else
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    C[i][j] = C[i-1][j-1] + 1;
                    biggest = Math.max(biggest, C[i][j]);
                }
            }
        System.out.println("biggest: " + biggest);
        for (int i = 0; i < C.length; i++) {
            System.out.println(Arrays.toString(C[i]));
        }
            StringBuilder sb = new StringBuilder();
        mark:
        for (int i = s1.length(); i > 0 ; i--)
            for (int j = s2.length(); j > 0 ; j--) {
                if(C[i][j] == C[i-1][j-1] + 1) {
                    while(C[i][j] != 0) {
                        sb.insert(0, s1.charAt(i-1));
                        i--;
                        j--;
                    }
                    break mark;
                }
            }
            return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "asefas";
        String s2 = "werasdfaswer";
        System.out.println(longestCommonSubstring(s1, s2));
    }
}
