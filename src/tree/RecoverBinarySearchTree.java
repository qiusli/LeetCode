package tree;

import tree.node.TreeNode;

import java.util.ArrayList;

/**
 * Created by liqiushi on 7/23/14.
 */
public class RecoverBinarySearchTree {
    static TreeNode prev;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        recoverTree(root);
    }

    private static void recoverTree(TreeNode root) {
        if (root == null)
            return;

        ArrayList<TreeNode> wrongNodes = new ArrayList<TreeNode>();
        traverse(root, wrongNodes);

        int tmp = wrongNodes.get(0).val;
        wrongNodes.get(0).val = wrongNodes.get(wrongNodes.size() - 1).val;
        wrongNodes.get(wrongNodes.size() - 1).val = tmp;
    }

    private static void traverse(TreeNode root, ArrayList<TreeNode> wrongNodes) {
        if (root == null)
            return;

        traverse(root.left, wrongNodes);
        if (prev != null && prev.val > root.val) {
            wrongNodes.add(prev);
            wrongNodes.add(root);
        }
        prev = root;
        traverse(root.right, wrongNodes);
    }
}
