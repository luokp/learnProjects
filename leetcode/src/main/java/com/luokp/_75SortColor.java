package com.luokp;

import java.util.Arrays;

/**
 * @author: luokp
 * @date: 2019/3/28 19:59
 * @description:
 */
public class _75SortColor {

    public static void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int oneP = 0, twoP = nums.length / 2;
        int threeP = twoP;
        int fourP = nums.length - 1;
        while(oneP < twoP || threeP < fourP) {
            while(oneP < fourP && nums[oneP] == 0) {
                oneP++;
            }
            while(oneP < fourP && nums[fourP] == 2) {
                fourP--;
            }
            if(oneP >= fourP ) break;

            while(twoP >= oneP && nums[twoP] == 1) {
                twoP--;
            }
            if(twoP >= oneP) {
                if(nums[twoP] == 0){
                    swap(nums, oneP, twoP);
                    while(oneP < fourP && nums[oneP] == 0) {
                        oneP++;
                    }
                }else{
                    swap(nums, fourP, twoP);
                    while(oneP < fourP && nums[fourP] == 2) {
                        fourP--;
                    }
                }
            }
            if(oneP >= fourP ) break;

            while(threeP <= fourP && nums[threeP] == 1 ) {
                threeP++;
            }
            if(threeP <= fourP){
                if(nums[threeP] == 0){
                    swap(nums, oneP, threeP);
                }else{
                    swap(nums, fourP, threeP);
                }
            }

        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
