package 二叉树的四种遍历;


public class Main {
    public static void main(String[] args) {
        // [1,2,3,null,6,7,null]
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = null;
        node2.right = node6;
        node3.left = node7;
        node3.right = null;

        Solution s = new Solution();
        System.out.println(s.preOrderTraversal(node1).toString());


    }
}
