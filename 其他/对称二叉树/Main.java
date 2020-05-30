package 对称二叉树;

public class Main {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = null;
        node2.right = node6;
        node3.left = null;
        node3.right = node7;

        Solution s = new Solution();
        System.out.println(s.isSymmetric(node1));


    }
}
