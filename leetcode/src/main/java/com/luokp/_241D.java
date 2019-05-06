package com.luokp;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.*;

/**
 * @author: luokp
 * @date: 2019/4/27 23:34
 * @description:
 */
public class _241D {
    public static List<Integer> diffWaysToCompute(String s) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return res;
        }
        int len = s.length();
        for(int index = 0; index < s.length(); index++) {
            if(!Character.isDigit(s.charAt(index))) {
                String before = s.substring(0, index);
                String behind = s.substring(index+1, len);
                List<Integer> part1 = diffWaysToCompute(before);
                List<Integer> part2 = diffWaysToCompute(behind);
                for(Integer p1 : part1)
                    for(Integer p2 : part2) {
                        int p = 0;
                        switch (s.charAt(index)) {
                            case '+' : p = p1 + p2;break;
                            case '-' : p = p1 - p2;break;
                            case '*' : p = p1 * p2;break;
                        }
                        res.add(p);
                    }

            }

        }
        if(res.size() == 0) {
            res.add(Integer.parseInt(s));
        }
        return res;
    }

    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> operand = new Stack<>();
        Stack<Integer> operator = new Stack<>();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                num = num*10 + s.charAt(i) - '0';
            }
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length()-1) {
                if(sign == '+') {
                    operand.push(num);
                }
                if(sign == '-') {
                    operand.push(-num);
                }
                if(sign == '*') {
                    operand.push(num * operand.pop());
                }
                if(sign == '/') {
                    operand.push(operand.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int ret = 0;
        while(!operand.empty()) {
            ret += operand.pop();
        }
        return ret;
    }

    private static List<String> insertParenthese(String s) {
        List<String> list = new ArrayList<>();
        if(!containsOperater(s)) {
            list.add(s);
            return list;
        }
        int index = 0;
        for(; index < s.length(); index++) {
            if(!Character.isDigit(s.charAt(index))) {
                String prifix = s.substring(0, index);
                StringBuilder sb = new StringBuilder();
                if(containsOperater(prifix)) {
                    prifix = sb.append("(").append(prifix).append(")").append(s.charAt(index)).toString();
                }else {
                    prifix = sb.append(prifix).append(s.charAt(index)).toString();
                }
                List<String> exps = insertParenthese(s.substring(index+1, s.length()));
                for(String str : exps) {
                    StringBuilder sb1 = new StringBuilder();
                    list.add(sb1.append("(").append(prifix).append(str).append(")").toString());
                }
            }
        }
        return list;
    }

    private static boolean containsOperater(String s) {
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c == '/') {
                return true;
            }
        }

            return false;

    }

    private static boolean hasOneOperater(String s) {
        int cnt = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c == '/') {
                cnt--;
            }
            if(cnt < 0) {
                return false;
            }
        }
        if(cnt == 0) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "2*3-4*5";
        System.out.println(diffWaysToCompute(s));
    }
}
