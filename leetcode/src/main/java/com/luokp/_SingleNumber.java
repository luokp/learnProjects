package com.luokp;

/**
 * @author: luokp
 * @date: 2019/4/12 13:56
 * @description:
 */
public class _SingleNumber {
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    sum++;
                }
            }
            sum %= 3;
            if (sum != 0) {
                ans |= 1 << i;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,3};
        System.out.println(singleNumber(arr));
    }
}
