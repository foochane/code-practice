package 最长公共子串;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/181a1a71c7574266ad07f9739f791506
 * 来源：牛客网
 *
 * 查找两个字符串a,b中的最长公共子串
 * 热度指数：51649时间限制：C/C++ 1秒，其他语言2秒空间限制：C/C++ 32M，其他语言64M
 * 算法知识视频讲解
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 *
 * 输入描述:
 * 输入两个字符串
 *
 *
 * 输出描述:
 * 返回重复出现的字符
 * 示例1
 * 输入
 * abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 * 输出
 * jklmnop
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(findSubString(s1, s2));
        }
    }

    private static String findSubString(String s1, String s2) {
        //查找两个字符串中的最长公共子串若有多个，输出在较短串中最先出现的那个
        if(s1.length() > s2.length()){
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        int max = 0, left = 0, right = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                    if(dp[i][j] > max){
                        max = dp[i][j];
                        right = i;
                        left = right - max + 1;
                    }
                }
            }
        }
        return s1.substring(left, right + 1);
    }
}
