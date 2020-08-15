package 回溯问题.全排列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 */
public class Main {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = {1,2,3};
        boolean[] visited = new boolean[nums.length];
        recur(nums, 0, visited, ans, new LinkedList<>());
        System.out.println(ans);
    }

    /**
     * 构造一个长度为nums.length的list，每一次从nums中取数据，先减枝，用过的就不用再去
     * @param nums 数组
     * @param p 数组指针
     * @param ans 结果集
     * @param cur 当前list
     */
    private static void recur(int[] nums, int p, boolean[] visited,List<List<Integer>> ans, LinkedList<Integer> cur) {
        //终止条件
        if(p == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }

        //选第i个数
        for (int i = 0; i < nums.length; i++) {
            //减枝，用过的数就不用了
            if(!visited[i]){
                //方式一：复制一份cur
                //LinkedList<Integer> temp = new LinkedList<>(cur);
                //temp.addLast(nums[i]);
                //visited[i] = true;
                //recur(nums, p + 1, visited, ans, temp);
                //visited[i] = false;

                //方式一：cur先添加然后在删除
                cur.addLast(nums[i]);
                visited[i] = true;
                recur(nums, p + 1, visited, ans, cur);
                cur.removeLast();
                visited[i] = false;
            }


        }
    }
}
