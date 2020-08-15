package _322_零钱兑换;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *  
 *
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 */
public class Main {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 100;
        //System.out.println(coinChange(coins, amount));

        //dfs(coins, amount, new LinkedList<>());
        //System.out.println( ans == Integer.MAX_VALUE ? -1 : ans);

        System.out.println(bfs(coins, amount));
    }

    /**
     * 动态规划
     * @param coins 硬币数组
     * @param amount 要找零的总金额
     * @return 最少的硬币个数
     */
    public static int coinChange(int[] coins, int amount) {
        //总金额为 i 是的最少次数
        int dp[] = new int[amount + 1];

        //初始值设为最大值
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int curAmount = 1; curAmount < dp.length; curAmount++){
            for(int coin : coins){

                //dp[curAmount - coin] == Integer.MAX_VALUE,表示dp[curAmount - coin]没有有效的状态值
                //如coins = [3,6], amout = 11, dp[0,1,2]是无效的
                if(curAmount - coin >= 0 && dp[curAmount - coin] != Integer.MAX_VALUE){
                    dp[curAmount] = Math.min(dp[curAmount - coin] + 1, dp[curAmount]);
                }
            }
        }

        //如果不能找设为-1
        if(dp[amount] == Integer.MAX_VALUE) dp[amount] = -1;

        return dp[amount];

    }

    /**
     * dfs
     */
    public static int ans = Integer.MAX_VALUE;
    public static void dfs(int[] coins, int amount, LinkedList<Integer> cur){

        if(amount == 0) ans = Math.min(ans, cur.size()); //amount为0, 和之前的ans比较，如果更小就保存
        if(amount <= 0) return; //如果amount小于等于0，return

        //减枝，如果cur的大小大于 ans 就没必要再递归了
        if(ans != Integer.MAX_VALUE && cur.size() >= ans) return;

        for(int i = coins.length - 1; i >= 0; i--){
            cur.addLast(coins[i]);
            dfs(coins, amount - coins[i], cur);
            cur.removeLast();
        }
    }

    /**
     * bfs  会超时
     */
    public static int bfs(int[] coins, int amount){
        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(amount); //第一层
        int level = 0;
        boolean isFind = false;

        while (!isFind && !list.isEmpty()){
            level++;
            int size = list.size();
            for (int i = 0; i < size; i++) {

                Integer temp = list.pollFirst();
                if(temp != null && temp == 0) {
                    isFind = true;
                    break;
                }

                if(temp != null && temp > 0){
                    for(int coin : coins){
                        list.addLast(temp - coin);
                    }
                }
            }


        }
        return isFind ? level - 1 : -1;
    }


}
