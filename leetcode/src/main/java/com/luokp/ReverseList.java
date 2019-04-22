package com.luokp;

import apple.laf.JRSUIUtils;
import com.luokp.models.ListNode;
import com.luokp.models.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: luokp
 * @date: 2019/4/13 15:24
 * @description:
 */
public class ReverseList {

    private static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {return head;}
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = head.next;
        head.next = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = next;
        }
        return dummy.next;


    }
    public static void print (ListNode head) {
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
            if(head != null) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        print(node1);

        print(reverseList(node1));

        Stack<TreeNode> stack = new Stack<>();

    }
}
