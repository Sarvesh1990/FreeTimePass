package linkedlist.rotate.list.by.k;

import linkedlist.ListNode;

public class RotateListByKRecursive {
    public static void main(String[] args) {
        RotateListByKRecursive rr = new RotateListByKRecursive();
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
        while(temp.next.next != null) {
            temp = temp.next;
        }
        ListNode lastNode = temp.next;
        temp.next = null;
        lastNode.next = head;
        head = lastNode;

        return rotateRightHelper(head, k - 1);
    }

}
