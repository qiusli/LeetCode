package linked_list;

import linked_list.node.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liqiushi on 7/12/14.
 */
public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        RandomListNode node_1 = new RandomListNode(-1);
        RandomListNode node_2 = new RandomListNode(-1);
//        RandomListNode node_3 = new RandomListNode(3);
//        RandomListNode node_4 = new RandomListNode(4);
//        RandomListNode node_5 = new RandomListNode(5);

        node_1.next = node_2;
//        node_2.next = node_3;
//        node_3.next = node_4;
//        node_4.next = node_5;
//
//        node_1.random = node_3;
//        node_2.random = node_5;
//        node_3.random = null;
//        node_4.random = node_2;
//        node_5.random = null;

        RandomListNode result = copyRandomList(node_1);
        while (result != null) {
            System.out.print(result.label);
            result = result.next;
        }
    }

    private static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        RandomListNode copy = new RandomListNode(head.label);
        Map<RandomListNode, RandomListNode> ori_vs_cp = new HashMap<RandomListNode, RandomListNode>();
        ori_vs_cp.put(head, copy);

        RandomListNode h = head.next, c = copy;
        while (h != null) {
            RandomListNode node = new RandomListNode(h.label);
            c.next = node;
            c = node;
            ori_vs_cp.put(h, node);

            h = h.next;
        }
        h = head;
        c = copy;

        while (h != null) {
            if (h.random != null) {
                c.random = ori_vs_cp.get(h.random);
            } else {
                c.random = null;
            }
            h = h.next;
            c = c.next;
        }

        return copy;
    }
}