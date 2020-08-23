package 滴滴笔试题20200821.question1;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 熟悉的A+B
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * A+B问题又来了。
 *
 * 设a，b，c是0到9之间的整数（其中a，b，c互不相同），其中abc和acc是两个不同的三位数，现给定一正整数n，问有多少对abc和acc能满足abc+acc=n（a≠0）？
 *
 *
 *
 * 输入描述
 * 一个正整数n（100<n<2000）。
 *
 * 输出描述
 * 第一行输出有多少对满足要求的数字。
 *
 * 接下来每一行输出一对abc和acc，以空格分隔。如果没有一对abc和acc的话，则直接输出0即可。如果有多对，请按照abc升序的次序输出。
 *
 *
 * 样例输入
 * 1068
 * 样例输出
 * 1
 * 524 544
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> list = new ArrayList<>();
        for(int a = 0; a <= 9; a++){
            for(int b = 0; b <= 9; b++){
                for(int c = 0; c <= 9; c++){
                    String num1 = "";
                    String num2 = "";
                    if(a == 0 && b==0){
                        num1 = num1 + c;
                    } else if(a == 0){
                        num1 = num1 + b + c;
                    }else {
                        num1 = num1 + a + b + c;
                    }

                    if(a == 0 && c!= 0){
                        num2 = num2 +  c + c;
                    }else if(a == 0 && c == 0){
                        num2 = num2 + 0;
                    }else {
                        num2 = num2 + a + c + c;
                    }
                    int first = Integer.parseInt(num1);
                    int second = n - first;
                    if(Integer.parseInt(num2) == second){
                        list.add(new int[]{first, second});
                    }
                }
            }
        }


        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        System.out.println(list.size());
        for (int[] ints : list) {
            System.out.println(ints[0] + " " + ints[1]);
        }

    }



}
