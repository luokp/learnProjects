package com.luokp;

/**
 * @author: luokp
 * @date: 2019/4/29 17:41
 * @description:
 */
public class _887EggDrop {
    //状态转移方程 f(k, n) = Min(max(f(k, n-x), f(k-1, x-1)), 1 <= x <= n;
    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        for(int i = 1; i < N+1; i++) {
            dp[1][i] = i;
        }
        for(int i = 1; i < K+1; i++) {
            dp[i][1] = 1;
        }

        for(int k = 2; k < K+1; k++)
            for(int n = 2; n < N+1; n++) {
                int max = 0;
                dp[k][n] = Integer.MAX_VALUE;
                for(int x = 1; x <= n; x++) {
                    dp[k][n] = Math.min(dp[k][n], Math.max(dp[k][n-x] + 1, dp[k-1][x-1] + 1));
                }
            }
        return dp[K][N];
    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(6,100));
        System.out.println(Character.isLetterOrDigit('`'));
        ;
    }
}
