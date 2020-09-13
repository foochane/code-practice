package 爱奇艺笔试20200913.q1;

/**
 * 无重复字符的最长字串
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 *
 *
 * 输入描述
 * 一个字符串，里面的字符可以有重复
 *
 * 输出描述
 * 输出为一个数字，表示最长不重复字符串的长度
 *
 *
 * 样例输入
 * abcdab
 * 样例输出
 * 4
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        int start = 0;
        int end = start;
        int max = 0;
        while(end < len){
            char c= s.charAt(end);
            if(map.containsKey(c)){
                start = Math.max(map.get(c) + 1, start);
            }
            map.put(c, end);
            max = Math.max(max, end - start + 1);
            end++;
        }

        System.out.println(max);
    }
}
