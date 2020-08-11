package 子集_排列_组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * DFS
 */
public class DFS {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = new ArrayList<>();
        DFSSubsets(0, nums, ans, new LinkedList<>());
        System.out.println(ans);
    }

    /**
     * DFS-子集
     * @param p 指针
     * @param nums 选择列表数组
     * @param ans 结果集合
     * @param cur 当前集合
     *
     * 注意：改方法生成的自己没有空集：[]
     */
    private static void DFSSubsets(int p, int[] nums, List<List<Integer>> ans, LinkedList<Integer> cur) {
        //终止条件
        if(p == nums.length) return;

        cur = new LinkedList<>(cur);

        ans.add(cur);

        //不选
        DFSSubsets(p + 1, nums, ans, cur);

        //选
        cur.add(nums[p]);
        DFSSubsets(p + 1, nums, ans, cur);
    }

}
