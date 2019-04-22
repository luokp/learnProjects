package com.luokp;

import java.util.Arrays;

/**
 * @author: luokp
 * @date: 2018/12/2 13:27
 * @description:
 */
public class _27Remove_element {

    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        for(int j = nums.length - 1; i < j; ){
            while(i < nums.length && nums[i] != val){
                i++;
            }
            while(j >=0 && nums[j] == val){
                j--;
            }
            if(i < j){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int new_len = removeElement(nums, 3);
        System.out.println(new_len);
        System.out.println(Arrays.toString(nums));
    }
}
