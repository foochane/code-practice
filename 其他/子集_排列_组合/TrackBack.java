package 子集_排列_组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯
 */
public class TrackBack {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = new ArrayList<>();
//        trackBackSubsets(0, nums, ans, new LinkedList<>());
//        trackBackCombine(0, nums, ans, new LinkedList<>(),2);
        trackBackPermute(0, nums, ans, new LinkedList<>(),2);
        System.out.println(ans.toString());
    }

    /**
     * 回溯-子集
     * @param p 当前指针
     * @param nums 选择集合数组
     * @param ans 结果集合
     * @param cur 当前集合
     */
    public static void trackBackSubsets(int p , int[] nums, List<List<Integer>> ans, LinkedList<Integer> cur){
        //1 满足条件，添加到结果集
        ans.add(new ArrayList<>(cur));

        //2 遍历选择列表
        for(int i = p; i < nums.length; i++){
            //2.1 筛选

            //2.2 选择
            cur.addLast(nums[i]);

            //2.3 回溯
            trackBackSubsets(i + 1, nums, ans, cur);

            //2.4 取消选择
            cur.removeLast();
        }
    }

    /**
     * 回溯-组合
     * @param p 当前指针
     * @param nums 选择集合数组
     * @param ans 结果集合
     * @param cur 当前集合
     * @param k 每组组合的数量
     */
    public static void trackBackCombine(int p , int[] nums, List<List<Integer>> ans, LinkedList<Integer> cur, int k){
        //1 满足条件，添加到结果集
        if(cur.size() == k){
            ans.add(new ArrayList<>(cur));
            return;
        }

        //2 遍历选择列表
        for(int i = p; i < nums.length; i++){
            //2.1 筛选

            //2.2 选择
            cur.addLast(nums[i]);

            //2.3 回溯
            trackBackCombine(i + 1, nums, ans, cur, k);

            //2.4 取消选择
            cur.removeLast();
        }
    }

    /**
     * 回溯-排列
     * @param p 当前指针
     * @param nums 选择集合数组
     * @param ans 结果集合
     * @param cur 当前集合
     * @param k 每组组合的数量
     */
    public static void trackBackPermute(int p , int[] nums, List<List<Integer>> ans, LinkedList<Integer> cur, int k){
        //1 满足条件，添加到结果集
        if(cur.size() == k){
            ans.add(new ArrayList<>(cur));
            return;
        }

        //2 遍历选择列表
        for(int i = 0; i < nums.length; i++){
            //2.1 筛选
            if(cur.contains(nums[i])) continue;

            //2.2 选择
            cur.addLast(nums[i]);

            //2.3 回溯
            trackBackPermute(i + 1, nums, ans, cur, k);

            //2.4 取消选择
            cur.removeLast();
        }
    }
}
