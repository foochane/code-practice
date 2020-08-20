package 大疆笔试题20200816.question3;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小C平时最喜欢玩数字游戏，最近他碰到一道有趣的数字题，他和他的好朋友打赌，一定能在10分钟内解出这道题，成功完成，小C就可以得到好朋友送他的Switch游戏机啦，你能帮助小C赢得奖品吗？
 *
 * 题目是这样的：给定一个非负的、字符串形式的整形数字，例如“12353789”，字符串的长度也就是整形数字的位数不超过10000位，并且字符串不会以0开头，小C需要挑选出其中K个数字（K小于字符串的长度）并删掉他们，使得剩余字符组成新的整数是最小的。
 *
 *
 *
 * 输入描述
 * 第一行输入一串纯数字形式的字符串，组成一个正整数
 *
 * 第二行输入一个正整数K (K < 字符串的长度)
 *
 * 输出描述
 * 输出一个数字（字符串格式）
 *
 *
 * 样例输入
 * 71245323308
 * 4
 * 样例输出
 * 1223308
 *
 * 提示
 * 输入样例二:
 * 1683212
 * 3
 * 输出样例二:
 * 1212
 * 输入样例三：
 * 100
 * 1
 * 输出样例三:
 * 0
 *
 *
 * leetcode 402
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int K = sc.nextInt();

        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.addLast(str.charAt(i));
        }

        boolean flag = true;
        while(flag && K > 0){
            int size = list.size();
            for (int i = 0; i < size - 1; i++) {
                if(list.get(i) > list.get(i + 1)){
                    list.remove(i);
                    K--;
                    break;
                }
            }

            if(size == list.size()) flag = false;
        }

        for (int i = 0; i < K; i++) {
            list.removeLast();
        }

        for (Character c : list) {
            System.out.print(c);
        }
        System.out.println();

    }

}
