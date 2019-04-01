package com.luokp;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: luokp
 * @date: 2019/3/28 15:29
 * @description:
 */
public class _63uniquePath {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        boolean rowObstacle = false, columnObstacle = false;
        for(int i = 0; i < obstacleGrid.length; i++)
            for(int j = 0; j < obstacleGrid[0].length; j++){
                if(i == 0) {
                    if(rowObstacle) {
                        obstacleGrid[i][j] = 0;continue;
                    }
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                        rowObstacle = true;
                    }else{
                        obstacleGrid[i][j] = 1;
                    }
                }else if(j == 0){
                    if(columnObstacle) {
                        obstacleGrid[i][j] = 0;continue;
                    }
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                        columnObstacle = true;
                    }else{
                        obstacleGrid[i][j] = 1;
                    }
                }else{
                    if (obstacleGrid[i][j] == 1) {
                        obstacleGrid[i][j] = 0;
                    }else{
                        obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                    }
                }
            }
        return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] s = {{1},{0}};
        System.out.println(uniquePathsWithObstacles(s));
        StringBuilder sb = new StringBuilder();
        List<Integer> slashIndex = new LinkedList<>();
    }
}
