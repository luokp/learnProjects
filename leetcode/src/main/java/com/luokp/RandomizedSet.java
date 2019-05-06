package com.luokp;

import java.util.*;

/**
 * @author: luokp
 * @date: 2019/5/5 23:02
 * @description:
 */
class RandomizedSet {
    Set<Integer> set;
    List<Integer> list;
    int index;
    int size;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.set = new HashSet<>();
        this.list = new ArrayList<>();
        this.index = 0;
        this.size = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res =  set.add(val);
        if(res) {
            list.add(val);
            size++;
        }
        return res;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean res =  set.remove(val);
        if(res) {
            list.remove(val);
            size--;
        }
        return res;
    }

    /** Get a random element from the set. */
    public int getRandom() throws Exception {
        if(size == 0) {
            throw new Exception("sds");
        }
        index %= size;
        return list.get(index++);
    }

    public static void main(String[] args) throws Exception {
       int[]arr = {1, 0, -1, 0, -2, 2};

        Set<List<Integer>> res = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        res.add(list);
        res.add(list2);
        System.out.println(res);
    }


}

/**
  Your RandomizedSet object will be instantiated and called as such:
 */

