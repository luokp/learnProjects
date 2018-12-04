package com.luokp.springsimulation.beanDifinition;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: luokp
 * @date: 2018/11/30 19:36
 * @description: reference bean.
 */
public class BeanReference {
    private String beanClassType;
    private String beanName;

    public String getBeanClassType() {
        return beanClassType;
    }

    public void setBeanClassType(String beanClassType) {
        this.beanClassType = beanClassType;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    private PriorityQueue<ListNode> nodeQueue = new PriorityQueue<>(new Comparator<ListNode>(){

        @Override
        public int compare(ListNode n1, ListNode n2) {
            return n1.val - n2.val;
        }
    });


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
