package tree;

import tree.node.TreeNode;

/**
 * Created by liqiushi on 8/2/14.
 * http://www.cnblogs.com/lautsie/p/3249723.html
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(-8);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node3.right = node4;
        node3.left = node5;

        System.out.print(maxPathSum(root));
    }

    private static int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;

        int[] sum = new int[1];
        sum[0] = Integer.MIN_VALUE;
        check(root, sum);

        return sum[0];
    }

    private static int check(TreeNode root, int[] sum) {
        if (root == null)
            return 0;

        int maxl = check(root.left, sum);
        int maxr = check(root.right, sum);

        int max = Math.max(root.val, root.val + Math.max(maxl, maxr));
        sum[0] = Math.max(sum[0], Math.max(max, maxl + root.val + maxr));
        return max;
    }
}
