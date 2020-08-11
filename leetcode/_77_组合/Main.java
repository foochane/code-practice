package _77_组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 */
public class Main {

    public static void main(String[] args) {
        int n = 4, k = 2;

        System.out.println(combine(n, k).toString());

    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        traceback(1, n, k, ans, new ArrayList<>());
        return ans;
    }

    private static void traceback(int p, int n, int k, List<List<Integer>> ans, ArrayList<Integer> temp) {
        //1 满足条件添加到结果集
        if(temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        //2 遍历选择
        for(int i = p; i <= n; i++){
            //2.1 选择一个添加的临时集合
            temp.add(i);

            //2.2 回溯
            traceback(i + 1, n, k, ans, temp);

            //2.3 清空临时变量
            temp.remove(temp.size() - 1);
        }
    }
}

