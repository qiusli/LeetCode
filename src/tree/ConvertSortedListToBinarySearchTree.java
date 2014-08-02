package tree;

import tree.node.ListNode;
import tree.node.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liqiushi on 8/1/14.
 */
public class ConvertSortedListToBinarySearchTree {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        TreeNode result = sortedListToBST(node1);
        System.out.print("");
    }

    private static TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i;
        for (i = 0; head != null; i++) {
            map.put(i, head.val);
            head = head.next;
        }

        return build(map, 0, i - 1);
    }

    private static TreeNode build(Map<Integer, Integer> map, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(map.get(mid));
        node.left = build(map, start, mid - 1);
        node.right = build(map, mid + 1, end);

        return node;
    }
}
