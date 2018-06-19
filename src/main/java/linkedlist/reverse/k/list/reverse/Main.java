package linkedlist.reverse.k.list.reverse;

import linkedlist.LinkedList;
import linkedlist.Node;

/**
 * Created by sarvesh on 5/4/17.
 */
public class Main {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);

        ListNode reverted = reverse(list, 4);
        while (reverted != null) {
            System.out.println(reverted.val);
            reverted = reverted.next;
        }
    }

    private static ListNode reverse(ListNode head, int k) {
        int reversedSize = k;
        int count = 0;

        ListNode tempHead = head;
        while (tempHead != null)  {
            count++;
            tempHead = tempHead.next;
        }

        tempHead = head;
        while(reversedSize <= count) {
            tempHead = reverseList(tempHead, k, 0).next;
            reversedSize = reversedSize + k;
        }
        return head;
    }

    private static ListNode reverseList(ListNode head, int k, int currentPos) {
        if(k % 2 == 0) {
            if(currentPos == k / 2 - 1) {
                int temp = head.next.val;
                head.next.val = head.val;
                head.val = temp;
                return head.next;
            }
        } else {
            if(currentPos == k / 2 ) {
                return head;
            }
        }

        ListNode next = reverseList(head.next, k, currentPos + 1);
        int temp = next.next.val;
        next.next.val = head.val;
        head.val = temp;
        return next.next;
    }
}
