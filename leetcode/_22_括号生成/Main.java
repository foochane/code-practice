package _22_括号生成;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 *
 */
public class Main {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = cin.nextInt();

        List<String> list = generateParenthesis(n);

        System.out.println(list);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        //1 定义递归函数
        generate(0,0, n, "", list);

        return list;
    }

    private static void generate(int left, int right, int max, String s, List<String> list) {
        //2 定义终止条件
        if(left == max && right == max) {
            list.add(s);
            return;
        }

        //3 处理当前层逻辑


        //4 下一层逻辑
        if(left < max)
            generate(left + 1, right, max, s + "(", list);


        if(left <= max && right < left)
            generate(left,right + 1, max, s + ")", list);

    }


}
