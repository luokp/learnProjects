package com.luokp;

import java.util.*;

/**
 * @author: luokp
 * @date: 2019/3/29 16:35
 * @description:
 */
public class Conbination {

    public static void conbinationByByte(int[] nums, List<String> result) {
        if(nums == null) {
            return;
        }
        int len = nums.length;
        long cnt = (long)Math.pow(2, len) - 1;
        for(int i = 1; i <= cnt; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < len; j++) {
                int temp = 1 << j;
                if((i & temp) != 0) {
                    sb.append(nums[j]);
                }
            }
            result.add(sb.toString());
        }
    }

    //递归
    public static void conbination_k(int[] nums, int start, int k, StringBuilder sb, List<String> result) {
        if(nums == null ) {
            return;
        }
        if(k == 0) {
            result.add(sb.toString());
        }
        for (int i = start; i < nums.length; i++) {
            sb.append(nums[i]);
            conbination_k(nums, i+1, k-1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void conbination(int[] nums, List<String> result) {
        if(nums == null) {
            return ;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= nums.length; i++) {
            conbination_k(nums, 0, i, sb, result);
        }
    }

    public static List<List<Integer>>  conbinationTOk(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n <= 0 || n < k || k <= 0) {
            return result;
        }
        long cnt = 1 << n;
        for(int i = 1; i < cnt; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                int temp = 1 << j;
                if((i & temp) != 0) {
                    list.add(j+1);
                }
            }
            if(list.size() == k) {
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int[] nums = {1,2,3,};
        conbination(nums, list);
        System.out.println(list);
        System.out.println(conbinationTOk(3, 1));
        char[] d = new char[1];
        d[0] = (char)(nums[0]+49);
        System.out.println(d[0]);

        long cnt = (long)Math.pow(2, 2) - 1;
        System.out.println(cnt);
        System.out.println(1 << 2);

    }


}
