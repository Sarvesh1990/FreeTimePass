package linkedlist.addition.linkedlist;

import linkedlist.ListNode;

/**
 * Created by apple on 12/06/18.
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode summedNode = new ListNode(0);
        ListNode temp = summedNode;
        int carryForward = 0;

        while(l1 != null || l2 != null) {
            ListNode temp1;
            if(l1 != null && l2 != null) {
                temp1 = new ListNode((l1.val + l2.val + carryForward)%10);
                carryForward = (l1.val + l2.val + carryForward)/10;
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1 == null) {
                temp1 = new ListNode((l2.val + carryForward)%10);
                carryForward = (l2.val + carryForward)/10;
                l2 = l2.next;
            } else {
                temp1 = new ListNode((l1.val + carryForward)%10);
                carryForward = (l1.val + carryForward)/10;
                l1 = l1.next;
            }
            temp.next = temp1;
            temp = temp.next;
        }

        if(carryForward > 0) {
            temp.next = new ListNode(carryForward);
        }

        return summedNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        System.out.println(addTwoNumbers(node1, null).val);
    }
}
