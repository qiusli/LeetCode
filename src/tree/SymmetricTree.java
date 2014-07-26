package tree;

import tree.node.TreeNode;

/**
 * Created by liqiushi on 7/24/14.
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        System.out.println(isSymmetric(root1));

        TreeNode root2 = new TreeNode(1);
        TreeNode node2_1 = new TreeNode(2);
        TreeNode node2_2 = new TreeNode(2);

        root2.left = node2_1;
        root2.right = node2_2;
        System.out.println(isSymmetric(root2));

        TreeNode root3 = new TreeNode(1);
        TreeNode node3_1 = new TreeNode(2);
        TreeNode node3_2 = new TreeNode(3);
        TreeNode node3_3 = new TreeNode(3);
        TreeNode node3_4 = new TreeNode(2);

        root3.left = node3_1;
        root3.right = node3_2;
        node3_1.left = node3_3;
        node3_2.left = node3_4;
        System.out.println(isSymmetric(root3));
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;

        return check(root.left, root.right);
    }

    private static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null && q != null)
            return false;

        if (p != null && q == null)
            return false;

        if (p.val != q.val)
            return false;

        return check(p.left, q.right) && check(p.right, q.left);
    }
}
