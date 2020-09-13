package _360笔试20200912.q1; /**
 * 企业管理
 * 时间限制： 3000MS
 * 内存限制： 786432KB
 * 题目描述：
 * 企业管理是一个难题，特别是对于上下班打卡系统来说。小A所在的公司的打卡器坏了，所以打卡机只记录了今天一段连续的时间内所有的打卡记录。 小A是企业的老板，他从来都是第一个上班，最晚下班的人。今天他恰好忘记了自己的号码。现在，小A只有一张按时间顺序但记录不全的上下班记录表。他希望使用这一张表，看出自己的工号是几号。 请你帮助小A计算自己的工号，如果有多组解，从小到大按顺序输出。
 *
 * 请注意，公司管理规定上班下班必须有打卡记录，但是有可能有部分员工今天请假而没有打卡记录。
 *
 *
 *
 * 输入描述
 * 输入第一行包含两个整数n,m，n是小A所在公司的人数，m是今天打卡机记录下来的打卡数量。 接下来m行，每行两个整数ai,bi，ai表示这一次打卡操作人的工号，若bi为1代表上班打卡，为0代表下班打卡。
 *
 * 输出描述
 * 输出包含一行，代表小A可能的工号。如果有多解，从小到大全部输出。数据保证至少有一个解。
 *
 *
 * 样例输入
 * 3 2
 * 1 1
 * 2 0
 * 样例输出
 * 3
 *
 * 提示
 * 输入样例2：
 * 5 2
 * 1 1
 * 1 0
 * 输出样例2：
 * 1 2 3 4 5
 * 范围：n<=100000，m<=2*n
 * 样例解释：
 * 样例只有可能是一种情况：3号上班，2号上班，1号上班，2号下班，1号下班，3号下班。所以小A一定是3号。
 * 样例二解释：1可能是小A，因为2345号员工可能都请假了。
 */

import java.util.LinkedList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 人数
        int m = sc.nextInt();
        int[] count = new int[n + 1];
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        LinkedList<int[]> temp = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            ans.add(i);
        }
        for (int i = 0; i < m; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            count[a] += 1;
            list.add(a);
            temp.add(new int[]{a, b});
        }

        for (int[] ints : temp) {
            if(count[ints[0]] != 2){
                if(ints[1] == 1){
                    list.addLast(ints[0]);
                }else {
                    list.addFirst(ints[0]);
                }
                count[ints[0]] += 1;
            }
        }

        //System.out.println(list.toString());
        //System.out.println(ans.toString());
        if(list.size() > 2) {
            for (int i = 0; i < list.size() / 2; i++) {
                ans.remove((Object)list.get(i));
            }
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));
            if(i != ans.size() - 1){
                System.out.print(" ");
            }
        }
    }
}
