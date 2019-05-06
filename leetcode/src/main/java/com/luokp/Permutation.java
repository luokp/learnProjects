package com.luokp;

import java.util.*;

/**
 * @author: luokp
 * @date: 2018/12/2 16:43
 * @description:
 */
public class Permutation {

    //递归实现
    public static void permutation(int[] nums, int start, Set<String> set){
        if(nums == null || nums.length == 0){
            return;
        }
        if(start == nums.length - 1){
            StringBuilder sb = new StringBuilder();
            for(int num: nums){
                sb.append(num);
            }
            set.add(sb.toString());
            return;
        }
        for(int i = start; i < nums.length; i++){
            //如果相同则跳过
            if(i == start || nums[start] != nums[i]){
//                int temp = nums[start];
//                nums[start] = nums[i];
//                nums[i] = temp;
                swap(nums, start, i);
                permutation(nums, start+1, set);
                swap(nums, start, i);
            }
        }
    }

    public static void permutationWithDictionary(int[] nums, List<String> list){
        if(nums == null || nums.length == 0){
            return;
        }
        Arrays.sort(nums);
        list.add(arryToString(nums));
        while(true){
            int index = nums.length - 1;
            for(; index > 0; index--){
                //从右向左找到第一个非递增元素
                if(nums[index] > nums[index-1]) {
                    break;
                }
            }
            if(index == 0){
                return;
            }

            int j = nums.length - 1;
            for(; j > index - 1; j--){
                //从右向左找到第一个比非递增元素大的元素
                if(nums[index-1] < nums[j]) {
                    break;
                }
            }
            swap(nums, index-1, j);
            reverse(nums, index);
            list.add(arryToString(nums));
        }
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void reverse(int[] nums, int index){
        for(int i = index, j = nums.length - 1; i < j; i++,j-- ){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }

    public static String arryToString(int[] nums){
        StringBuilder sb = new StringBuilder();
        for(int num: nums){
            sb.append(num);
        }
        return  sb.toString();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int[] nums = {1,2,3};
//        permutation(nums, 0, set);
        System.out.println(set);
        list.clear();
        permutationWithDictionary(nums,list);
        System.out.println(list);
    }
}
