package 百度20200903.question3;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static  int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //台阶数
        int m = sc.nextInt(); //步数
        recur(m, n, new LinkedList<Integer>(), 0);
        System.out.println(ans);

    }

    private static void recur(int m, int n, LinkedList<Integer> list, int sum) {
        if(sum == n){
            for (int i = 0; i < list.size() - 2; i++) {
                if(list.get(i).equals(list.get(i + 1)) || list.get(i).equals(list.get(i + 2)))
                    return;
                if(list.get(list.size() - 2).equals(list.getLast())) return;
            }
            //System.out.println(list);
            ans++;
            return;

        }
        if(sum > n){
            return;
        }

        for (int i = 1; i <= m; i++) {

            list.addLast(i);
            recur(m, n, list, sum + i);
            list.removeLast();
        }

    }
}
