package com.luokp;

import java.util.*;

/**
 * @author: luokp
 * @date: 2019/4/13 18:49
 * @description:
 */


class LRUCache {
    private int size;
    private int CAPACITY;
    private Map<Integer, Data> map;
    private Queue<Data> pq;

    class Data {
        int key;
        int value;
        int age;

        public Data() {
        }

        public Data(int key, int value) {
            this.key = key;
            this.value = value;
            this.age = 0;
        }
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.CAPACITY = capacity;
        this.map = new HashMap<>();
        this.pq = new PriorityQueue<Data>(capacity,
                new Comparator<Data>() {
                    public int compare(Data i1, Data i2) {
                        return i2.age - i1.age;
                    }
                });
    }


    public int get(int key)  {
        if (!map.containsKey(key)) {
//            throw new Exception("No such key!");
            return -1;
        }
        Iterator<Data> it = pq.iterator();
        Data data = map.get(key);
        while (it.hasNext()) {
            Data element = it.next();
            if (data == element) {
                element.age = 0;
            } else {
                element.age++;
            }
        }
        pq.offer(pq.poll());
        return data.value;

    }

    public void put(int key, int value) {
        Data data = new Data(key, value);
        if(map.containsKey(key)){
            Data ele = map.get(key);
            ele.value = value;
            Iterator<Data> it = pq.iterator();
            while (it.hasNext()) {
                Data element = it.next();
                if (ele == element) {
                    element.age = 0;
                } else {
                    element.age++;
                }
            }
            pq.offer(pq.poll());
            return;
        }
        if (size < CAPACITY) {
            if (size != 0) {
                Iterator<Data> it = pq.iterator();
                while (it.hasNext()) {
                    Data element = it.next();
                    element.age++;
                }
            }
            size++;
        } else {
            Data d = pq.poll();
            map.remove(d.key);
            Iterator<Data> it = pq.iterator();
            while (it.hasNext()) {
                Data element = it.next();
                element.age++;
            }
        }
        map.put(key, data);
        pq.offer(data);
    }

    public static void main(String[] args) throws Exception {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        System.out.println(cache.get(2));      // returns -1 (not found)
        cache.put(2, 6);
        System.out.println(cache.get(1));      // returns -1
        cache.put(1, 5);
        cache.put(1, 2);    // evicts key 2
        System.out.println(cache.get(1));       // returns 2
        System.out.println(cache.get(2));       // returns 6
//        cache.put(4, 4);    // evicts key 1
//        System.out.println(cache.get(1));       // returns -1 (not found)
//        System.out.println(cache.get(3));       // returns 3
//        System.out.println(cache.get(4));       // returns 4
    }
}

