package com.luokp;

import java.util.Arrays;

/**
 * @author: luokp
 * @date: 2018/12/4 00:42
 * @description:
 */
public class _34FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if(nums == null || nums.length == 0){
            return result;
        }
        int index = binarySearch(nums, target);
        if(index == -1) {
            return result;
        }
        result[0] = targetPosition(nums, 0, index, target, true);
        result[1] = targetPosition(nums, index, nums.length-1,target, false);
        return result;
    }

    public static int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int middle = start + (end - start)/2;
            if(nums[middle] == target)
                return middle;
            else if(nums[middle] < target)
                start = middle + 1;
            else end = middle - 1;
        }
        return -1;
    }

    public static  int targetPosition(int[] nums,int start, int end, int target, boolean isLeft){
        if(start == end){
            return start;
        }
        if(isLeft && nums[start] == target){
            return start;
        }
        if(nums[start] == target){
            while(start <= end){
                if(start == end){
                    return start;
                }
                int middle = start + (end - start) / 2;
                if(nums[middle] == target){
                    if(nums[middle+1] != target){
                        return middle;
                    }else{
                        start = middle + 1;
                    }
                }else{
                    if(nums[middle-1] == target){
                        return middle - 1;
                    }else{
                        end = middle - 1;
                    }
                }
            }
        }else{
            while(start <= end){
                if(start == end){
                    return start;
                }
                int middle = start + (end - start) / 2;
                if(nums[middle] == target){
                    if(nums[middle-1] != target){
                        return middle;
                    }else{
                        end = middle - 1;
                    }
                }else{
                    if(nums[middle+1] == target){
                        return middle + 1;
                    }else{
                        start = middle + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,2,2,2};
        System.out.println(Arrays.toString(searchRange(nums, 1)));
    }
}
