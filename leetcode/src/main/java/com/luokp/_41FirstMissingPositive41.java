package com.luokp;

import java.util.Arrays;

/**
 * @author: luokp
 * @date: 2018/12/5 21:50
 * @description:
 */
public class _41FirstMissingPositive41 {

    public static int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 1;
        }
//        int len = Integer.MAX_VALUE / 8 + 1;
        int max = 0;
        for(int num : nums){
            max = Math.max(max, num);
        }
        int len = max / 8 + 1;
        int[] bitMap = new int[len];
        bitMap[0] |= 1;
        for(int num : nums) {
            if(num > 0){
                int index = num / 8;
                int bit_index = (num & 7) ;
                bitMap[index] |= (1 << bit_index);
            }
        }
        int ret = 0;
        lableA:
        for(int i = 0; i < bitMap.length; i++){
            for(int j = 0; j < 8; j++){
                if((bitMap[i] & (1 << j)) == 0) {
                    ret = 8 * (i) + j ;
                    break lableA;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {-1,1000};
        System.out.println(firstMissingPositive(nums));
    }
}
