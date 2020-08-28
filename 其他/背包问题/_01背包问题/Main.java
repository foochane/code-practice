package 背包问题._01背包问题;

import java.util.Scanner;

/**

 *
 * 有N件物品和一个容量为V的背包。第i件物品的价值是values[i]，重量是weights[i]。
 * 求解将哪些物品装入背包可使价值总和最大。
 *
 * 输入描述:
 * 输入第一行数 N V (1 <=N <=500) (1<= V <= 10000)
 *
 * 输入 N行 两个数字 代表 value weight (1 <= C <= 50000, 1 <= W <=10000)
 *
 *
 * 输出描述:
 * 输出最大价值
 * 示例1
 * 输入
 * 5 10
 * 8 6
 * 10 4
 * 4 2
 * 5 4
 * 5 3
 * 输出
 * 19
 *
 * 示例2
 * 输入
 * 1 1
 * 10 2
 * 输出
 * 0
 *
 * 链接：https://www.nowcoder.com/questionTerminal/3ee42c9155c340588729995561ace594
 *
 * 参考：https://blog.csdn.net/weixin_42692345/article/details/105984579
 */
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //物品数量
        int V = sc.nextInt(); //背包容量
        int[] values = new int[N]; //物品价值
        int[] weights = new int[N]; //物品重量
        for(int i = 0; i < N; i++){
            values[i] = sc.nextInt();
            weights[i] = sc.nextInt();
        }
        System.out.println(zeroOnePackV1(V, N, values, weights));
    }

    /**
     * 01背包， 使用二维数组
     * @param V 背包容量
     * @param N 物品数量
     * @param values 物品价值
     * @param weights 物品重量
     * @return 背包能装的最大价值
     */
    private static int zeroOnePackV1(int V, int N, int[] values, int[] weights) {
        int[][] dp = new int[N + 1][V + 1]; //可选取前i个物品,背包容量为j时的最大价值
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= V; j++){
                //如果第i件物品的重量大于背包容量j, 则不装入背包
                //由于weights和values数组下标都是从0开始, 故第i个物品的重量为weights[i-1], 价值为values[i-1]
                if(weights[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[N][V];
    }


    /**
     * 01背包， 逆序实现，一维滚动数组
     * @param V 背包容量
     * @param N 物品数量
     * @param values 物品价值
     * @param weights 物品重量
     * @return 背包能装的最大价值
     */
    private static int zeroOnePackV2(int V, int N, int[] values, int[] weights) {
        int[] dp = new int[V + 1]; //背包容量为i时的最大价值
        for(int i = 0; i < N; i++){
            for(int j = V; j >= weights[i]; j--){
                dp[j] = Math.max(dp[j - weights[i]] + values[i], dp[j]);
            }
        }
        return dp[V];
    }


}