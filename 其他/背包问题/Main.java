package 背包问题;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/3ee42c9155c340588729995561ace594
 * 来源：牛客网
 *
 * 有N件物品和一个容量为V的背包。第i件物品的价值是C[i]，重量是W[i]。求解将哪些物品装入背包可使价值总和最大。
 *
 *
 * 输入描述:
 * 输入第一行数 N V (1 <=N <=500) (1<= V <= 10000)
 *
 * 输入 N行 两个数字 代表 C W (1 <= C <= 50000, 1 <= W <=10000)
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
 * 示例2
 * 输入
 * 1 1
 * 10 2
 * 输出
 * 0
 */
public class Main{
    public static void main(String[] agrs){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //物品数量
        int V = sc.nextInt(); //背包容量
        int[] values = new int[N]; //物品价值
        int[] weights = new int[N]; //物品重量
        for(int i = 0; i < N; i++){
            values[i] = sc.nextInt();
            weights[i] = sc.nextInt();
        }
        int[] dp = new int[N + 1]; //背包容量为i时的最大价值
        for(int i = 1; i < N + 1; i++){
            for(int j = V; j >= weights[i - 1]; j--){
                dp[j] = Math.max(dp[j], dp[j - weights[i - 1] + values[i - 1]]);
            }
        }
        System.out.println(dp[N]);
    }
}