package com.luokp.models;

/**
 * @author: luokp
 * @date: 2018/12/2 11:38
 * @description:
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        this.val = x;
    }
    public static ListNode createList(int[] nums){
        ListNode head = null;
        if(nums == null || nums.length == 0){
            return head;
        }
        head = new ListNode(nums[0]);
        ListNode curr = head;
        for(int i = 1; i < nums.length; i++){
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void print(ListNode head) {
        ListNode curr = head;
        StringBuilder sb = new StringBuilder();
        while(curr != null){
            sb.append(curr.val);
            if((curr = curr.next) != null){
                sb.append("->");
            }
        }
        System.out.println(sb.toString());
    }
}
