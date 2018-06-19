package linkedlist.remove.n.from.end;

import linkedlist.ListNode;

import java.util.List;

/**
 * Created by apple on 12/06/18.
 */
public class Solution {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode temp1 = head;

        for(int i = 1; i <= n; i++) {
            temp = temp.next;
        }

        if(temp == null) {
            return head.next;
        }

        while(temp.next != null) {
            temp = temp.next;
            temp1 = temp1.next;
        }

        temp1.next = temp1.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        System.out.println(removeNthFromEnd(list, 1));
    }
}

