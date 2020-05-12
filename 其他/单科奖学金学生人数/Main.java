package 单科奖学金学生人数;

/**
 * 某些学校为各科成绩优势的同学颁发单科优秀奖学金
 * 有 n 个同学，m科成绩，选出 m 科中成绩最高的一位或者多位同学给以奖励
 * 计算可以获奖的同学人数
 * <p>
 * 输入：
 * n m
 * n行m列数据
 * 输出
 * 获奖同学人数
 * <p>
 * 实例，输入：
 * 4 4
 * 90 77 77 99
 * 90 33 89 90
 * 88 33 33 72
 * 72 33 99 83
 * 输出：
 * 3
 * <p>
 * <p>
 * 20200512
 */

import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n, m;

        n = cin.nextInt();
        m = cin.nextInt();
        int[][] data = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = cin.nextInt();
            }
        }


        int temp;
        int[] max = new int[n];
        ArrayList<Integer> list = new ArrayList<Integer>();

        // 第i科
        for (int i = 0; i < m; i++) {
            temp = 0;
            // 第i科，第j位同学，将第i科成绩最高的同学编号存入list
            for (int j = 0; j < n; j++) {
                if (temp < data[j][i]) {
                    temp = data[j][i];
                    list.clear();
                    list.add(j);
                    continue;
                }
                if (temp == data[j][i]) {
                    list.add(j);
                }

            }

            // 设置n个同学是否可以获奖，可以设为1
            for (Integer x : list) {
                max[x] = 1;
            }
            list.clear();
        }


        // max数组之和为获奖人数
        int result = 0;
        for (int i = 0; i < max.length; i++) {

            result += max[i];
        }

        System.out.print(result);
    }
}