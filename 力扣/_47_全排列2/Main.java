package _47_全排列2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        System.out.println(permuteUnique(nums));

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        Arrays.sort(nums);
        traceBack(0, nums, used, ans, new LinkedList<>());
        return ans;
    }

    private static void traceBack(int p, int[] nums, boolean[] used, List<List<Integer>> ans, LinkedList<Integer> cur) {
        if(cur.size() == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i > 0 && nums[i - 1]== nums[i]) && used[i - 1]) continue;
            //选择
            cur.addLast(nums[i]);

            //回溯
            used[i] = true;
            traceBack(i + 1, nums, used, ans, cur);
            used[i] = false;

            cur.removeLast();
        }
    }
}
