package tree;

import tree.node.TreeLinkNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liqiushi on 8/3/14.
 */
public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode node1 = new TreeLinkNode(2);
        TreeLinkNode node2 = new TreeLinkNode(3);
        TreeLinkNode node3 = new TreeLinkNode(4);
        TreeLinkNode node4 = new TreeLinkNode(5);
        TreeLinkNode node5 = new TreeLinkNode(6);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node3.right = node4;
        node3.left = node5;

        connect(root);
    }

    private static void connect(TreeLinkNode root) {
        if (root == null)
            return;

        List<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = queue.get(0);
                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);

                queue.remove(node);
            }

            for (int i = 0; i < queue.size(); i++) {
                if (i + 1 < queue.size()) {
                    queue.get(i).next = queue.get(i + 1);
                }
            }
        }

        System.out.print("");
    }
}
