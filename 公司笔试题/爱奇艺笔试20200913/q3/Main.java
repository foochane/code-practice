package 爱奇艺笔试20200913.q3;

/**
 * 三数之和
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 输入描述
 * 空格分隔的整数序列
 *
 * 输出描述
 * 每行是一个空格分隔的三个整数，即三元组。输出顺序要求：1、行内按数字大小排列，小的元素排在前面；2、行间按三元组大小排列（如果两个三元组的第一个元素不一样，则三元组大小取决于第一个元素的大小，否则取决于下一个元素的比较，以此类推）
 *
 *
 * 样例输入
 * -1 0 1 2 -1 -4
 * 样例输出
 * -1 -1 2
 * -1 0 1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) continue;
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                if(nums[i] + nums[left] > 0) break;

                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left + 1 <right && nums[left] == nums[left + 1]) left++;
                    while (left < right - 1 && nums[right - 1] == nums[right]) right--;
                    left++;
                    right--;
                }else if(sum < 0){
                    left ++;
                }else {
                    right--;
                }
            }
        }

        for (List<Integer> num : list) {
            for (int i = 0; i < num.size(); i++) {
                System.out.print(num.get(i));
                if(i != num.size() - 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
