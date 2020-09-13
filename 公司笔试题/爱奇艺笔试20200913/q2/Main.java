package 爱奇艺笔试20200913.q2;

/**
 * 多数元素
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一个大小为 n 的整数数组，找到其中的多数元素。多数元素是指在数组中出现次数大于『n/2』的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 输入描述
 * 空格分隔的整数序列，即数组
 *
 * 输出描述
 * 数组中出现最多的整数
 *
 *
 * 样例输入
 * 3 2 3
 * 样例输出
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] chars = s.split(" ");
        Arrays.sort(chars);
        System.out.println(chars[chars.length  / 2]);
    }
}
