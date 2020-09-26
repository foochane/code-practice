package 奇安信笔试20200925.q1;
/**
 * n级台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * f(1)=1
 * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(1) + 1
 * f(n-1) = f(n-2) + f(n-3) + f(n-4) + ... + f(1) + 1
 * f(n) = 2f(n-1)
 * f(n) = 2^(n-1)
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //台阶数
        int ans = (int) Math.pow(2, n -1);
        System.out.print(ans);

    }
}
