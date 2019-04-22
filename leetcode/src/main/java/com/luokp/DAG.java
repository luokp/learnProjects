package com.luokp;

import java.util.*;

/**
 * @author: luokp
 * @date: 2019/4/20 17:14
 * @description:
 */
public class DAG {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //构造图
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }
        for(int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        boolean[] visited = new boolean[numCourses];

        List<Integer> list = new ArrayList<>();
        int[] degree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue= new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(degree[i] == 0) {
                queue.offer(i);
                visited[i] = true;
            }
        }
        while(!queue.isEmpty()) {
            int course = queue.poll();
            list.add(course);
            for(int i = 0; i < graph[course].size(); i++) {
                degree[(int)graph[course].get(i)]--;
                if(degree[(int)graph[course].get(i)] == 0 && !visited[(int)graph[course].get(i)]) {
                    queue.offer((int)graph[course].get(i));
                    visited[(int)graph[course].get(i)] = true;
                }
            }
        }
        int[] result = new int[0];
        if(list.size() == numCourses) {
            int index = 0;
            result = new int[numCourses];
            for(Integer course:list) {
                result[index++] = course;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] p = {{0,1},{1,0}};
        System.out.println(Arrays.toString(findOrder(2, p)));
    }
}
