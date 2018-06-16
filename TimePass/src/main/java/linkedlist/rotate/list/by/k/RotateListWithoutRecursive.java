package linkedlist.rotate.list.by.k;

import linkedlist.ListNode;

public class RotateListWithoutRecursive {
    public static void main(String[] args) {
        RotateListWithoutRecursive rr = new RotateListWithoutRecursive();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        rr.rotateRight(head, 1).print();
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        int count = 1;
        ListNode temp = head;
        while(temp.next != null) {
            temp = temp.next;
            count++;
        }

        return rotateRightHelper(head, k % count);
    }

    public ListNode rotateRightHelper(ListNode head, int k) {
        if(k <= 0) {
            return head;
        }

        ListNode temp = head;
        while(k > 0) {
            temp = temp.next;
            k--;
        }

        ListNode movingHead = head;
        while(temp.next != null) {
            temp = temp.next;
            movingHead = movingHead.next;
        }

        ListNode newHead = movingHead.next;
        movingHead.next = null;
        temp.next = head;
        head = newHead;
        return head;
    }
}
