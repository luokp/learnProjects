package com.luokp;

/**
 * @author: luokp
 * @date: 2019/4/27 21:21
 * @description:
 */
public class _240SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 ||
                matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        return search(matrix, 0, 0, matrix.length-1, matrix[0].length-1, target);
    }

    private static boolean search(int[][] matrix, int startR, int startC, int endR, int endC, int target) {
        if(matrix[startR][startC] > target) {
            return false;
        }
        if(startR == endR && startC == endC) {
            if(matrix[startR][startC] != target) {
                return false;
            }else {
                return true;
            }
        }

        int row = startR;
        int column = startC;
        while(row <= endR && column <= endC) {
            if(matrix[row][column] == target) {
                return true;
            }
            if(matrix[row][column] > target) {
                break;
            }
            row++;
            column++;
        }
        if(row > endR && column > endC) {
            return false;
        }
        boolean up = false;
        boolean down = false;
        if(column <= endC) {
            up = search(matrix, startR, column, row-1, endC, target);
        }
        if(row <= endR) {
            down = search(matrix, row, startC, endR, column-1, target);
        }
        return up || down;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
                        };
//        System.out.println(searchMatrix(matrix, 20));
        System.out.println(searchMatrix2(matrix, 0));

    }
}
