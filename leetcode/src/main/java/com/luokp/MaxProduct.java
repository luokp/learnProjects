package com.luokp;

/**
 * @author: luokp
 * @date: 2019/5/2 14:55
 * @description:
 */
public class MaxProduct {

    public static int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = nums[0];
        int result = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(dp[0] != 0) {
                int temp = dp[0];
                dp[0] = Math.max(nums[i], Math.max(dp[0] * nums[i], dp[1] * nums[i]));
                dp[1] = Math.min(nums[i], Math.min(temp * nums[i], dp[1] * nums[i]));
            }else {
                dp[0] = dp[1] = nums[i];
            }


            result = Math.max(dp[0], result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, -4};
        System.out.println(maxProduct(arr));
    }
}
