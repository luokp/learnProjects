package com.luokp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: luokp
 * @date: 2018/12/18 17:25
 * @description:
 */
public class _51NQueues {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n < 0) {
            return result;
        }
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }
        for (int i = 0; i < n; i++) {
            nQueues(n, 0, i, chars, result);
        }
        return result;
    }

    public static void nQueues(int n, int row, int column, char[][] chars, List<List<String>> result){
        if(canPlace(chars,row,column,n)) {
            chars[row][column] = 'Q';
            //得到一个解
            if(row == n - 1) {
                List<String> tempList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    tempList.add(String.valueOf(chars[i]));
                }
                result.add(tempList);
            }else{
                for (int i = 0; i < n; i++) {
                    nQueues(n, row + 1, i, chars, result);
                }
            }
            //回溯
            chars[row][column] = '.';
        }
    }

    public static boolean canPlace(char[][] chars, int row, int column, int n) {
        for(int i = 0; i < n; i++){
            //行
            if(chars[row][i] == 'Q') {
                return false;
            }
            //列
            if(chars[i][column] == 'Q') {
                return false;
            }
        }
        //右下
        for(int i = row, j = column; i < n && j < n; i++, j++){
            if(chars[i][j] == 'Q') {
                return false;
            }
        }
        //左上
        for(int i = row, j = column; i >= 0 && j >= 0; i--, j--){
            if(chars[i][j] == 'Q') {
                return false;
            }
        }
        //右上
        for(int i = row, j = column; i >=0 && j < n; i--, j++){
            if(chars[i][j] == 'Q') {
                return false;
            }
        }
        //左下
        for(int i = row, j = column; i < n && j >= 0; i++, j--){
            if(chars[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(0));
    }
}
