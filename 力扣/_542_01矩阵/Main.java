package _542_01矩阵;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 * 链接：https://leetcode-cn.com/problems/01-matrix
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 0, 0}, {0, 1, 0},{1, 1, 1}};
        System.out.println(Arrays.deepToString(updateMatrix(matrix)));
    }
    public static int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length; //行
        int n = matrix[0].length; //列

        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> list = new LinkedList<>();

        //先遍历数组找0
        //如果是0，则他离0的距离就是0，然后加入链表
        //向四周扩散
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    list.addLast(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        //方向 上、下、左、右
        int[][] pos = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        //bfs向四周扩散
        //list里面的的位置，是一件计算好距离0最近距离的的位置
        //从当时位置往上下左右走，下一个位置为上一个位置的的值加一
        //上下左右走完之后，当前位置弹出list，把新的位置加入到list中
        while(!list.isEmpty()){
            int[] cur = list.pollFirst();
            int x = cur[0];
            int y = cur[1];

            //上下左右遍历
            for (int i = 0; i < 4; i++) {
                int nextX = x + pos[i][0];
                int nextY = y + pos[i][1];
                if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]){
                    matrix[nextX][nextY] = matrix[x][y] + 1;
                    visited[nextX][nextY] = true;
                    list.addLast(new int[]{nextX, nextY});
                }
            }
        }
        String s = "223232";
        long sd = 1000000000;

        long ssfd = (long) Math.pow(3, 4);

        return matrix;
    }
}
