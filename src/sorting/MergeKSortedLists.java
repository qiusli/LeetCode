package sorting;

import sorting.node.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 8/3/14.
 * http://blog.csdn.net/linhuanmars/article/details/19899259
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(9);

        l1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode l2 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(10);

        l2.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        List<ListNode> lists = new ArrayList<ListNode>();
        lists.add(l1);
        lists.add(l2);

        ListNode result = mergeKLists(lists);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    private static ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;

        return helper(lists, 0, lists.size() - 1);
    }

    private static ListNode helper(List<ListNode> lists, int start, int end) {
        if (start >= end)
            return lists.get(start);

        int mid = (start + end) / 2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);

        return merge(left, right);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode n = node;

        while (l1 != null && l2 != null) {
            int val;
            if (l1.val < l2.val) {
                val = l1.val;
                l1 = l1.next;
            } else {
                val = l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(val);
            node = node.next;
        }

        while (l1 != null) {
            node.next = new ListNode(l1.val);
            node = node.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            node.next = new ListNode(l2.val);
            node = node.next;
            l2 = l2.next;
        }

        return n.next;
    }
}
