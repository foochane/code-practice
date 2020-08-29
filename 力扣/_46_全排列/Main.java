package _46_全排列;

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
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        traceback(0, nums, ans, new LinkedList<>());
        return ans;
    }

    public void traceback(int p, int[] nums, List<List<Integer>> ans, LinkedList<Integer> temp){
        //1 满足条件就添加到结果集合
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        //2 遍历选择列表
        for(int i = 0;i < nums.length; i++){
            //2.1 筛选
            if(temp.contains(nums[i])) continue;

            //2.2 选择
            temp.add(nums[i]);

            //2.3 回溯
            traceback(i + 1, nums, ans, temp);

            //2.4 取消选择
            temp.removeLast();
        }
    }
}
