package com.luokp;

import java.util.Random;

/**
 * @author: luokp
 * @date: 2019/4/21 18:22
 * @description:
 */
public class QuickSort {

    public static void quickSort(int[] nums, int low, int high) {
        if(low < high) {
            int index = partition(nums,low, high);
            quickSort(nums, low, index -1);
            quickSort(nums, index+1, high);
        }
    }



    private static int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        int pivot = nums[(int) (Math.random() * high + low)];
        while(j > i) {
            while(j > i && nums[j] >= pivot) {
                j--;
            }
            while(j > i && nums[i] <= pivot) {
                i++;
            }
            if(i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, i);
        return i;
    }

    private static  void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        k = nums.length - k;
        while(low < high) {
            int p = partition(nums, low, high);
            if(p > k) {
                high = p - 1;
            }else if(p < k){
                low = p + 1;
            }else {
                break;
            }
        }
        return nums[k];

    }

    public static void main(String[] args) {
        int[] arr = { 3,2,1,5,6,4 };
        System.out.println(findKthLargest(arr, 2));
//        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
