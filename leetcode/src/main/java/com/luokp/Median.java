package com.luokp;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: luokp
 * @date: 2019/4/28 19:27
 * @description:
 */
public class Median {
    PriorityQueue<Integer> big;
    PriorityQueue<Integer> small;
    int bigSize;
    int smallSize;
    /** initialize your data structure here. */
    public Median() {
        this.small = new PriorityQueue<>((n1, n2) -> n1 - n2);
        this.big = new PriorityQueue<>((n1, n2) -> n2 - n1);
        this.bigSize = 0;
        this.smallSize = 0;
    }

    public void addNum(int num) {
        if(bigSize < smallSize) {
            if(num < small.peek()) {
                big.offer(num);
            }else {
                big.offer(small.poll());
                small.offer(num);
            }
            bigSize++;
        }else {
            if(small.size() == 0) {
                small.offer(num);
                smallSize++;
                return;
            }
            if(num > big.peek()) {
                small.offer(num);
            }else {
                small.offer(big.poll());
                big.offer(num);
            }
            smallSize++;
        }
    }

    public double findMedian() {
        if(bigSize == smallSize) {
            return (double)(big.peek() + small.peek()) / 2;
        }else if(bigSize > smallSize) {
            return (double) big.peek();
        }else {
            return (double) small.peek();
        }
    }

    public static void main(String[] args) {
        Median m = new Median();
        m.addNum(1);
        m.addNum(2);
        m.addNum(1);
        m.addNum(2);
        m.addNum(20);
        System.out.println(m.findMedian());
    }
}
