package com.luokp;

import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.doclint.Entity.exist;

/**
 * @author: luokp
 * @date: 2019/3/29 22:07
 * @description:
 */
public class _79SearchWord {

    public static boolean exist(char[][] board, String word) {
        if(board == null || word == null || word.length() == 0) {return false;}
        List<Integer[]> sites = siteC(board, word.charAt(0));
        if(sites.size() == 0) {return false;}
//        if(word.length()  == 1) {return true;}
//        boolean[][] flag = new boolean[board.length][board[0].length];
        for(Integer[] site : sites) {
            boolean[][] flag = new boolean[board.length][board[0].length];
            flag[site[0]][site[1]] = true;
            if(walk(board, word, 1, site, flag)) {return true;}
        }
        return false;
    }

    public static boolean walk(char[][] board, String word, int next, Integer[] site, boolean[][] flag) {

        if(next == word.length()) {return true;}
        if(site[0] > 0 && !flag[site[0]-1][site[1]] && board[site[0]-1][site[1]] == word.charAt(next)) {
            Integer[] siteN = new Integer[2];
            siteN[0] = site[0]-1;
            siteN[1] = site[1];
            flag[site[0]-1][site[1]] = true;
            if (walk(board, word, next+1, siteN, flag)) return true;
            flag[site[0]-1][site[1]] = false;
        }
        if(site[0] < board.length-1 && !flag[site[0]+1][site[1]] && board[site[0]+1][site[1]] == word.charAt(next)) {
            Integer[] siteN = new Integer[2];
            siteN[0] = site[0]+1;
            siteN[1] = site[1];
            flag[site[0]+1][site[1]] = true;
            if (walk(board, word, next+1, siteN, flag)) return true;
            flag[site[0]+1][site[1]] = false;
        }
        if(site[1] > 0 && !flag[site[0]][site[1]-1]  && board[site[0]][site[1]-1] == word.charAt(next)) {
            Integer[] siteN = new Integer[2];
            siteN[0] = site[0];
            siteN[1] = site[1]-1;
            flag[site[0]][site[1]-1] = true;
            if (walk(board, word, next+1, siteN, flag)) return true;
            flag[site[0]][site[1]-1] = false;
        }
        if(site[1] < board[0].length-1 && !flag[site[0]][site[1]+1]  && board[site[0]][site[1]+1] == word.charAt(next)) {
            Integer[] siteN = new Integer[2];
            siteN[0] = site[0];
            siteN[1] = site[1]+1;
            flag[site[0]][site[1]+1] = true;
            if (walk(board, word, next+1, siteN, flag)) return true;
            flag[site[0]][site[1]+1] = false;
        }
        return false;
    }

    public boolean hasC(char[][] board, char c, Integer[] site) {
        if(board[site[0]-1][site[1]] == c ||
                board[site[0]+1][site[1]] == c ||
                board[site[0]][site[1]-1] == c ||
                board[site[0]][site[1]+1] == c) {return true;}
        return false;
    }

    public static List<Integer[]> siteC(char[][] board, char c) {
        List<Integer[]> sites = new ArrayList<>();
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == c) {
                    Integer[] site = new Integer[2];
                    site[0] = i;
                    site[1] = j;
                    sites.add(site);
                }
            }
        return sites;
    }

    public static void main(String[] args) {
        char[][] b = {  {'A','B','C','E'},
                        {'S','F','E','S'},
                        {'A','D','E','E'}};
        char[][] c = {{'a','a'}};
        System.out.println(exist(b, "ABCESEEEFS"));
    }
}
