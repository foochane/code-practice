package 路径总和;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 *
 * 20200531
 */
public class Solution {

    // 使用递归，遍历整棵树，每遍历一个节点sum-1，如果遍历到叶子节点并且sum==0，则放回true；
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum -=root.val;
        if(root.left == null && root.right == null) return sum == 0;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);  // 这的 || 运算很关键

    }
}
