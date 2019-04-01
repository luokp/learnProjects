package com.luokp;

import java.util.Arrays;

/**
 * @author: luokp
 * @date: 2019/3/30 01:06
 * @description:
 */
public class _80RemoveDuplication {
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {return 0;}
        int len = 0;
        int cnt = 0;
        boolean flag = false;
        int temp = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == temp ) {
                if(!flag) {
                    swap(nums, i, len);
                    len++;
                    cnt++;
                    if(cnt == 2) {
                        flag = true;
                        cnt = 0;
                    }
                }
            }else{
                temp = nums[i];
                swap(nums, i, len);
                len++;
                cnt = 1;
                flag = false;
            }
        }
        return len;
    }

    private  static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3,3};
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}
