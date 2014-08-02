package tree;

import tree.node.TreeNode;

/**
 * Created by liqiushi on 8/2/14.
 */
public class PathSum {
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

        System.out.print(hasPathSum(root, 13));
    }

    private static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        boolean flag;
        if (root.left == null)
            flag = check(root.right, root.val, sum);
        else if (root.right == null)
            flag = check(root.left, root.val, sum);
        else
            flag = check(root, 0, sum);

        return flag;
    }

    private static boolean check(TreeNode node, int cur, int sum) {
        if (node != null) {
            cur += node.val;
            if (node.left == null && node.right == null)
                return cur == sum;
        } else {
            return false;
        }

        return check(node.left, cur, sum) || check(node.right, cur, sum);
    }
}
