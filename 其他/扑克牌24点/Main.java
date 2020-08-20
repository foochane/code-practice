package 扑克牌24点;

import java.util.*;

/**
 *
 * 题目描述
 * 计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，
 * 本问题中，扑克牌通过如下字符或者字符串表示，其中，小写joker表示小王，大写JOKER表示大王：
 *
 *                    3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 *
 * 本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。
 *
 * 详细说明：
 *
 * 1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，友情提醒，整数除法要当心；
 * 2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
 * 3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
 * 4.输出的算式格式为4张牌通过加减乘除，四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
 * 5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24
 * 6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。
 *
 * 输入描述:
 * 输入4张牌为字符串形式，以一个空格隔开，首尾无空格；
 *
 * 输出描述:
 * 如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
 * 示例1
 * 输入
 * 复制
 * A A A A
 * 输出
 * 复制
 * NONE
 */

public class Main{
    public static String ans = "NONE";
    public static Map<String,Double> map = new HashMap<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] nums = sc.nextLine().split(" ");

            boolean isError = false;
            for (String num : nums) {
                if (num.equals("joker") || num.equals("JOKER")) {
                    isError = true;
                    break;
                }
            }

            if(isError){
                System.out.println("ERROR");
            }else{
                setMap(map);
                ans = "NONE";
                boolean[] visited = new boolean[nums.length];
                recur(nums, visited, 0, "");
                System.out.println(ans);
            }
        }

    }

    private static void setMap(Map<String, Double> map) {
        for(int i = 2; i <= 10; i++){
            map.put(i + "", (double) i);
        }
        map.put("A", 1.0);
        map.put("J", 11.0);
        map.put("Q", 12.0);
        map.put("K", 13.0);
    }

    public static void recur(String[] nums,boolean[] visited, double result, String str){

        if(str.length() >= 8 && result == 24.0)
            ans = str.substring(1);

        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                recur(nums, visited,result + map.get(nums[i]), str + "+" + nums[i]);
                recur(nums, visited,result - map.get(nums[i]), str + "-" + nums[i]);
                recur(nums, visited,result * map.get(nums[i]), str + "*" + nums[i]);
                recur(nums, visited,result / map.get(nums[i]), str + "/" + nums[i]);
                visited[i] = false;
            }
        }
    }

}