package 中兴笔试题20200824.question2;

/**
 *
 * 一个字符串只包含0-1和A-Z,表示一个k进制字符串， l <= k <= r
 * X_k表示字符串为k进制是的10进制数值
 * 输入
 * 2
 * 101 2 3
 * 4B 12 13
 *
 * 输出：
 * 1
 * 0
 *
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] ans = new int[T];
        for (int i = 0; i < T; i++) {
            ans[i] = 0;
            String str = sc.next();
            long l = sc.nextLong();
            long r = sc.nextLong();
            long sum = 0;
            for(long k = l; k <= r; k++){

                for (int j = str.length() - 1; j >= 0; j--) {
                    int num = getNum(str.charAt(j));
                    if(num  % 2 == 1 && k % 2 == 0) ans[i] = 1;
                }
            }

        }

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
            if(i != ans.length -1){
                System.out.println();
            }
        }
    }

    private static int getNum(char c) {
        if(c >= '0' && c <= '9'){
            return c - '0';
        }else {
            return 10 + c - 'A';
        }
    }


}
