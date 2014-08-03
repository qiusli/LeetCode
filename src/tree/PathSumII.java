package tree;

import tree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 8/2/14.
 */
public class PathSumII {
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

        List<List<Integer>> result = pathSum(root, 12);
        for (List<Integer> list : result) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
            return result;

        check(result, new ArrayList<Integer>(), root, 0, sum);

        return result;
    }

    private static void check(List<List<Integer>> result, List<Integer> list, TreeNode node, int cur, int sum) {
        // flag to avoid add duplicate node to the list
        boolean flag = false;
        if (node != null) {
            cur += node.val;
            if (node.left == null && node.right == null) {
                if (cur == sum) {
                    flag = true;
                    list.add(node.val);

                    List<Integer> tmp = new ArrayList<Integer>();
                    for (Integer aList : list)
                        tmp.add(aList);

                    result.add(tmp);
                }
            }
        } else {
            return;
        }

        if (!flag)
            list.add(node.val);

        check(result, list, node.left, cur, sum);
        check(result, list, node.right, cur, sum);
        list.remove(list.size() - 1);
    }
}
