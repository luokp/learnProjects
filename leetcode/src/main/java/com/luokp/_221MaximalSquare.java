package com.luokp;

/**
 * @author: luokp
 * @date: 2019/4/24 15:26
 * @description:
 */
public class _221MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int maxLen = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    int len = 1;
                    maxLen = Math.max(len, maxLen);
                    while(i + len < matrix.length && j + len < matrix[0].length) {
                        if(matrix[i+len][j] != '1' || matrix[i][j+len] != '1') {
                            break;
                        }
                        len++;
//                        if(isSquare(matrix, i+1, j+1, len-1)) {
//                            maxLen = Math.max(len, maxLen);
//                        }
                    }
                    for(int k = len; k >= 1; k--) {
                        if(isSquare(matrix, i+1, j+1, k-1)) {
                            maxLen = Math.max(len, maxLen);
                            break;
                        }
                    }
                }
            }
        }
        return maxLen * maxLen;
    }

    private static boolean isSquare(char[][] matrix, int row, int column, int len) {
        if(matrix[row][column] != '1') {
            return false;
        }
        if(len == 1) {
            return true;
        }
        for(int i = 1; i < len; i++) {
            if(matrix[row+i][column] != '1' || matrix[row][column+i] != '1') {
                return false;
            }
        }
        return isSquare(matrix, row+1, column+1, len-1);
    }

    public static void main(String[] args) {
        char[][] a = {
                {'1','1','1','1','1','1','1','1'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','1','1','0'},
                {'1','1','1','1','1','0','0','0'},
                {'0','1','1','1','1','0','0','0'},
                };
        System.out.println(maximalSquare(a));
    }
}
