package com.luokp;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: luokp
 * @date: 2019/4/15 00:39
 * @description:
 */
public class Polish {
    public static  int evalRPN(String[] tokens) {
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            stack1.push(tokens[i]);
        }
        int numberCount = 0;
        while(!stack1.empty()) {
            String str = stack1.pop();
            switch(str) {
                case "+" : stack2.push(str); numberCount = 0;break;
                case "-" : stack2.push(str); numberCount = 0;break;
                case "*" : stack2.push(str); numberCount = 0;break;
                case "/" : stack2.push(str); numberCount = 0;break;
                default :
                    if(numberCount == 1) {
                        int num1 = Integer.parseInt(str);
                        String s = null;
                        while(!stack2.empty() && (s = stack2.peek()) != "+" && s != "-" && s != "*" && s != "/") {
                            int num2 = Integer.parseInt(stack2.pop());
                            switch(stack2.pop()) {
                                case "+" : num1 = num1 + num2;break;
                                case "-" : num1 = num1 - num2;break;
                                case "*" : num1 = num1 * num2;break;
                                case "/" : num1 = num1 / num2;break;
                            }
                        }
                        stack2.push(String.valueOf(num1));
                    }else {
                        stack2.push(str);
                        numberCount = 1;
                    }
            }
        }
        return Integer.parseInt(stack2.pop());
    }

    public static void main(String[] args) {
        String[] arr = {"4","13","5","/","+"};
        System.out.println(evalRPN(arr));
        String s = "a good   example";
        String[] w = s.split(" ");
        System.out.println(Arrays.toString(w));
    }
}
