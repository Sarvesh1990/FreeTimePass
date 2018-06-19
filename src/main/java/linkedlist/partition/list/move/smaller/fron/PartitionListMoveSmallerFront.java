package linkedlist.partition.list.move.smaller.fron;

import linkedlist.ListNode;

/*
Traverse till head != null.
Make two list, one which contains small and one which contains big. Check for head val. If small insert in small.
Will need to keep last pointer too to insert.
In end if small not null, make small head and point last pointer of small to large.
Otherwise make larget head.
 */

public class PartitionListMoveSmallerFront {
    public static void main(String[] args) {
        PartitionListMoveSmallerFront pl = new PartitionListMoveSmallerFront();

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        pl.partition(head, 3).print();

    }

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = null;
        ListNode smallHeadCurr = null;;
        ListNode largeHead = null;;
        ListNode largeHeadCurr = null;

        if(head == null || head.next == null) {
            return head;
        }

        while(head != null) {
            if(head.val < x) {
                if(smallHead != null) {
                    smallHeadCurr.next = new ListNode(head.val);
                    smallHeadCurr = smallHeadCurr.next;
                } else {
                    smallHead = new ListNode(head.val);
                    smallHeadCurr = smallHead;
                }
            } else {
                if(largeHead != null) {
                    largeHeadCurr.next = new ListNode(head.val);
                    largeHeadCurr = largeHeadCurr.next;
                } else {
                    largeHead = new ListNode(head.val);
                    largeHeadCurr = largeHead;
                }
            }
            head = head.next;
        }

        if(smallHead != null) {
            head = smallHead;
            smallHeadCurr.next = largeHead;
        } else {
            head = largeHead;
        }

        return head;
    }
}
