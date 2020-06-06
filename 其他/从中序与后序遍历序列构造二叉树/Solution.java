package 从中序与后序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 通过次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 *
 * 20200606
 */
public class Solution {

    // 存中序遍历的索引，<值，inorder的索引>
    Map<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;

        for(int i=0; i<len; i++){
            map.put(inorder[i],i);
        }

        return buildTree(inorder, postorder, 0, len-1, 0, len-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inL, int inR, int poL, int poR){
        if(inL > inR || poL > poR) return null;
        TreeNode node=new TreeNode(postorder[poR]);
        int head=map.get(postorder[poR]);

        node.right=buildTree(inorder,postorder,head+1,inR,poL+(head-inL),poR-1);
        node.left=buildTree(inorder,postorder,inL,head-1,poL,poL+(head-inL)-1);

        return node;

    }

}
