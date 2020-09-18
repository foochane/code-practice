package 华为面试笔试题20200918.q2;

import java.util.Arrays;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 *
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 *
 * 示例 2:
 * 输入:
 * 0 0 0
 * 0 1 0
 * 1 1 1
 *
 *
 * 输出:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 *
 * 注意:
 * 	给定矩阵的元素个数不超过 10000。
 * 	给定矩阵中至少有一个元素是 0。
 * 	矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 */
public class Main {

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}};
        //int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(updateMatrix(matrix)));;
    }
    public static int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return matrix;
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] != 0){
                    recur(matrix, i, j);
                }
            }
        }

        return matrix;
    }

    public static void recur(int[][] matrix, int i, int j){
        //方向
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1 , -1, 0, 0};

        int minValue = Integer.MAX_VALUE;

        for(int x = 0; x < 4; x++){
            int X = dx[x] + i;
            int Y = dy[x] + j;
            if(X>=0 && X < matrix.length && Y >= 0 && Y < matrix[0].length){
                minValue = Math.min(minValue, matrix[X][Y] + 1);
            }
        }

        if(minValue != matrix[i][j]){
            matrix[i][j] = minValue;
            for(int x = 0; x < 4; x++){
                int X = dx[x] + i;
                int Y = dy[x] + j;
                if(X >=0 && X < matrix.length && Y >= 0 && Y < matrix[0].length){
                    recur(matrix, X, Y);
                }
            }

        }
    }
}
