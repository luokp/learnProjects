package com.luokp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: luokp
 * @date: 2018/11/28 00:40
 * @description:
 */
class Sum4 {
    public static List<List<Integer>> fourSum(int[] nums, int tar) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int l = 0; l + 3 < nums.length; l++) {
            if (l > 0 && nums[l] == nums[l - 1]) {              // skip same result
                continue;
            }

            for (int i = l+1; i + 2 < nums.length; i++) {
                if (i > l+1 && nums[i] == nums[i - 1]) {              // skip same result
                    continue;
                }
                int j = i + 1, k = nums.length - 1;
                int target = tar - nums[l] - nums[i];
                while (j < k) {
                    if (nums[j] + nums[k] == target) {
                        result.add(Arrays.asList(nums[l], nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                        while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                    } else if (nums[j] + nums[k] > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }

        }
        return result;
    }


    public List<List<Integer>> threeSum(int[] nums, int render) {
        List<List<Integer>> res = new ArrayList<>();
        // Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = render - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(fourSum(nums, -1));
    }
}
