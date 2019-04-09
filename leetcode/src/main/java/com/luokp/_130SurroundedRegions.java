package com.luokp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: luokp
 * @date: 2019/4/7 00:19
 * @description:
 */
public class _130SurroundedRegions {
    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void solve(char[][] board) {
        if(board == null || board.length == 0 ||
                board[0] == null || board[0].length == 0) {return;}

        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++) {
                if((i == 0 || i == board.length - 1 ||
                        j == 0 || j == board[0].length - 1) && board[i][j] == 'O') {
                    board[i][j] = '1';
                    Queue<Point> queue = new LinkedList<>();
                    queue.offer(new Point(i, j));
                    while(!queue.isEmpty()) {
                        Point p = queue.poll();
                        int x = p.x;
                        int y = p.y;
                        if(y != board[0].length-1 && board[x][y+1] == 'O') {
                            board[x][y+1] = '1';
                            queue.offer(new Point(x, y+1));
                        }
                        if(y != 0 && board[x][y-1] == 'O') {
                            board[x][y-1] = '1';
                            queue.offer(new Point(x, y-1));
                        }
                        if(x != board.length-1 && board[x+1][y] == 'O') {
                            board[x+1][y] = '1';
                            queue.offer(new Point(x+1, y));
                        }
                        if(x != 0 && board[x-1][y] == 'O') {
                            board[x-1][y] = '1';
                            queue.offer(new Point(x-1, y));
                        }
                    }
                }
            }

        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
    }

    public static void replace(char[][] board, int row, int column) {
        if((row == 0 || row == board.length - 1 ||
                column == 0 || column == board[0].length - 1) &&
                board[row][column] == 'O') {
            board[row][column] = '1';
        }else{
            if(board[row][column] == 'O' && (board[row-1][column] == '1' ||
                    board[row+1][column] == '1' ||
                    board[row][column-1] == '1' ||
                    board[row][column+1] == '1')) {
                board[row][column] = '1';
            }else{
                board[row][column] = 'X';
            }
        }
    }

//    [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

    public static void main(String[] args) {
        char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        solve(board);
        System.out.println(1);
    }
}
