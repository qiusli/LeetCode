package tree;

import tree.node.TreeNode;

/**
 * Created by liqiushi on 8/2/14.
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node3.right = node4;

        System.out.println(minDepth(root));
    }

    private static int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        // avoid conditions like {1, 2}, the depth should be 2 not 1
        return left != 0 && right != 0 ? Math.min(left, right) + 1 : Math.max(left, right) + 1;
    }
}
