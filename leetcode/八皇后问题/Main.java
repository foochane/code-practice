package 八皇后问题;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.12. 八皇后
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 *
 * 注意：本题相对原题做了扩展
 *
 * 示例:
 *
 *  输入：4
 *  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *  解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * https://leetcode-cn.com/problems/eight-queens-lcci/
 *
 */
public class Main {


    public static void main(String[] args) {
        List<List<String>> result = solveNQueens(4);
        System.out.println(result);
    }

    public static List<List<String>> solveNQueens(int n) {

        int arr[] = new int[n];
        List<List<String>> result = new ArrayList<>();
        check(0, n, arr, result);

        return result;
    }

    public static void check(int index, int n, int[] arr, List<List<String>> result){
        if(index == n){
            List<String> temp = new ArrayList<>();
            for(int val : arr){
                StringBuffer sb = new StringBuffer();
                for(int i = 0; i < n; i++){
                    if(i == val){
                        sb.append("Q");
                    }else {
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }

        for(int i = 0; i < n; i++){

            //把i方法arr中的第index个位置处
            arr[index] = i;

            //判断是否有冲突，没有冲突就进行下一行
            if(judge(index, arr)){
                check(index+1, n, arr, result);
            }
        }

    }

    private static boolean judge(int index, int[] arr) {

        for(int i = 0; i < index; i++){
            if((arr[index] == arr[i]) || (Math.abs(arr[index] - arr[i]) == Math.abs(index - i)))
                return false;
        }
        return true;
    }
}
