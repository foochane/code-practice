package _15_三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums).toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 3) return list;
        Arrays.sort(nums);


        for (int i = 0;i < nums.length; i++) {
            if(nums[i] > 0) continue;
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重

            int left = i + 1;
            int right = nums.length -1;
            while (left < right){

                // 如果加上第二个数据就大于零就没必要计算后面的了
                if(nums[i] + nums[left] > 0) break;

                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left + 1 < right && nums[left] == nums[left + 1]) left++;
                    while (left < right - 1 && nums[right - 1] == nums[right]) right--;
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else {
                    right--;
                }
            }


        }
        return list;
    }
}
