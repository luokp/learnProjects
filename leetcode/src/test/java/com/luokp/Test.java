package com.luokp;

import java.util.List;

/**
 * @author: luokp
 * @date: 2018/11/29 00:58
 * @description:
 */
public class Test {
    @org.junit.Test
    public void test() {
        Catalan catalan = new Catalan();
        List list = catalan.generateParenthesis(50);
        System.out.println(list);
    }
}
