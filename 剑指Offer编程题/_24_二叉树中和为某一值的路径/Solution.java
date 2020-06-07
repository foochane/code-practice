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
import java.util.Stack;

public class Solution {
    private ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
    private Stack<Integer> path = new Stack();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
//      递归终止条件
        if(root == null)    return paths;
        path.push(root.val);
        target -= root.val;
//      当前路径遍历结束时若节点值之和等于Target，则将该路径加入正确路径队列；
        if(target == 0 && root.left == null && root.right == null)
            paths.add(new ArrayList<Integer>(path));
        FindPath(root.left, target);
        FindPath(root.right, target);
//      当前节点判断结束，回溯；
        path.pop();
        return paths;
    }
}