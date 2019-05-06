package com.luokp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: luokp
 * @date: 2019/5/4 11:30
 * @description:
 */
public class _SlidingWindowMax {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            if(queue.isEmpty()) {
                queue.offer(i);
            }else{
                while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                    queue.pollLast();
                }
                queue.offer(i);
            }
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        res[index++] = nums[queue.peekFirst()];
        for(int i = k; i < nums.length; i++) {
            if(queue.peekFirst() == i - k) {
                queue.pollFirst();
            }
            while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            res[index++] = nums[queue.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        for(int num : maxSlidingWindow(arr, 3)) {
            System.out.println(num);
        };
    }
}
