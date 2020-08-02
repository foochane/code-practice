package 重叠区间个数;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 给定多个可能重叠的区间，找出重叠区间的个数。
 *
 * 举例如下：
 *
 * 输入：[1，5]，[10，15]，[5，10]，[20，30]
 *
 * 输出：2
 *
 *
 *
 * 说明：题意应该是找出重叠区间中区间的最大个数，当没有区间重叠时，重叠个数最大为1，比如
 *
 * 输入为：[1，5]，[10，15]，则输出为1；
 *
 * 输入为：[1，2]，[2，3]，[3，4]，[4，5]，则输出为 1；
 *
 * 输入为：[1，7]，[2，5]，[3，4]，[8，15]，[9，17]，[20，25]，则输出为3。
 *
 * 猿辅导笔试题，改为学生上课，课程冲突的最大数量
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] nums = new int[2 * N][2];
        for (int i = 0; i < 2 * N; i++) {
            nums[i][0] = sc.nextInt(); //存起点和终点的数值
            nums[i][1] = i % 2 == 0? 1 : -1; //如果是起点存1，终点存-1
        }

        Arrays.sort(nums, Comparator.comparingInt(o -> o[0]));//起点值和终点值放一起排序

        int max  = 0, cur = 0;
        for(int i = 0; i < 2 * N; i++){
            cur += nums[i][1];//遇到起点+1，遇到终点-1
            max = Math.max(cur, max);
        }

        System.out.println(max);
    }
}
