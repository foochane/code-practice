package 二叉树的四种遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的4中遍历
 * https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/7/
 */

class Solution {


    // 前序遍历 根、左、右
    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderTraversalHelper(list,root);
        return list;
    }
    void preOrderTraversalHelper(List<Integer> list, TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.val);
        preOrderTraversalHelper(list,root.left);
        preOrderTraversalHelper(list,root.right);
    }


    // 中序遍历 左、根、右
    public List<Integer> inOrderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        inOrderTraversalHelper(list,root);
        return list;
    }
    public void inOrderTraversalHelper(List<Integer> list, TreeNode root) {
        if(root == null){
            return;
        }
        inOrderTraversalHelper(list, root.left) ;
        list.add(root.val);
        inOrderTraversalHelper(list, root.right);
    }


    // 后序遍历 左、右、根
    public List<Integer> postOrderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        postOrderTraversalHelper(list,root);
        return list;
    }
    public void postOrderTraversalHelper(List<Integer> list, TreeNode root) {
        if(root == null){
            return;
        }
        postOrderTraversalHelper(list, root.left) ;
        postOrderTraversalHelper(list, root.right);
        list.add(root.val);
    }


    // 层序遍历
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {

        LinkedList<TreeNode> nodeList  = new LinkedList<TreeNode>();
        ArrayList<List<Integer>> list = new ArrayList<>();
        int size;

        if(root != null) nodeList.add(root);

        while(nodeList.size()>0){
            size = nodeList.size();
            ArrayList<Integer> temp = new ArrayList<>();
            while(size>0){

                // 遍历每一层
                temp.add(nodeList.getFirst().val);
                if(nodeList.getFirst().left != null){
                    nodeList.add(nodeList.getFirst().left);
                }
                if(nodeList.getFirst().right != null){
                    nodeList.add(nodeList.getFirst().right);
                }
                nodeList.removeFirst();
                size--;
            }
            list.add(temp);
        }

        return list;
    }



}