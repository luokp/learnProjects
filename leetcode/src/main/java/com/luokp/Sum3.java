package com.luokp;

import java.util.*;

/**
 * @author: luokp
 * @date: 2018/11/27 23:47
 * @description:
 */
public class Sum3 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) continue;
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < nums.length; j++){
                if((j == i) || set.contains(nums[j])) continue;
                List<Integer> list = new ArrayList<>();
                if(!map.containsKey(nums[j])){
                    map.put(-nums[i] - nums[j], nums[j]);
                }else{
                    list.add(nums[j]);
                    list.add(map.get(nums[j]));
                    list.add(nums[i]);
                    set.add(nums[j]);
                    set.add(map.get(nums[j]));
                    set.add(nums[i]);
                    result.add(list);
                    // Collections.sort(list, new Comparator<Integer>(){
                    //     @Override
                    //     public int compare(Integer o1, Integer o2) {
                    //         return o1 - o2;
                    //     }
                    // });
                    // IntegerList il = new IntegerList();
                    // il.setList(list);
                    // set.add(il);
                }
            }
        }
        // for(IntegerList il : set){
        //     result.add(il.getList());
        
        // }
        return result;
    }

    class IntegerList{
        private  List<Integer> list ;

        public List<Integer> getList(){
            return this.list;
        }

        public void setList(List<Integer> list){
            this.list = list;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            IntegerList that = (IntegerList) o;
            return list.containsAll(that.getList());
        }

        @Override
        public int hashCode() {
            return Objects.hash(list);
        }

    }

    public List<List<Integer>> twoSum(int[] nums, int exclusive, int target){
        List<List<Integer>> result= new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(i == exclusive) continue;
            List<Integer> list = new ArrayList<>();
            if(!map.containsKey(nums[i])){
                map.put(target - nums[i], nums[i]);
            }else{
                list.add(nums[i]);
                list.add(map.get(nums[i]));
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {0,0,0,0};
        System.out.println(threeSum(nums));
    }
}
