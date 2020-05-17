package _19_顺时针打印矩阵;

import java.util.ArrayList;

/**
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a
 *
 * 20200515
 */




public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        int m,n,x;
        m = matrix.length; // 行
        n = matrix[0].length; // 列

        int i = 0,j = 0;
        while (m > 0 && n > 0){

            // 如果只有一行或者一列
            if(m == 1 | n == 1) {
                for (int a = 0; a < m; a++) {
                    for (int b = 0; b < n; b++) {
                        list.add(matrix[i + a][j + b]);
                    }
                }
                break;
            }
            // 上
            for (x = 0; x <= n-1; x++) {
                list.add(matrix[i][j+x]);
            }
            j = j+x-1;

            // 右
            for (x = 1; x <= m-1; x++){
                list.add(matrix[i+x][j]);
            }
            i = i+x-1;

            // 下
            for(x= 1; x <= n-1; x++){
                list.add(matrix[i][j-x]);
            }
            j = j-x+1;

            // 左
            for (x = 1; x <= m -2; x++){
                list.add(matrix[i-x][j]);
            }
            i = i -x+1;
            j++;
            n = n-2;
            m = m-2;
        }
        return list;
    }
}