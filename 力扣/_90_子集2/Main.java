package _90_子集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(subsetsWithDup(nums).toString());

    }

    //逐个枚举
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        int lastSize = 1;
        for (int i = 0; i < nums.length; i ++) {
            int ansSize = ans.size();
            for (int j = 0; j < ansSize; j ++) {
                List<Integer> sub = new ArrayList<>(ans.get(j));
                // 如果第i个数与前一个数相同，则跳过上次遍历过的部分
                if (i > 0 && nums[i] == nums[i - 1] && j < lastSize)
                    continue;
                sub.add(nums[i]);
                ans.add(sub);
            }
            lastSize = ansSize;
        }
        return ans;
    }

    //回溯
    public static List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        traceback(0, nums, ans, new ArrayList<>());
        return ans;

    }

    private static void traceback(int p, int[] nums, List<List<Integer>> ans, ArrayList<Integer> temp) {
        //1 条件满足就添加到结果集
        ans.add(new ArrayList<>(temp));

        //2 遍历选择列表
        for(int i = p; i < nums.length; i++){
            if(i > p && nums[i - 1] == nums[i]) continue;
            //2.1 做选择，添加到临时集合
            temp.add(nums[i]);

            //2.2 回溯
            traceback(i + 1, nums, ans, temp);

            //2.3 撤销选择
            temp.remove(temp.size() - 1);
        }
    }
}
