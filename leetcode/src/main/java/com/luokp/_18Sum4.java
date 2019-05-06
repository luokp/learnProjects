package com.luokp;

import java.util.*;

/**
 * @author: luokp
 * @date: 2018/11/28 00:40
 * @description:
 */
class _18Sum4 {
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


    //n3
    public static List<List<Integer>> fourSum2(int[] num, int target) {
        Arrays.sort(num);

        Map<Integer, List<int[]>> twoSumMap = new HashMap<>(); // for holding visited pair sums. All pairs with the same pair sum are grouped together
        Set<List<Integer>> res = new HashSet<>();  // for holding the results

        for (int i = 0; i < num.length; i++) {
            // get rid of repeated pair sums
            if (i > 1 && num[i] == num[i - 2]) continue;

            for (int j = i + 1; j < num.length; j++) {
                // get rid of repeated pair sums
                if (j > i + 2 && num[j] == num[j - 2]) continue;

                // for each pair sum, check if the pair sum that is needed to get the target has been visited.
                if (twoSumMap.containsKey(target - (num[i] + num[j]))) {
                    // if so, get all the pairs that contribute to this visited pair sum.
                    List<int[]> ls = twoSumMap.get(target - (num[i] + num[j]));

                    for (int[] pair : ls) {
                        // we have two pairs: one is indicated as (pair[0], pair[1]), the other is (i, j).
                        // we first need to check if they are overlapping with each other.
                        int m1 = Math.min(pair[0], i);  // m1 will always be the smallest index
                        int m2 = Math.min(pair[1], j);  // m2 will be one of the middle two indices
                        int m3 = Math.max(pair[0], i);  // m3 will be one of the middle two indices
                        int m4 = Math.max(pair[1], j);  // m4 will always be the largest index

                        if (m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4) continue;  // two pairs are overlapping, so just ignore this case

                        res.add(Arrays.asList(num[m1], num[Math.min(m2, m3)], num[Math.max(m2, m3)], num[m4]));  // else record the result
                    }
                }

                // mark that we have visited current pair and add it to the corrsponding pair sum group.
                // here we've encoded the pair indices i and j into an integer array of length 2.
                if (twoSumMap.containsKey((num[i] + num[j]))) {
                    twoSumMap.get(num[i] + num[j]).add(new int[]{i, j});
                }else{
                    List<int[]> s = new ArrayList<>();
                    s.add(new int[] {i, j});
                    twoSumMap.put(num[i] + num[j], s);
                }

                twoSumMap.computeIfAbsent(num[i] + num[j], key -> new ArrayList<>()).add(new int[]{i,j});
                System.out.println();
            }
        }

        return new ArrayList<List<Integer>>(res);
    }


    public List<List<Integer>> threeSum(int[] nums, int render) {
        List<List<Integer>> res = new ArrayList<>();
         Arrays.sort(nums);
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

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++) {
                int sum = A[i] + B[j];
                if(map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                }else {
                    map.put(sum, 1);
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++) {
                if(map.containsKey(-C[i] - D[j])){
                    cnt += map.get(-C[i] - D[j]);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        int[] a = {1,2};
        int[] b = {-2,-1};
        int[] c = {-1,2};
        int[] d = {0,2};
        System.out.println(fourSumCount(a,b,c,d));
    }
}
