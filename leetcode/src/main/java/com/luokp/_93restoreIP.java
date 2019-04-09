package com.luokp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: luokp
 * @date: 2019/4/2 22:27
 * @description:
 */
public class _93restoreIP {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        restore(result, s, 0, 1, sb);
        return result;
    }

    public static void restore(List<String> list, String s, int index, int part, StringBuilder sb) {
        if(s == null || s.length() == 0 || s.length() < 4) {
            return;
        }
        if(part > 5 || index > s.length()) {return;}
        // if(part < 4 && index == s.length()) {return;}
        if(part == 5 && index == s.length()) {
            list.add(sb.toString());
            return;
        }
        if(index < s.length()) {
            sb.append(s.substring(index, index + 1));
            if(part != 4) {
                sb.append(".");
            }
            restore(list, s, index+1, part+1, sb);
            if(part != 4) {
                sb.delete(sb.length()-2, sb.length());
            }else {
                sb.delete(sb.length()-1, sb.length());
            }
        }

        if(index + 1 < s.length() && s.charAt(index) != '0') {
            sb.append(s.substring(index, index + 2));
            if(part != 4) {
                sb.append(".");
            }
            restore(list, s, index+2, part+1, sb);
            if(part != 4) {
                sb.delete(sb.length()-3, sb.length());
            }else {
                sb.delete(sb.length()-2, sb.length());
            }
        }

        if(index + 2 < s.length() && s.charAt(index) != '0' && Integer.parseInt(s.substring(index, index + 3)) < 256) {
            sb.append(s.substring(index, index + 3));
            if(part != 4) {
                sb.append(".");
            }
            restore(list, s, index+3, part+1, sb);
            if(part != 4) {
                sb.delete(sb.length()-4, sb.length());
            }else {
                sb.delete(sb.length()-3, sb.length());
            }
        }
        return;
    }

    public static void main(String[] args) {
        String s = "9999999";
        System.out.println(restoreIpAddresses(s));
        StringBuilder sb = new StringBuilder();
    }
}
