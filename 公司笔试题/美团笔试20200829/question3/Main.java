package 美团笔试20200829.question3;
/**
 * 小团无路可逃
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小团惹小美生气了，小美要去找小团“讲道理”。小团望风而逃，他们住的地方可以抽象成一棵有n个结点的树，
 * 小美位于x位置，小团位于y位置。小团和小美每个单位时间内都可以选择不动或者向相邻的位置转移，假设小美足够聪明，
 * 很显然最终小团会无路可逃，只能延缓一下被“讲道理”的时间，请问最多经过多少个单位时间后，小团会被追上。
 *
 *
 *
 * 输入描述
 * 输入第一行包含三个整数n，x，y，分别表示树上的结点数量，小美所在的位置和小团所在的位置。(1<=n<=50000)
 *
 * 接下来有n-1行，每行两个整数u，v，表示u号位置和v号位置之间有一条边，即u号位置和v号位置彼此相邻。
 *
 * 输出描述
 * 输出仅包含一个整数，表示小美追上小团所需的时间。
 *
 *
 * 样例输入
 * 5 1 2
 * 2 1
 * 3 1
 * 4 2
 * 5 3
 * 样例输出
 * 2
 */

//a了百分之18
//问题 x 后面的节点不用访问 y 不用访问
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt(); //小美
        int y = sc.nextInt(); //小团
        boolean[] visited = new boolean[50001];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(map.get(a) == null){
                map.put(a, new ArrayList<Integer>());
            }
            map.get(a).add(b);

            if(map.get(b) == null){
                map.put(b, new ArrayList<Integer>());
            }
            map.get(b).add(a);
        }

        if(x == y) {
            System.out.println(0);
            return;
        }

        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(y);
        int count1 = 1 ; // y 往 x的距离
        int count2 = -1 ; //y 远离x的长距离
        boolean meet = false;
        while (!list.isEmpty()){
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int cur = list.pollFirst();
                visited[cur] = true;
                List<Integer> path = map.get(cur);
                if(path != null){
                    for (int next : path) {

                        if(next != x && !visited[next]){
                            list.addLast(next);
                        }
                        if (next == x){
                            meet = true;
                        }
                    }
                }
            }
            if (!meet) {
                count1++;
            }
            count2++;
        }
        //System.out.println(count1);
        //System.out.println(count2);
        System.out.println(count2 + count1);

    }
}
