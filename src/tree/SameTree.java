package tree;

import tree.node.TreeNode;

/**
 * Created by liqiushi on 7/23/14.
 */
public class SameTree {
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

        TreeNode root2 = new TreeNode(5);
        TreeNode node2_1 = new TreeNode(2);
        TreeNode node2_2 = new TreeNode(8);
        TreeNode node2_3 = new TreeNode(1);
        TreeNode node2_4 = new TreeNode(3);
        TreeNode node2_5 = new TreeNode(6);
        root2.left = node2_1;
        root2.right = node2_2;
        node2_1.left = node2_3;
        node2_1.right = node2_4;
        node2_2.left = node2_5;

        System.out.println(isSameTree(root1, root2));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        return check(p, q);
    }

    private static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p != null && q != null) {
            if (p.val != q.val)
                return false;
        } else {
            return false;
        }

        return check(p.left, q.left) && check(p.right, q.right);
    }
}
