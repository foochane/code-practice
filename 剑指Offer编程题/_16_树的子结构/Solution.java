package _16_树的子结构;

/**
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88
 *
 * 20200115
 */


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solution {

    //判断root2是否是root1的子结构
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //我们约定空树不是任意一个树的子结构
        if( root2 == null || root1 == null){
            return false;
        }

        if(root1.val == root2.val){
            if(isSubStructure(root1,root2)){
                return true;
            }
        }
        return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);

    }

    private boolean isSubStructure(TreeNode root1, TreeNode root2) {
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }
        return root1.val== root2.val && isSubStructure(root1.left,root2.left) && isSubStructure(root1.right,root2.right);
    }
}