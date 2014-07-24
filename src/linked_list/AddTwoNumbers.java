package linked_list;

import linked_list.node.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqiushi on 7/6/14.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node_a1 = new ListNode(1);
//        ListNode node_a2 = new ListNode(2);
//        ListNode node_a3 = new ListNode(3);

//        node_a1.next = node_a2;
//        node_a2.next = node_a3;

        ListNode node_b1 = new ListNode(9);
        ListNode node_b2 = new ListNode(9);

        node_b1.next = node_b2;

//        ListNode node_a1 = new ListNode(5);
//        ListNode node_b1 = new ListNode(5);

        ListNode node = addTwoNumbers(node_a1, node_b1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<Integer>();

        int carry_over = 0;
        while (l1 != null && l2 != null) {
            int cur_val = l1.val + l2.val + carry_over;
            carry_over = 0;

            if (cur_val > 9) {
                carry_over = 1;
                cur_val -= 10;
            }

            list.add(cur_val);

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int cur_val = l1.val + carry_over;
            carry_over = 0;

            if (cur_val > 9) {
                carry_over = 1;
                cur_val -= 10;
            }
            list.add(cur_val);
            l1 = l1.next;
        }

        while (l2 != null) {
            int cur_val = l2.val + carry_over;
            carry_over = 0;

            if (cur_val > 9) {
                carry_over = 1;
                cur_val -= 10;
            }
            list.add(cur_val);
            l2 = l2.next;
        }

        if (carry_over != 0)
            list.add(carry_over);

        ListNode result = new ListNode(list.get(0));
        ListNode head = result;
        for (int i = 1; i < list.size(); i++) {
            result.next = new ListNode(list.get(i));
            result = result.next;
        }

        return head;
    }
}
