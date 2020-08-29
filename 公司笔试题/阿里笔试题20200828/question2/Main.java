package 阿里笔试题20200828.question2;

/**
 *
 * 输入两个数字m 和 n
 * 把 m 里的单个数字进行交换，组成新的数字（不能以0开头）
 * 计算有多少个数字可以被n整除
 * 示例
 * 输入：
 * 322 2
 * 输出
 * 2
 * 说明： 322 、232可以被2整除
 *
 *
 * 输入：
 * 97284 4
 * 输出：
 * 366
 */

import java.util.*;

// a了百分之20，后面加了个减枝，没来得及提交
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[] chars = (m  + "").toCharArray();

        boolean[] visited = new boolean[chars.length];
        Set<Integer> set = new HashSet<>();
        recur(chars, 0, visited, "", set, n);
        int count = 0;
        for (int num : set) {
            if(num % n == 0) count++;
        }
        System.out.println(count);
    }

    private static void recur(char[] chars, int p, boolean[] visited, String cur, Set<Integer> set, int n) {
        //超时了，后面加了个减枝
        if(cur.length() > 0 && Integer.parseInt(cur) > n && Integer.parseInt(cur) % n != 0) {
            return;
        }

        if(p == chars.length){
            if(cur.charAt(0) != 0){
                int m = Integer.parseInt(cur);
                set.add(m);
            }
            return;
        }
        for(int i = 0; i < chars.length; i++){

            if(!visited[i]){
                visited[i] = true;
                recur(chars, p + 1, visited, chars[i] + cur, set, n);
                visited[i] = false;
            }
        }
    }


}
