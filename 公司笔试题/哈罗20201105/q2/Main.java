package 哈罗20201105.q2;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回最大区域面积
     * @param matrix int整型二维数组 矩形
     * @return int整型
     */

    /*
    [[0,0,1,0,0,0,0,1,0,0,0,0,0],  [0,0,0,0,0,0,0,1,1,1,0,0,0],  [0,1,1,0,1,0,0,0,0,0,0,0,0],  [0,1,0,0,1,1,0,0,1,0,1,0,0],  [0,1,0,0,1,1,0,0,1,1,1,0,0],  [0,0,0,0,0,0,0,0,0,0,1,0,0],  [0,0,0,0,0,0,0,1,1,1,0,0,0],  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     */
    public int maxArea (int[][] matrix) {
        // write code here
        int ans = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] > 0){
                    ans = Math.max(ans , recur(matrix, i,j));
                }
            }
        }
        return  ans;
    }

    private int recur(int[][] matrix, int i, int j) {
        if(i <0 || j<0|| i>= matrix.length || j > matrix[0].length) return 0;
        matrix[i][j] = 0;
        int a = 1;
        a += recur(matrix, i + 1, j);
        a += recur(matrix, i - 1, j);
        a += recur(matrix, i , j+ 1);
        a += recur(matrix, i, j - 1);
        return a;
    }
}
