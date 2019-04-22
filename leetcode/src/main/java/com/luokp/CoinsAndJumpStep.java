package com.luokp;

import java.util.Arrays;

/**
 * @author: luokp
 * @date: 2019/4/10 14:32
 * @description:
 */
public class CoinsAndJumpStep {
    static int[] coins = {1, 2, 5, 10, 20, 50, 100};

    //dp[i][num] = dp[i-1][num - k * coins[i]];
    public static int coinConbination(int[] type, int kinds, int target) {
        int dp[][] = new int[kinds+1][target+1];
        dp[0][0] = 1;
        for (int i = 1; i <= kinds; i++)
            for (int j = 0; j <= target; j++) {
                if(j == 0) {
                    dp[i][j] = 1;
                }else{
                    for (int k = 0; k <= j / coins[i-1]; k++) {
                        dp[i][j] += dp[i-1][j - k * coins[i-1]];
                    }
                }

            }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[kinds][target];
    }

    public static void main(String[] args) {
        System.out.println(coinConbination(coins, 3, 5));
    }
}
