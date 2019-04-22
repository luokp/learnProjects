package com.luokp;

/**
 * @author: luokp
 * @date: 2019/4/20 21:47
 * @description:
 */
public class _213HouseRobberII {
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = nums[0] > nums[1]?nums[0]:nums[1];
        if(nums.length == 2) {
            return max[1];
        }
        for(int i = 2; i < nums.length - 1; i++) {
            max[i] = Math.max(max[i-2] + nums[i], max[i-1]);
        }
        if((nums.length & 1) == 1) {
            max[nums.length-1] = Math.max(max[nums.length-3] + nums[nums.length-1] - nums[0], max[nums.length-2]);
        }else{
            max[nums.length-1] = Math.max(max[nums.length-3] + nums[nums.length-1], max[nums.length-2]);
        }

        return max[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,1};
        System.out.println(rob(nums));
    }
}
