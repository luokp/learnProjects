package com.luokp;

/**
 * @author: luokp
 * @date: 2018/12/10 21:57
 * @description:
 */
public class _43MultiplyString {

    public static String multiply(String num1, String num2) {
        String result = "";
        for(int i = num1.length() - 1; i >= 0; i--) {
            String temp = multiply_char(num2, num1.charAt(i),  num1.length() - 1 - i);
            result = plus(result, temp);
        }
        return result;
    }

    public static String multiply_char(String num, char singleNum, int weight){
        if(singleNum == '0') {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int single = singleNum - '0';
        int carry = 0;
        for(int i = num.length() - 1; i >= 0; i--) {
            int temp = (num.charAt(i) - '0') * single + carry;
            sb.insert(0, temp % 10 );
            carry = temp / 10;
        }
        if(carry != 0) {
            sb.insert(0, carry);
        }
        for(int i = 0; i < weight; i++){
            sb.append("0");
        }
        return sb.toString();
    }

    public static String plus(String num1, String num2) {
        if(num1.equals("0") || num1 == null) {
            return num2;
        }
        if(num2.equals("0") || num2 == null) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        for(; i >= 0 && j >= 0; i--, j--){
            int temp = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
            carry = temp / 10;
            sb.insert(0, temp % 10);
        }
        while(i >= 0){
            int temp = num1.charAt(i) - '0' + carry;
            carry = temp / 10;
            sb.insert(0, temp % 10);
            i--;
        }
        while(j >= 0){
            int temp = num2.charAt(j) - '0' + carry;
            carry = temp / 10;
            sb.insert(0, temp % 10);
            j--;
        }
        if(carry != 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));

    }
}
