package 美团笔试20200829.question1;
/**
 * 小团的神秘暗号
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小团深谙保密工作的重要性，因此在某些明文的传输中会使用一种加密策略，小团如果需要传输一个字符串S，
 * 则他会为这个字符串添加一个头部字符串和一个尾部字符串。头部字符串满足至少包含一个“MT”子序列，且以T结尾。
 * 尾部字符串需要满足至少包含一个“MT”子序列，且以M开头。例如AAAMT和MAAAT都是一个合法的头部字符串，而MTAAA就不是合法的头部字符串。
 * 很显然这样的头尾字符串并不一定是唯一的，因此我们还有一个约束，就是S是满足头尾字符串合法的情况下的最长的字符串。
 *
 * 很显然这样的加密策略是支持解码的，给出你一个加密后的字符串，请你找出中间被加密的字符串S。
 *
 *
 *
 * 输入描述
 * 输入第一行是一个正整数n，表示加密后的字符串总长度。(1<=n<=100000)
 *
 * 输入第二行是一个长度为n的仅由大写字母组成的字符串T。
 *
 * 输出描述
 * 输出仅包含一个字符串S。
 *
 *
 *
 *
 * 样例输入
 * 10
 * MMATSATMMT
 * 样例输出
 * SATM
 */

//全a
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int x = 0, y = 0;
        boolean M = false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'M'){
                M = true;
                continue;
            }
            if(M && c == 'T'){
                x = i + 1;
                break;
            }
        }
        boolean T = false;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(c == 'T'){
                T = true;
                continue;
            }
            if(T && c == 'M'){
                y = i;
                break;
            }
        }
        System.out.println(s.substring(x, y));
    }
}
