package com.luokp;

/**
 * @author: luokp
 * @date: 2018/12/3 23:57
 * @description:
 */
public class _33SearchInRotatedArray33 {

    public static int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int middle = low + (high - low) / 2;
            if(nums[middle] == target){
                return middle;
            }
            if (nums[middle] >= nums[low]){
                if(nums[low] <= target && nums[middle] > target){
                    high = middle - 1;
                }else{
                    low = middle + 1;
                }
            }
            if (nums[middle] <= nums[high]){
                if(nums[high] >= target && target > nums[middle]){
                    low = middle + 1;
                }else{
                    high = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 3));
    }
}
