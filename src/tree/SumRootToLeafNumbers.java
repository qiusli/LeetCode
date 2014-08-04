package tree;

import tree.node.TreeNode;

import java.util.LinkedList;

/**
 * Created by liqiushi on 8/3/14.
 */
public class SumRootToLeafNumbers {
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

        System.out.print(sumNumbers(root));
    }

    private static int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        int[] sum = new int[1];
        add(root, new LinkedList<Integer>(), sum);

        return sum[0];
    }

    private static void add(TreeNode root, LinkedList<Integer> list, int[] sum) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            list.add(root.val);
            int scalar = 1;
            for (int i = list.size() - 1; i >= 0; i--) {
                sum[0] += scalar * list.get(i);
                scalar *= 10;
            }
            list.remove(list.size() - 1);
            return;
        }

        list.add(root.val);
        add(root.left, list, sum);
        add(root.right, list, sum);
        list.remove(list.size() - 1);
    }
}
