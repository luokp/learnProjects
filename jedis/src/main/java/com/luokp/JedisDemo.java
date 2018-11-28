package com.luokp;

import redis.clients.jedis.Jedis;

/**
 * @author: luokp
 * @date: 2018/11/27 20:08
 * @description:
 */
public class JedisDemo {

    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getInstance().getJedis();
        System.out.println(jedis.configGet("save"));
    }
}
