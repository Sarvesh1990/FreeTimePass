package linkedlist.reverse.list.from.to;

import linkedlist.ListNode;

/*
if m >= n -> Nothing to reverse
Keep multiple node. One node to store current beforeStartNode. This node pointer will be changed to point to reversed list head.
Move. Store next Element next as temp. Make next element next point to currentElement. move currentElement;
 */
public class ReverseListFromTo {
    public static void main(String[] args) {
        ReverseListFromTo rr = new ReverseListFromTo();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        rr.reverseBetween(head, 2, 4).print();
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n) {
            return head;
        }

        if (head == null || head.next == null) {
            return head;
        }

        ListNode start = head;
        ListNode beforeStart = null;
        for (int i = 1; i < m; i++) {
            beforeStart = start;
            start = start.next;
        }

        ListNode temp = start.next;
        ListNode temp1 = null;
        ListNode movingStart = start;
        while (m < n) {
            temp1 = temp.next;
            temp.next = movingStart;
            movingStart = temp;
            temp = temp1;
            m++;
        }

        if (beforeStart == null) {
            head = movingStart;
        } else {
            beforeStart.next = movingStart;
        }
        start.next = temp;

        return head;
    }
}
