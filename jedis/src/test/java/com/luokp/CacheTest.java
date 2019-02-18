package com.luokp;

/**
 * @author: luokp
 * @date: 2018/12/5 16:03
 * @description:
 *   CacheBuilder作为LoadingCache 与 Cache实例的创建者，具有以下特征：        
 * 1、自动载入键值至缓存；    
 * 2、当缓存器溢出时，采用最近最少使用原则进行替换。      
 * 3、过期规则可基于最后读写时间。     
 * 4、设置键值引用级别。       
 * 5、元素移出通知。       
 * 6、缓存访问统计。
 *         谷歌gavan开源开发包中的LoadingCache系统缓存机制，以下为创建缓存以及使用缓存机制实例
 */


import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.keyvalue.MultiKey;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;


public class CacheTest {

    /**
     * 谷歌LoadingCache缓存使用
          * @param args
     */
    static LoadingCache<String, String> cahceBuilder = CacheBuilder.newBuilder()
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return cacheMap.get(key);
                }
            });
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 2; i++) {
            if(cahceBuilder.size()<1){
                test();
            }
            for (String s:cahceBuilder.asMap().keySet()) {
                System.err.println(s+"+++111::"+cahceBuilder.get(s));
            }
        }
        test2();
        for(int i = 0; i < 2; i++){
            for (String s:cahceBuilder.asMap().keySet()) {
                System.err.println(s+"+++222::"+cahceBuilder.get(s));
            }
        }
        cahceBuilder.invalidateAll();
    }
    private static Map<String,String> cacheMap = Maps.newHashMap();
    public static void test() throws Exception{
        cacheMap.put("test1", "test11");
        cacheMap.put("test2", "test12");
        cacheMap.put("test3", "test13");
        for (String s:cacheMap.keySet()) {
            if(!cahceBuilder.asMap().keySet().contains(s)){
                cahceBuilder.get(s);
            }
        }
        int i = Integer.MAX_VALUE;
    }

    public static void test2() throws Exception{
        cacheMap.put("test5", "test21");
        cacheMap.put("test6", "test22");
        cacheMap.put("test4", "test23");
        for (String s:cacheMap.keySet()) {
            if(!cahceBuilder.asMap().keySet().contains(s)){
                cahceBuilder.get(s);
            }
        }
    }



}




