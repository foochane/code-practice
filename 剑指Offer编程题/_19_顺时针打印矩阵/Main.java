package _19_顺时针打印矩阵;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /*
4 4
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(); //行
        int n = scanner.nextInt(); //列
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        Solution s = new Solution();
        ArrayList<Integer> list = s.printMatrix(matrix);
        System.out.println(list.toString());
    }
}
