package com.luokp;

import java.util.*;

/**
 * @author: luokp
 * @date: 2018/11/29 00:58
 * @description:
 */
public class ZforTest {
    @org.junit.Test
    public void test() {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < 5; i++) {
            set.add(i);
        }
        System.out.println(((TreeSet<Integer>) set).pollLast());
//        Catalan catalan = new Catalan();
//        List list = catalan.generateParenthesis(50);
//        System.out.println(list);

    }
}
