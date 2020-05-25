package _22_从上往下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701
 *
 * 20200524
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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> nodeList = new LinkedList();

        ArrayList<Integer> list = new ArrayList();

        if(root != null){
            nodeList.add(root);
        }

        while (!nodeList.isEmpty()){
            list.add(nodeList.getFirst().val);
            if (nodeList.getFirst().left != null) {
                nodeList.addLast(nodeList.getFirst().left);
            }
            if (nodeList.getFirst().right != null) {
                nodeList.addLast(nodeList.getFirst().right);
            }
            nodeList.removeFirst();
        }

        return list;

    }
}