package linked_list;

import linked_list.node.ListNode;

/**
 * Created by liqiushi on 7/8/14.
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(1);
        ListNode node_3 = new ListNode(2);
        ListNode node_4 = new ListNode(3);
        ListNode node_5 = new ListNode(3);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;

        ListNode result = deleteDuplicates(node_1);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode result = head;
        while (head != null) {
            ListNode pivot = head;
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            pivot.next = head.next;
            head = head.next;
        }

        return result;
    }
}
