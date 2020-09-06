package 华为笔试20200906.q3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        double ans = 0;
        double[][] nums = new double[m][n * 3];
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n * 3; j++) {
                count ++;
                nums[i][j] = sc.nextDouble();
                if(count % 3 != 0)
                    ans += nums[i][j];
            }
        }

        System.out.println(ans);
    }
}


/*
2 2
1.0 0.0 0.0  0.5 0.0 0.5
0.0 0.5 0.5  0.5 0.5 0.0
 */