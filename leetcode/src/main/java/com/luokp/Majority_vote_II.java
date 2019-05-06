package com.luokp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: luokp
 * @date: 2019/4/26 00:09
 * @description:
 */
public class Majority_vote_II {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        if(nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        int[] majority = new int[2];
        int vote0 = 0;
        int vote1 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == majority[0]) {
                vote0 += 1;
            }else if(nums[i] == majority[1]) {
                vote1 += 1;
            }else if(vote0 == 0) {
                majority[0] = nums[i];
                vote0 = 1;
            }else if(vote1 == 0) {
                majority[1] = nums[i];
                vote1 = 1;
            }else {
                vote0 -= 1;
                vote1 -= 1;
            }
        }
        int top0 = 0;
        int top1 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == majority[0]) {
                top0++;
            }
            if(nums[i] == majority[1]) {
                top1++;
            }
        }
        if(top0 > nums.length/3) {
            result.add(majority[0]);
        }
        if(top1 > nums.length/3) {
            result.add(majority[1]);
        }
        if(result.size() == 2 && result.get(0).equals(result.get(1))) {
            result.remove(1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {8, 8, 7, 7, 7};
        System.out.println(majorityElement(arr));
    }
}
