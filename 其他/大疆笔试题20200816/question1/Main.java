package 大疆笔试题20200816.question1;


import java.util.*;

/**
 * 题目描述：
 * 最近DJI发布了一款Robomaster S1机器人，小伙伴们都沉迷其中不能自拔。小J为了能够在竞速比赛中迅速获胜，他决定利用开发的优势，在里面植入一套最优化的寻路算法。
 *
 * 比赛规则如下: 在比赛场地内预先设置N个路标，路标编号从0到N-1，S1只能沿直线在两个有连接的路标之间移动（部分路标之间是没有连接的）
 *
 * 比赛场地内的S1机器人从编号为0的路标出发，然后裁判给出随机一个路标（从0到N-1号路标中随机挑选一个）作为终点路标，
 *
 * 要求S1机器人以尽可能快的速度从0号路标达到终点路标，总路程用时最短者获胜。
 *
 * 裁判会确保从0号路标和随机挑选的终点路标之间肯定存在至少一条路径。 小J在比赛开始前就已经得知了路标的数量 、通道的数量（每两个可以直接连接的路标点为一个通道）以及小车在每个通道上移动需要的时间。他需要编写一套算法，以确保能够快速找到最短路径，并输出小车在该路径移动所需要的时间，你能帮他实现这套算法吗?
 *
 *
 *
 * 输入描述
 * 第一行输入两个个正整数 N和 P，其中N表示路标的数量， P表示通道的数量。 (1 < N <= 200,  0 <= P <= N * (N - 1) / 2 ）
 *
 * 接下来的P行，每行输入三个正整数 A, B, T，A表示起点路标的编号，B表示终点路标的编号，T表示路标A到路标B需要时间T。 (0 <= A, B <= N-1, 1 <= T <= 100)
 *
 * 最后一行输入一个正整数 X，表示裁判给出的终点路标编号 (0 =< X <= N)
 *
 * 输出描述
 * 输出一个正整数，表示小车从0号路标到X号路标之间移动的最短用时
 *
 *
 * 样例输入
 * 4 5
 * 0 1 15
 * 1 2 15
 * 0 3 50
 * 1 3 30
 * 2 3 10
 * 3
 *
 * 样例输出
 * 40
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //路标数
        int P = sc.nextInt(); //道路数
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < P; i++) {

            int A = sc.nextInt();
            if(!map.containsKey(A)){
                map.put(A, new ArrayList<>());
            }
            map.get(A).add(new int[]{sc.nextInt(),sc.nextInt()});

        }

        int B = sc.nextInt(); //终点
        LinkedList<int[]> list = new LinkedList<>();
        list.addLast(new int[]{0, 0});

        int ans = Integer.MAX_VALUE;
        while (!list.isEmpty()){
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int[] temp = list.getFirst();
                if(temp != null && temp[0] == B) ans = Math.min(ans, temp[1]);
                List<int[]> paths = map.get(temp[0]);
                if(paths != null){
                    for (int[] p : paths) {
                        if(ans != Integer.MAX_VALUE && temp[1] + p[1] > ans) continue;
                        list.addLast(new int[]{p[0],temp[1] + p[1]});
                    }
                }
                list.removeFirst();
            }
        }

        if(N == 0) System.out.println(0);
        System.out.println(ans);

    }



}
