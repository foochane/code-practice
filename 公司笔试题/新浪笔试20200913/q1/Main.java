package 新浪笔试20200913.q1;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x ){
        val = x;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        //int[] nums = {1,2,3,4,5,6};
        TreeNode root = createTree(nums, 1);

        TreeNode myRoot = delTree(root);

        ArrayList<Integer> list = printTree(myRoot);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if(i != list.size() - 1){
                System.out.print(",");
            }
        }
    }

    private  static  ArrayList<Integer> printTree(TreeNode root){
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root != null){
            nodeList.add(root);
        }
        while (!nodeList.isEmpty()){
            list.add(nodeList.getFirst().val);
            if(nodeList.getFirst().left != null){
                nodeList.addLast(nodeList.getFirst().left);
            }
            if(nodeList.getFirst().right != null){
                nodeList.addLast(nodeList.getFirst().right);
            }

            nodeList.removeFirst();
        }

        return list;

    }

    private static TreeNode delTree(TreeNode root){
        if(root == null || root.left == null) return  root;
        TreeNode temp = delTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return  temp;
    }

    //构造二叉树
    private static TreeNode createTree(int[] nums, int i) {
        int n = nums.length;
        if(i > n) return null;
        Integer val = nums[i - 1];
        if(val == null){
            return null;
        }
        TreeNode node = new TreeNode(val);
        node.left = createTree(nums, i * 2);
        node.right = createTree(nums, i * 2 + 1);
        return node;
    }
}
