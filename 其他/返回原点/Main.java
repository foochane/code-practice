package 返回原点;

import java.util.LinkedList;

/**
 * 返回原点
 * 矩阵0表示无障碍物，1表示有障碍物
 * 遇到障碍物生命值减1，
 * 找出能回到起点的步数，如果没有放回-1
 *
 */
class Main {
    int[] arr = new int[10];
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0}};
        int x = 3, y = 3;  //起点
        int h = 2; //生命值，每遇到一个1生命值减一，生命值为0则不能移动
        System.out.println(findPath(matrix, x, y, h));

    }

    private static int findPath(int[][] matrix, int x, int y, int h) {
        int m = matrix.length; //行
        int n = matrix[0].length; //列
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> list = new LinkedList<>();
        list.addLast(new int[]{x, y, h, 0}); //行，列， 生命值， 步数
        visited[x][y] = true; //起点设为已访问
        int[][] position = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 方向
        while (!list.isEmpty()){

            int size = list.size();
            for (int i = 0; i < size; i++) {
                int[] cur = list.pollFirst();
                //如果生命值小于等于0
                if(cur == null || cur[2] <= 0) continue;

                //上下左右遍历
                for (int j = 0; j < 4; j++) {
                    int X = cur[0] + position[j][0];
                    int Y = cur[1] + position[j][1];
                    if(X >= 0 && X < m && Y >= 0 && Y < n && !visited[X][Y]){
                        int[] next = {X, Y, cur[2] - matrix[X][Y], cur[3] + 1};

                        //如果回到起点
                        if(X == 0 && Y == 0) return next[3];

                        //如果生命值大于0
                        if(next[2] > 0) list.addLast(next);
                    }
                }
            }
        }

        return -1;
    }


}
