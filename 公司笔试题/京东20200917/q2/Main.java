package 京东20200917.q2;

/**
 * 王子与公主
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 在一个n行m列的二维地图中，王子的位置为(x1,y1)，公主的位置为(x2,y2)。
 *
 * 在地图中设有一些障碍物，王子只能朝上、下、左、右四个方向行走，且不允许走出地图也不允许穿越障碍物。
 *
 * 请编写一个程序判断王子是否可以顺利走到公主所在的位置。
 *
 *
 *
 * 输入描述
 * 多组输入，第1行输入一个正整数T表示输入数据的组数。
 *
 * 对于每一组输入数据：输入n+1行。
 *
 * 其中，第1行输入两个正整数n和m表示地图的大小，n为行数，m为列数。（n<=100,m<=100）
 *
 * 接下来n行表示地图，每一行都有m个字符，其中S表示王子的位置，E表示公主的位置，'.'表示可以通行，'#'表示障碍物（不能通行）。
 *
 * 输出描述
 * 针对每一组输入数据，判断王子是否能够到达公主所在位置？如果可以输出“YES”，否则输出“NO”。
 *
 *
 * 样例输入
 * 2
 * 2 2
 * .E
 * S.
 * 2 2
 * #E
 * S#
 * 样例输出
 * YES
 * NO
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static String result = "NO";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt(); //行
            int m = sc.nextInt(); //列
            int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
            char[][] map = new char[n][m];
            for (int x = 0; x < n; x++) {
                String s = sc.next();
                for (int y = 0; y < m; y++) {
                    map[x][y] = s.charAt(y);
                    if(map[x][y] == 'S'){
                        x1 = x;
                        y1 = y;
                    }
                    if(map[x][y] == 'E'){
                        x2 = x;
                        y2 = y;
                    }
                }
            }
            if(x1 == -1 || x2 == -1){
                System.out.println("NO");
            }
            LinkedList<int[]> list =  find(map, x1, y1);

            while (list.size() > 0){
                int[] temp = list.pollFirst();
                map[temp[0]][temp[1]] = '#';
                LinkedList<int[]> path =  find(map, temp[0], temp[1]);
                for (int[] ints : path) {
                    list.addLast(ints);
                }
            }

            System.out.println(result);

        }

    }

    private static LinkedList<int[]> find(char[][] map, int x, int y) {
        LinkedList<int[]> ans = new LinkedList<>();
        //左
        if(x - 1 >= 0 && map[x - 1][y] == '.'){
            if(map[x][y + 1] == 'E' ) result = "YES";
            ans.add(new int[]{x - 1, y});
        }

        //右边
        if(x + 1 < map.length && map[x + 1][y] == '.'){
            if(map[x][y + 1] == 'E' ) result = "YES";
            ans.add(new int[]{x + 1, y});
        }

        //上
        if(y - 1 >= 0 && map[x][y - 1] == '.'){
            if(map[x][y + 1] == 'E' ) result = "YES";
            ans.add(new int[]{x, y - 1});
        }

        //下
        if(y + 1 < map[0].length && map[x][y + 1] == '.'){
            if(map[x][y + 1] == 'E' ) result = "YES";
            ans.add(new int[]{x, y + 1});
        }

        return ans;
    }
}