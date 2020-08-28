package 背包问题.多重背包问题;

import java.util.Scanner;

/**
 *
 * 有N种物品和一个容量为V的背包。第i种物品的价值是values[i]，重量是weights[i]，物品的数量是nums[i]
 * 求解将哪些物品装入背包可使价值总和最大。
 *
 * 参考：https://blog.csdn.net/weixin_42692345/article/details/105984579
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //物品数量
        int V = sc.nextInt(); //背包容量
        int[] values = new int[N]; //物品价值
        int[] weights = new int[N]; //物品重量
        int[] nums = new int[N]; //物品数量
        for(int i = 0; i < N; i++){
            values[i] = sc.nextInt();
            weights[i] = sc.nextInt();
            nums[i] = sc.nextInt();
        }
        System.out.println(multiplePackV1(V, N, values, weights, nums));
    }

    /**
     * 多重背包， 使用二维数组
     * @param V 背包容量
     * @param N 物品数量
     * @param values 物品价值
     * @param weights 物品重量
     * @param nums 物品的数量
     * @return 背包能装的最大价值
     */
    private static int multiplePackV1(int V, int N, int[] values, int[] weights, int[] nums) {
        int[][] dp = new int[N + 1][V + 1]; //可选取前i个物品,背包容量为j时的最大价值
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= V; j++){
                //如果第i件物品的重量大于背包容量j, 则不装入背包
                //由于weights和values数组下标都是从0开始, 故第i个物品的重量为weights[i-1], 价值为values[i-1]
                if(weights[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    int count = Math.min(nums[i - 1], j / weights[i - 1]); //当前第i个物品可以装的数量
                    //判断装几件第i个物品最优
                    for (int k = 0; k < count; k++) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k * weights[i - 1]] + k * values[i - 1]);
                    }
                }
            }
        }
        return dp[N][V];
    }
}