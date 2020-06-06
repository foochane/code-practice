package _24_二叉树中和为某一值的路径;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 * https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca
 *
 * 20200606
 */

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum -=root.val;
        if(root.left == null && root.right == null) return sum == 0;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);  // 这的 || 运算很关键

    }
}