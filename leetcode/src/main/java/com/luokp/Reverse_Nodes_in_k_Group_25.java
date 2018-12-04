package com.luokp;

import com.luokp.models.ListNode;

/**
 * @author: luokp
 * @date: 2018/12/2 11:37
 * @description:
 */
public class Reverse_Nodes_in_k_Group_25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1 || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode next = head.next;
        ListNode curr = head, tail = head;
        int index = 1;
        for(; index < k && next != null; index++){
            curr = next;
            next = next.next;
            curr.next = dummy.next;
            dummy.next = curr;
        }
        tail.next = null;
        if(index == k){
            tail.next = reverseKGroup(next, k);
        }else{
            curr = dummy.next;
            tail = curr;
            next = curr.next;
            for(; next != null; index++){
                curr = next;
                next = next.next;
                curr.next = dummy.next;
                dummy.next = curr;
            }
            tail.next = null;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListNode.createList(nums);
        ListNode.print(head);

        ListNode reverseNode = reverseKGroup(head, 6);
        ListNode.print(reverseNode);
    }
}
