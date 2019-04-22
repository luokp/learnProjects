package com.luokp;

import com.luokp.models.ListNode;

/**
 * @author: luokp
 * @date: 2019/4/14 01:16
 * @description:
 */
public class _148SortLinkedList {
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {return head;}
        ListNode left = head, right = head;
        while(right.next != null) {
            right = right.next;
        }
        return sort(left, right);
    }

    public static ListNode sort(ListNode left, ListNode right) {
        if(left == right) {
            return left;
        }
        if(left.next == right) {
            if(left.val < right.val) {
                right.next = null;
                return left;
            }
            right.next = left;
            left.next = null;
            return right;
        }
        ListNode fast = left, slow = left;
        while(fast.next != right && fast.next.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        left = sort(left, slow);
        right = sort(temp, right);
        return merge(left, right);

    }

    public static ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = null;
        if(head1.val < head2.val) {
            head = head1;
            head1 = head1.next;
        }else{
            head = head2;
            head2 = head2.next;
        }
        ListNode curr = head;

        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                curr.next = head1;
                curr = curr.next;
                head1 = head1.next;
            }else{
                curr.next = head2;
                curr = curr.next;
                head2 = head2.next;
            }
        }
        while(head1 != null) {
            curr.next = head1;
            curr = curr.next;
            head1 = head1.next;
        }
        while(head2 != null) {
            curr.next = head2;
            curr = curr.next;
            head2 = head2.next;
        }

        return head;
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
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        print(node1);

        ListNode n = sortList(node1);
        print(n);
    }
}
