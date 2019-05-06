package com.luokp;

import java.util.*;

/**
 * @author: luokp
 * @date: 2019/4/15 00:01
 * @description:
 */
public class LIS {
    public static int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int len1 = ver1.length;
        int len2 = ver2.length;
        int len = len1 < len2? len1:len2;
        int i = 0;
        for(; i < len; i++) {
            if(trimPrifix0(ver1[i]).compareTo(trimPrifix0(ver2[i])) != 0) {
                return trimPrifix0(ver1[i]).compareTo(trimPrifix0(ver2[i]));
            }
        }
        if(len1 < len2) {
            for(int j = i; j < len2; j++) {
                if(!"0".equals(ver2[j])) {
                    return -1;
                }
            }
        }else {
            for(int j = i; j < len1; j++) {
                if(!"0".equals(ver1[j])) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int result = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++) {
            int max = 1;
            for(int j = i-1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            result = Math.max(max, result);
        }
        return result;
    }

    private static int binarySearch(int[] arr, int from, int to, int target) {
        int low = from;
        int high = to;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == target) {
                return mid;
            }else if(arr[mid] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int lengthOfLIS2(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int len = 0;
        dp[len++] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > dp[len-1]) {
                dp[len++] = nums[i];
            }else {
                int index = binarySearch(dp, 0, len-1, nums[i]);
//                System.out.println(Arrays.binarySearch(nums, 0, len-1, nums[i]));
                dp[index] = nums[i];
            }
        }
        return len;
    }

    public static boolean isPalindrome(String s) {
        if(s == null) {
            return false;
        }
        int len = 0;
        if((len = s.length()) == 0) {
            return true;
        }
        for(int i = 0, j = len-1; i <= j; i++,j--) {
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while(i <j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }


    private static String trimPrifix0(String s) {
        if(s == null) {return null;}
        int index = 0;
        while(index < s.length() && s.charAt(index) == '0') {
            index++;
        }
        return index == s.length()? "0" : s.substring(index, s.length());
    }
     public static void main(String[] args) {
//        int[] nums = {1,3,6,7,9,4,10,5,6};
//         System.out.println(lengthOfLIS2(nums));
//         Arrays.binarySearch(nums, 0, 1, 2);
//         Stack<Integer> stack = new Stack<>();


         System.out.println(isPalindrome("a"));
    }
}
