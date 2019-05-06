package com.luokp;

import java.util.*;

/**
 * @author: luokp
 * @date: 2019/4/30 00:28
 * @description:
 */
public class ZforTest {


    public static int calculate(String s) {

        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = 10 * num + c - '0';
            }
            if(!Character.isDigit(c) || i == s.length()-1) {
                switch (sign) {
                    case '+':
                        stack.push(num);break;
                    case '-':
                        stack.push(-num);break;
                    case '*':
                        stack.push(stack.pop() * num);break;
                    case '/':
                        stack.push(stack.pop() / num);break;
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while(!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {

       int[] arr = {1,1,1,2,2,3};
        Queue<Integer> queue = new LinkedList<>();
        Iterator i = queue.iterator();
        String s = "3+2*2";
        System.out.println(calculate(s));
        Integer.parseInt(s);

        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

    }
}
