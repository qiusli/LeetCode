package tree;

import tree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 7/23/14.
 */
public class BinaryTreeInorderTraversal {
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

        List<Integer> result = inorderTraversal(root);
        for (int i : result)
            System.out.print(i);
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        if (root == null)
            return list;

        traverse(root, list);
        return list;
    }

    private static void traverse(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}
