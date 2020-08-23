package 滴滴笔试题20200821.question2;

import java.util.Scanner;

/**
 * 斐波那契蛇
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小明昨晚做了一个梦。在梦里，很多很多斐波那契数连成了一条蛇。突然，最大的那个数变成了蛇头，把小明一口给吞到肚子里去了。
 *
 * 小明被吓醒了，他赶紧拿笔在纸上面画了一条斐波那契蛇。
 *
 *
 *
 * 这是一个蛇形迂回的斐波那契数列，它是一个n*n的矩阵，在上面的矩阵中n=3。第1行第1列是最大值，然后按照顺时针的次序数字逐渐变小。
 *
 * 下面是n=4时的情况：
 *
 *
 *
 * 小明希望你能够编写一个程序，输入一个正整数n，然后逐行逐列输出斐波那契蛇形矩阵中的元素。
 *
 *
 *
 * 输入描述
 * 单组输入，输入数据占一行，包含一个正整数n，表示斐波那契蛇形矩阵的大小。(n<10)
 *
 * 输出描述
 * 输出数据占一行，逐行逐列（从第1行开始到第n行，每一行从第1列开始到第n列）输出斐波那契蛇形矩阵中的元素，每两个数字之间用一个空格隔开。
 *
 *
 * 样例输入
 * 3
 * 样例输出
 * 34 21 13
 * 1 1 8
 * 2 3 5
 *
 * 规则
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[ n * n + 1];
        fib(n * n, nums);
        nums[1] = 1;

        int[] arr = new int[n * n];
        int x = nums.length -1;
        int y = 0;

        while (x >= 1){
            arr[y] = nums[x];
            x--;
            y++;
        }

        //System.out.println(Arrays.toString(arr));
        int[][] matrix = new int[n][n];

        int i = 0, j = 0;
        int index = 0;
        while (i < n && i >= 0 && j < n && j >= 0 && matrix[i][j] == 0){
            while (j < n && matrix[i][j] == 0){ // 右边
                matrix[i][j] = arr[index];
                j++;
                index ++;
            }
            j--;
            i++;

            while (i < n && matrix[i][j] == 0){ // 下
                matrix[i][j] = arr[index];
                i++;
                index ++;
            }
            i--;
            j--;

            while (j >= 0 && matrix[i][j] == 0){ // 左边
                matrix[i][j] = arr[index];
                j--;
                index ++;
            }
            j++;
            i--;

            while (i >= 0 && matrix[i][j] == 0){ // 左边
                matrix[i][j] = arr[index];
                i--;
                index ++;
            }
            j++;
            i++;
        }

        //System.out.println(Arrays.deepToString(matrix));
        for (int m = 0; m < matrix.length; m++) {
            for (int k = 0; k < matrix[0].length; k++) {
                System.out.print(matrix[m][k]);
                if(k != n - 1) System.out.print(" ");
            }
            System.out.println();
        }

    }

    private static int fib(int N, int[] nums) {
        if(N == 0) return 0;
        if(N == 1) return 1;

        if(nums[N] == 0) nums[N] = fib(N - 1, nums) + fib(N - 2, nums);
        return nums[N];
    }


}
