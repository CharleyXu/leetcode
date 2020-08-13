package com.xu.algorithm.dp;

import org.junit.Test;

/**
 * @author CharleyXu Created on 2019/3/28.
 *
 * 求方案总数
 *
 * 硬币找零
 *
 * 一个数可以在组合中出现多次(完全背包)， 数的顺序不同认为是不同的组合
 */
public class CombinationSum {

  /**
   * 硬币找零
   *
   * dp[i][j]表示用前i个硬币组成钱数为j的不同组合方法
   *
   * dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0)
   */


  /**
   * 考虑组合次序不同是不同的方案的话是
   *
   * 先迭代背包容量(空间)
   *
   * dp[i][j]=dp[i][j-weight[i]]+value[i])
   */
  public int backPackVI(int[] nums, int target) {
    int[] dp = new int[target + 1];
    //大小为0的背包 ，都不取值
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i >= nums[j]) {
          dp[i] += dp[i - nums[j]];
        }
      }
    }
    return dp[target];
  }

  @Test
  public void backPackVITest() {
    int[] nums = new int[]{1, 2};
    int target = 4;
    System.out.println(backPackVI(nums, target));
  }
  /**
   * Input: nums = [1, 2], and target = 4
   *
   Output: 5

   Explanation:

   The possible combination ways are:

   [1, 1, 1, 1]

   [1, 1, 2]

   [1, 2, 1]

   [2, 1, 1]

   [2, 2]
   */
}
