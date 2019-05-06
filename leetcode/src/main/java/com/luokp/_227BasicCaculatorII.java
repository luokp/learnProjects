package com.luokp;

import java.util.Stack;

/**
 * @author: luokp
 * @date: 2019/4/25 16:50
 * @description:
 */
public class _227BasicCaculatorII {
    public static int calculate2(String s) {
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

//    public static int calculate1(String s) {
//        if(s == null || s.length() == 0) {
//            return 0;
//        }
//        int sum = 0;
//        int num = 0;
//        char sign = '+';
//        int len = s.length();
//        for(int i = 0; i < len;) {
//            int index = i;
//            if(Character.isDigit(s.charAt(i))) {
//                num = 10*num + s.charAt(i) - '0';
//            }
//            if(s.charAt(i) == '(') {
//                int cnt = 0;
//                for(; index < len; index++) {
//                    if(s.charAt(index) == '(') {
//                        cnt++;
//                    }
//                    if(s.charAt(index) == ')') {
//                        cnt--;
//                    }
//                    if(cnt == 0) {
//                        break;
//                    }
//                }
//                num = calculate1(s.substring(i+1, index));
//            }
//            if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == len - 1) {
//                if(sign == '+') {
//                    sum += num;
//                }
//                if(sign == '-') {
//                    sum -= num;
//                }
//                sign = s.charAt(i);
//                num = 0;
//            }
//            i = index + 1;
//
//        }
//        return sum;
//    }

    public static int calculate1(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        Stack stack = new Stack();
        int sum = 0;
        int num = 0;
        char sign = '+';
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if(Character.isDigit(s.charAt(i))) {
                num = 10*num + s.charAt(i) - '0';
            }else if(s.charAt(i) == ' ') {
                continue;
            }else if(s.charAt(i) == '(') {
                stack.push(sign);
                stack.push(sum);
                sum = 0;
                sign = '+';
            }else if(s.charAt(i) == ')') {
                sum = sign == '+' ? sum + num:sum - num;
                num = sum;
                sum = (int)stack.pop();
                sign = (char)stack.pop();
            }else if(sign == '+') {
                sum += num;
                sign = s.charAt(i);
                num = 0;
            }else if(sign == '-') {
                sum -= num;
                sign = s.charAt(i);
                num = 0;
            }
        }
        if(num != 0) {
            sum = sign == '+' ? sum + num:sum - num;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate1(s));
//        int num = calculate();
        StringBuilder sb = new StringBuilder();
        sb.append("123");
        sb.delete(0,3);
        System.out.println(sb.toString());

    }
}
