package _279_完全平方数;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 */
public class Main {

    public int numSquares(int n) {
        //dp[i]当目标数为 i 是的最少个数
        int[] dp = new int[n + 1];

        for(int i = 1; i < dp.length; i++){
            //初始值设为最坏的情况
            dp[i] = i;

            //遍历所有 i - num * num >= 0的情况
            //dp[i] 要么选择初始值，要么选择dp[i - num * num] + 1
            for(int num = 1; i - num * num >= 0; num++){
                dp[i] = Math.min(dp[i], dp[i - num * num] + 1);
            }
        }
        return dp[n];
    }

}
