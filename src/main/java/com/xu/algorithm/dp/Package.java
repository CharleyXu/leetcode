package com.xu.algorithm.dp;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/25.
 *
 * 背包问题 动态规划
 */
public class Package {

  /**
   * dp[i][j]表示前i件物品能装入容量为j的背包中的物品价值总和的最大值(注意是最大值),
   *
   * 状态转移方程
   *
   * dp[i-1][j]    (w[i]>j)
   *
   * dp[i][j]=
   *
   * max(dp[i-1][j],dp[i-1][j-w[i]] + v[i])
   *
   * 只用一个一维数组记录状态，dp[i]表示容量为i的背包所能装入物品的最大价值
   *
   * 0-1背包,每类物品最多只能装一次
   *
   * for i <= 1  to N
   *
   * for v <= V to 0
   *
   * dp[v] = max{dp[v], dp[v- w[i]] + v[i]}
   */
  public int pack(int V, int N, int[] weight, int[] value) {
    int[] dp = new int[V + 1];
    //
    for (int i = 1; i <= N; i++) {
      //逆序
      for (int j = V; j >= weight[i - 1]; j--) {
        dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
      }
    }
    return dp[V];
  }

  /**
   * 2、多重背包：每类物品都有个数限制，第i类物品最多可以装num[i]次
   *
   * dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-k*weight[i-1]]+k*value[i-1]);
   */
  public int manyPack(int V, int N, int[] weight, int[] value, int[] num) {
    int[][] dp = new int[N + 1][V + 1];
    //个数
    for (int i = 1; i <= N; i++) {
      //容量
      for (int j = 1; j <= V; j++) {
        if (weight[i - 1] > V) {
          dp[i][j] = dp[i - 1][j];
        } else {
          //物品的限制数
          int maxItem = Math.min(num[i - 1], j / weight[i - 1]);
          for (int k = 1; k <= maxItem; k++) {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * weight[i - 1]] + k * value[i - 1]);
          }
        }
      }
    }
    return dp[N][V];
  }

  /**
   * 3、完全背包：每类物品可以无限次装进包内
   *
   * dp[i][j]=Math.max(dp[i-1][j],dp[i][j-weight[i]]+value[i])
   */
  public int fullPack(int V, int N, int[] weight, int[] value) {
    int[] dp = new int[V + 1];
    for (int i = 1; i <= N; i++) {
      //正序
      for (int j = weight[i - 1]; j <= V; j++) {
        dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
      }

/*      for (int j = 0; j <= V; j++) {
        if (j>=weight[i-1]){
          dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
        }
      }    */

    }
    return dp[V];
  }

  @Test
  public void packTest() {
    int V = 20, N = 4;
    int[] weight = new int[]{1, 5, 3, 8};
    int[] value = new int[]{2, 13, 4, 15};
    int[] num = new int[]{1, 4, 1, 1};
    System.out.println(pack(V, N, weight, value));
    System.out.println(manyPack(V, N, weight, value, num));
    System.out.println(fullPack(V, N, weight, value));
  }
}
