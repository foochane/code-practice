package 阿里笔试题20200828.question1;

/**
 * 含有0和1的两个字符串，可以进行翻转，交换，和替换操作
 * 求把一个字符串替换成另一个字符串的最小次数
 *
 * 输入：第一行字符串长度，接下来两个字符串
 * 输出：最小次数
 *
 * 如：
 * 7
 * 0010011
 * 1111000
 * 输出：
 * 3
 */

import java.util.*;

//全a了
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s1 = sc.next();
        String s2 = sc.next();
        String s3 = new StringBuffer(s2).reverse().toString();
        int countOne1 = 0;
        int countOne2 = 0;
        int countOne3 = 0;
        int dif1And2 = 0;
        int dif1And3 = 0;
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            char c3 = s3.charAt(i);
            if(c1 == '1') countOne1++;
            if(c2 == '1') countOne2++;
            if(c3 == '1') countOne3++;
            if(c1 != c2) dif1And2++;
            if(c1 != c3) dif1And3++;
        }
        int temp1 = Math.abs(countOne1 - countOne2);
        int temp2 = Math.abs(countOne1 - countOne3);
        int change1 = temp1  + (dif1And2 - temp1) / 2 ;
        int change2 = temp2 + (dif1And3 - temp2) / 2 + 1;

        System.out.println(Math.min(change1, change2));
    }
}
