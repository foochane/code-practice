package 括号生成;

import java.util.*;

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

        System.out.println(list.toString());
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        generateAll(new char[n * 2], 0, list);
        return list;
    }
    private static void generateAll(char[] current, int pos, List<String> list) {

        if(current.length == pos){
            if(valid(current)) list.add(new String(current));
        }else {
            current[pos] = '(';
            generateAll(current,pos + 1, list);
            current[pos] = ')';
            generateAll(current,pos + 1, list);
        }
    }

    private static boolean valid(char[] current) {
        int balance = 0;

        for (char c : current) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
                if (balance < 0) return false;
            }
        }
        return balance == 0;
    }
}
