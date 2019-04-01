package com.luokp;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: luokp
 * @date: 2019/3/28 16:34
 * @description:
 */
public class _71SimplifyPath {
    public static String simplifyPath(String path) {
        char[] paths = path.toCharArray();
        Deque<Character> cPath = new LinkedList<>();
        cPath.addLast('/');
        // int index = 1;
        // List<Integer> slashIndex = new LinkedList<>();
        for(int i = 1; i < paths.length;) {
            if(paths[i] == '/') {
                if(cPath.getLast() == '/'){
                    i++;
                    continue;
                }else{
                    cPath.addLast('/');
                    // index++;
                    // slashIndex.addLast(index);
                    i++;
                }
            }else if(paths[i] == '.') {
                if(i == paths.length - 1) {
                    break;
                }else if(paths[i+1] == '/') {
                    i += 2;
                }else{
                    // slashIndex.removeLast();
                    // int slash = slashIndex.getLast();
                    if(cPath.size() != 1) {
                        cPath.removeLast();
                        while(cPath.getLast() != '/') {
                            cPath.removeLast();
                        }
                    }
                    i += 3;
                }
            }else{
                cPath.addLast(paths[i]);
                i++;
            }
        }

        if(cPath.getLast() == '/' && cPath.size() != 1) {
            cPath.removeLast();
        }
        StringBuilder sb = new StringBuilder();
        while(cPath.size() != 0) {
            sb.append(cPath.pollFirst());
        }
        return sb.toString();
    }

    public static void setZeroes(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            // if (matrix[i][0] == 0) col0 = 0;
            for (int j = 0; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            // if (col0 == 0) matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
//        String s = "/.";
//        System.out.println(simplifyPath(s));

        int[][] ss = {{1,1,1},{0,1,2}};
        setZeroes(ss);
    }
}
