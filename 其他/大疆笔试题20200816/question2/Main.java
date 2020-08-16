package 大疆笔试题20200816.question2;

import java.util.Scanner;

/**
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 有许多程序员都热爱玩游戏，而小J自称为游戏王，曾玩过几百种游戏，几乎所有能玩到的游戏大作都玩遍了。随着时间的推移，他发觉已经没有游戏可以让他玩了！于是他想改玩一些古老的游戏，以成为真正的“游戏王”。他希望在接下来的一段时间内将过去出的游戏全部玩一遍，但是毕竟时间有限，因此他感到很苦恼。于是他想到一个计划，他先将每个游戏标上一个成就值，同时对每个游戏都估算一个通关所需要的天数，他计划在未来X天内让自己玩游戏的成就达到最大，那么他应该怎么做计划呢？（假设每个游戏最多只计划玩一遍，而且每个游戏必须玩完通关才能取得成就值，且通关每个游戏最小时间单位是1天）
 *
 *
 *
 * 输入描述
 * 第一行输入两个整数N和X，中间用空格隔开，其中N表示游戏的数目N(1<=N<=10)，X表示计划玩游戏的总时间天数 (1<=X<=1000)。
 *
 * 第二行输入第1个游戏的成就值A1(0<=A1<=10000) 和 通关所需要花费时间B1天 (1<=Bi<=500) 中间用空格隔开。
 *
 * 第N+1行输入第N游戏的成就值An(0<=An<=10000) 和 通关所需要花费时间Bn天(1<=Bn<=500) 中间用空格隔开
 *
 * 输出描述
 * 可以达到成就之和的最大值。
 *
 *
 * 样例输入
 * 2 2
 * 10 1
 * 20 2
 * 样例输出
 * 20
 *
 * 提示
 * 输入样例二:
 * 3 4
 * 10 2
 * 18 3
 * 10 2
 * 输出样例二:
 * 20
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //游戏数
        int X = sc.nextInt(); //天数
        int[] Weight = new int[N];
        int[] Value = new int[N];
        for (int i = 0; i < N; i++) {
            Value[i] = sc.nextInt();
            Weight[i] = sc.nextInt();
        }

        System.out.println(solution(X, N, Weight, Value));
    }

    private static int solution(int X, int N, int[] weight, int[] value) {
        int[] dp = new int[X + 1];

        for (int i = 1; i < N + 1; i++) {
            for(int j = X; j >= weight[i - 1]; j--){
                dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
            }
        }
        return dp[X];
    }

}
