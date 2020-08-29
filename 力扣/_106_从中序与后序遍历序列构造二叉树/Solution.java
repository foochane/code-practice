package _106_从中序与后序遍历序列构造二叉树;


import java.util.HashMap;
import java.util.Map;

class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     }

class Solution {

    // 要重构二叉树必须含有中序遍历，只有前序和后续遍历无法重构二叉树
    // 1 中序遍历存Map<值，数组下表>
    // 2 后续遍历最后一个值为根节点
    // 3 查Map，找该根节点在中序遍历中的位置索引index，可以把树分为左右子树，
    //   左子树的长度为leftEnd = inorder + index,右子树的长度为rightEnd = inorderEnd - index
    // 4 后续遍历去掉最后一个值（根节点），分为左右子树进行计算，
    //   左子树的数据为postorder[postStart, postStart + leftLen -1]
    //   右子树的数据为postorder[postEnd - rightLen, postEnd - 1]
    // 5 进行递归
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer,Integer> inorderMap = new HashMap<>();// 存中序遍历
        int len = inorder.length;

        for(int i = 0; i < len; i++ ){
            inorderMap.put(inorder[i], i);
        }

        return buildTreeHelper(inorderMap, 0, len-1, postorder, 0, len - 1);

    }

    public TreeNode buildTreeHelper(Map<Integer,Integer> inorderMap, int inorderStart, int inorderEnd, int[] postorder, int postStart, int postEnd){
        if(inorderEnd < inorderStart) return null;

        int root = postorder[postEnd];  // 后续遍历的最后一个值为根节点
        int index = inorderMap.get(root); // 根节点在中序遍历的索引
        TreeNode node = new TreeNode(root);
        int leftLen = index - inorderStart; // 左子树值的个数
        int rightLen = inorderEnd - index; // 右子树值的个数
        node.left = buildTreeHelper(inorderMap, inorderStart, index -1, postorder, postStart, postStart + leftLen - 1);
        node.right = buildTreeHelper(inorderMap, index + 1, inorderEnd, postorder, postEnd - rightLen, postEnd - 1);

        return node;
    }

}