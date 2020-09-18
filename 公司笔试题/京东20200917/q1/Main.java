package 京东20200917.q1;

/**
 * 提取年份
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小明想从一段英文短文中提取潜在的年份信息，待匹配的年份的范围为1000年至3999年，包含1000和3999。
 *
 * 输入一段英文短文，按出现次序输出所提取到的所有可能的年份字符串。
 *
 *
 *
 * 输入描述
 * 单组输入，输入一段英文短文，可能包含字母大小写，标点符号及空格。（不超过2000个字符）
 *
 * 输出描述
 * 输出所提取到的所有可能的年份字符串，两两之间用一个空格隔开。
 *
 *
 * 样例输入
 * And millionaires will hold 46% of total wealth by 2019, the report says. This ratio is likely to increase in 2020.
 * 样例输出
 * 2019 2020
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
            String s = sc.nextLine();
            char[] chars = s.toCharArray();
            //System.out.println(Arrays.toString(chars));
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < chars.length;) {
                String str = "";
                while (i < chars.length && chars[i] <= '9' && chars[i] >= '0'){
                    str = str + chars[i];
                    i++;
                }
                if(str.length() >= 1){


                    if (str.charAt(0) <= '3' && str.charAt(0) >= '1' && str.length() == 4){
                            ans.add(str);
                    }

//                    if(str.length() > 4){
//                        while (str.length() >= 4){
//                            if (str.charAt(0) <= '3' && str.charAt(0) >= '1'){
//                                ans.add(str.substring(0, 4));
//                                break;
//                            }
//                            str = str.substring(1);
//                        }
//                    }
//



                }else {
                    i++;
                }
            }

            for (int i = 0; i < ans.size(); i++) {
                System.out.print(ans.get(i));
                if(i != ans.size() -1){
                    System.out.print(" ");
                }
            }

//        }
    }
}
