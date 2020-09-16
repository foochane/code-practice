package 广联达.q3;


/**
 * AOE
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 在一个2D横版游戏中，所有的怪物都是在X轴上的，每个怪物有两个属性X和HP，分别代表怪物的位置和生命值。
 *
 * 玩家控制的角色有一个AOE（范围攻击）技能，玩家每次释放技能可以选择一个位置x，技能会对[x-y,x+y]范围内的所有怪物造成1点伤害，请问，玩家最少需要使用多少次技能，才能杀死所有怪物，怪物血量清0即视为被杀死。
 *
 *
 *
 * 输入描述
 * 输入第一行包含一个两个正整数n和y，分别表示怪物的数量和技能的范围。（1<=n<=100000）
 *
 * 接下来有n行，每行有两个正整数x和hp分别表示一只怪物的位置和血量。(1<=x,hp<=10^9)
 *
 * 输出描述
 * 输出仅包含一个整数，表示最少使用的技能次数。
 *
 *
 * 样例输入
 * 3 5
 * 1 10
 * 10 5
 * 22 3
 * 样例输出
 * 13
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();// 怪物数
        int y = sc.nextInt(); //攻击范围
        int[] num = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            map.put(num[i], sc.nextInt());
        }
        Arrays.sort(num);
        LinkedList<Integer> list = new LinkedList<>();
        for (int temp : num) {
            list.add(map.get(temp));
        }

        int ans = 0;
        while(!list.isEmpty()){
            int  min = list.get(0);
            int s = min + 2 * y;
            int maxHp = 0;
            while (list.size() > 0 && list.get(0) <= s){
                int temp = list.removeFirst();
                maxHp = Math.max(maxHp, temp);
            }

            ans += maxHp;
        }
        System.out.println(ans);

    }
}
