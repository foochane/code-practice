package 对称二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 *
 *  20200530
 */
public class Solution {

    // 方法一
    // 没有通过： [2,3,3,4,5,5,4,null,null,8,9,null,null,9,8]
    public boolean isSymmetric(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        int size;
        List<Integer> list = new ArrayList<>();

        if(root == null) return true;
        queue.add(root);
        while(!queue.isEmpty()){
            size = queue.size();
            while(size > 0){
                TreeNode tree = queue.remove();
                if(tree != null){
                    if((tree.left != null) | (tree.right != null)){
                        queue.add(tree.left);
                        queue.add(tree.right);
                    }
                    list.add(tree.val);
                }else{
                    list.add(-1);
                }

                size--;
            }

            for(int i=0; i < list.size()/2; i++){
                if(list.get(i) != list.get(list.size() - i-1)) return false;
            }
            list.clear();
        }

        return true;
    }

    // 方法二
    public boolean isSymmetric2(TreeNode root) {
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
}
