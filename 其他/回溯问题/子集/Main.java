package 回溯问题.子集;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 */
public class Main {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] nums = {1,2,3};
        recur(nums, 0, ans, new LinkedList<>());
        System.out.println(ans);
    }

    /**
     * 遍历数组nums，对于每一个数都可以选择选或者不选
     * @param nums 数组
     * @param p 数组指针
     * @param ans 结果集
     * @param cur 当前list
     */
    private static void recur(int[] nums, int p, List<List<Integer>> ans, LinkedList<Integer> cur) {
        //终止条件
        if(p == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }

        //选
        //方式一：直接拷贝一份cur
        //LinkedList<Integer> temp = new LinkedList<>(cur);
        //temp.addLast(nums[p]);
        //recur(nums, p + 1, ans, temp);
        //方式二：cur先放入元素，用完再删除
        cur.addLast(nums[p]);
        recur(nums, p + 1, ans, cur);
        cur.removeLast();

        //不选
        recur(nums, p + 1, ans, cur);
    }

}
