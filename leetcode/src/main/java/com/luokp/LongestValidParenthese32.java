package com.luokp;

import java.util.Stack;

/**
 * @author: luokp
 * @date: 2018/12/3 22:46
 * @description:
 */
public class LongestValidParenthese32 {

    public static int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int left = -1, maxLen = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                if(st.isEmpty()){
                    left = i;
                }else{
                    st.pop();
                    if(st.isEmpty()){
                        maxLen = Math.max(maxLen, i - left);
                    }else{
                        maxLen = Math.max(maxLen, i - st.peek());
                    }
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = ")()())";
        System.out.println(longestValidParentheses(str));

    }
}
