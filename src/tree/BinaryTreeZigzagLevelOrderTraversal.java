package tree;

import tree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 7/23/14.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
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

        List<List<Integer>> result = zigzagLevelOrder(root);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root == null)
            return result;

        boolean odd = true;
        List<TreeNode> child = new ArrayList<TreeNode>();
        child.add(root);
        while (child.size() > 0) {
            List<Integer> tmp = new ArrayList<Integer>();
            List<TreeNode> nextLayer = new ArrayList<TreeNode>();

            for (TreeNode node : child) {
                tmp.add(node.val);
                if (node.left != null)
                    nextLayer.add(node.left);
                if (node.right != null)
                    nextLayer.add(node.right);
            }

            if (!odd) {
                List<Integer> t = new ArrayList<Integer>();
                while (tmp.size() > 0) {
                    t.add(tmp.remove(tmp.size() - 1));
                }
                result.add(t);
            } else {
                result.add(tmp);
            }
            child = nextLayer;
            odd = !odd;
        }

        return result;
    }
}
