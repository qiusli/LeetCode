package tree;

import tree.node.TreeNode;

/**
 * Created by liqiushi on 7/31/14.
 */
public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        TreeNode node = sortedArrayToBST(num);
        System.out.print("");
    }

    private static TreeNode sortedArrayToBST(int[] num) {
        if (num == null)
            return null;

        return build(num, 0, num.length - 1);
    }

    private static TreeNode build(int[] num, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = build(num, start, mid - 1);
        root.right = build(num, mid + 1, end);

        return root;
    }
}
