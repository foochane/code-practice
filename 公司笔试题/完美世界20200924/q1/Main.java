package 完美世界20200924.q1;
/**
 * 天际线问题
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由这些建筑物形成的天际线（图B）。
 *
 *
 *
 * 每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的完美矩形。
 *
 *
 *
 * 例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。
 *
 *
 *
 * 输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。关键点是水平线段的左端点。请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 *
 *
 *
 * 例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。
 *
 *
 *
 * 输入描述
 * 第一行：建筑物个数
 *
 * 第二行：第一栋建筑物的尺寸记录
 *
 * 第三行：第二栋建筑物的尺寸记录
 *
 * …
 *
 * 输出描述
 * 第一行：第一个天际线关键点
 *
 * 第二行：第二个关键点
 *
 * …
 *
 *
 * 样例输入
 * 5
 * 2 9 10
 * 3 7 15
 * 5 12 12
 * 15 20 10
 * 19 24 8
 * 样例输出
 * 2 10
 * 3 15
 * 7 12
 * 12 0
 * 15 10
 * 20 8
 * 24 0
 *
 * 提示
 * 任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。
 * 输入列表已经按左 x 坐标 Li  进行升序排列。
 * 输出列表必须按 x 位排序。
 * 输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //建筑物个数
        int n = Integer.parseInt(sc.nextLine());
        int[][] buildings = new int[n][3];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] arr = s.split(" ");
            for (int j = 0; j < arr.length; j++) {
                buildings[i][j] = Integer.parseInt(arr[j]);
            }
        }

        //获取天际线，待实现
        List<List<Integer>> skyline = getSkyline(buildings);

        //输出skyline到标准输出
        for (List<Integer> point : skyline) {
            int size = point.size();
            for (int i = 0; i < size; i++) {
                System.out.print(point.get(i));
                if (i < size-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        //todo 实现算法
        // [2 9 10], [3 7 15], [5 12 12],[12 15 0] [15 20 10], [19 24 8]
        //  2,10      3, 15     5,12      12, 0     15, 10
        List<List<Integer>> ans = new ArrayList<>();
        int[] num = new int[10001];

        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            int n = building[2];
            for(int i = x; i <= y; i++){
                num[i] = Math.max(num[i], n);
            }
        }
//        for (int i = 0; i < 30; i++) {
//            System.out.println(i  + "," + num[i]);
//        }
//        System.out.println();


        if(num[0] > 0){
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.add(num[0]);
            ans.add(temp);
        }
        for (int i = 1; i < num.length - 1; i++) {
            if(num[i] !=  num[ i - 1]){

                List<Integer> temp = new ArrayList<>();
                if(num[i] >  num[ i - 1]){
                    temp.add(i);
                    temp.add(num[i]);
                    ans.add(temp);
                }else {
                    temp.add(i - 1);
                    temp.add(num[i]);
                    ans.add(temp);
                }

            }
        }
        return ans;
    }
}
