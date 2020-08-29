package _78_子集;

import java.util.ArrayList;
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
        int[] nums = {1,2,3};
        System.out.println(subsets1(nums).toString());
    }

    //方法一： 逐一枚举
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        //ans先添加一个空集合
        ans.add(new ArrayList<>());

        //遍历nums一次添加到ans里面
        for(int n : nums){
            //ans里的每个集合都添加num
            for(int i = 0; i < ans.size(); i++){
                List<Integer> temp = new ArrayList<>(ans.get(i));
                temp.add(n);
                ans.add(temp);
            }
        }

        return ans;
    }

    //方法二：回溯
    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        dfs(0, nums, ans, new ArrayList<>());

        return ans;
    }


    /**
     * 回溯
     * @param p 选择列表指针
     * @param nums 选择列表
     * @param ans 结果集合
     * @param temp 临时集合
     */
    private static void traceback(int p, int[] nums, List<List<Integer>> ans, ArrayList<Integer> temp) {
        //1 满足结果结束添加，临时集合添加到结果集
        //ans.add(temp); 这样添加的永远是空的list
        ans.add(new ArrayList<>(temp));

        //2 遍历选择列表
        for(int i = p; i < nums.length; i++){
            //2.1 做选择，添加到临时集合
            temp.add(nums[i]);

            //2.2 回溯
            traceback(i + 1, nums, ans, temp);

            //2.3 撤销选择
            temp.remove(temp.size() - 1);

        }
    }


    /**
     * DFS，前序遍历
     */
    public static void dfs(int i, int[] nums, List<List<Integer>> ans, ArrayList<Integer> temp) {
        if (i >= nums.length) return;

        temp = new ArrayList<>(temp);

        // 这里
        ans.add(temp);

        //不选
        dfs(i + 1,nums, ans, temp);

        //选
        temp.add(nums[i]);
        dfs(i + 1,nums, ans, temp);

    }

}
