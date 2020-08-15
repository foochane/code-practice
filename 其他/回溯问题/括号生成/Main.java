package 回溯问题.括号生成;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
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
        int n = 3;
        List<String> ans = new ArrayList<>();
        //recur1(n * 2, 0, ans, "");
        recur3(0, 0, n, ans, "");
        System.out.println(ans);
    }

    /**
     * 测试
     * 每个字符串的长度总为 N,对于第 i 位可以加 ”(“ 或者 ”)“
     * @param N 每个字符串的长度
     * @param i 第 i 位
     * @param ans 结果集合
     * @param s 当前字符串
     */
    private static void recur(int N, int i,List<String> ans, String s) {
        //终止条件
        if(i == N){
            System.out.println(s);
            return;
        }

        //回溯
        recur(N, i + 1, ans, s + "("); //加(
        recur(N, i + 1, ans, s + ")"); //加 )
    }


    /**
     * 简单回溯对结果进行筛选
     * 每个字符串的长度总为 N,对于第 i 位可以加 ”(“ 或者 ”)“
     * 对结果进行选择，当当前字符串的长度达到 N 时， 判断是否符号条件，符号就放入结果集
     * @param N 每个字符串的长度
     * @param i 第 i 位
     * @param ans 结果集合
     * @param s 当前字符串
     */
    private static void recur1(int N, int i,List<String> ans, String s) {
        //终止条件
        if(i == N){
            if(check(s)) ans.add(s); //判断是否符合条件，符合就放入ans里
            return;
        }

        //回溯
        recur1(N, i + 1, ans, s + "("); //加(
        recur1(N, i + 1, ans, s + ")"); //加 )
    }

    //判断括号是否有效
    //遇到左括号入栈，遇到右括号出栈，如果有多余的右括号或者s遍历完栈不为空则返回false
    private static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push('(');
            }else if(c == ')') {
                //如果为空说明 ) 多余左括号，返回false
                if(stack.isEmpty()) return false;

                //弹出一个( 与 )抵消
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * 先减枝，再回溯，产生的结果直接放入ans
     * 每个字符串的长度总为 N,对于第 i 位可以加 ”(“ 或者 ”)“
     * 对结果进行选择，当当前字符串的长度达到 N 时， 判断是否符号条件，符号就放入结果集
     * @param left 左括号的个数
     * @param right 右括号的个数
     * @param max 括号的对数
     * @param ans 结果集合
     * @param s 当前字符串
     */
    private static void recur3(int left, int right, int max,List<String> ans, String s) {
        //终止条件
        if(max == left && right == max){
            ans.add(s); //s已经符合就直接放入ans里
            return;
        }

        //回溯
        //左括号有没有用完一直可以放
        if(left < max) recur3(left + 1, right, max, ans, s + "("); //加(

        //右括号少于左括号，就可以放右括号
        if(right < left) recur3(left, right + 1, max, ans, s + ")"); //加(

    }


}
