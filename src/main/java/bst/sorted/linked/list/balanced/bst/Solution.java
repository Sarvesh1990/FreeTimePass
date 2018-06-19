package bst.sorted.linked.list.balanced.bst;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by apple on 20/04/17.
 */
public class Solution {
    public static PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    public static ListNode head;
    public static void main(String[] args) {
        System.out.println(minQueue.peek());
        head = new ListNode(1);
        head.next = new ListNode(3);
        TreeNode node = sortedListToBST();
        System.out.println(node.val + " " + node.left.val);
    }

    public static TreeNode sortedListToBST() {
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        TreeNode node = printBSTHelper(size);
        return node;
    }

    public static TreeNode printBSTHelper(int size) {
        if(size == 0) {
            return null;
        }
        if(size == 1) {
            TreeNode node = new TreeNode(head.val);
            head = head.next;
            return node;
        }
        TreeNode leftNode = printBSTHelper(size/2);
        System.out.println(head.val + " " + size);
        if(head == null) {
            return leftNode;
        }
        TreeNode node = new TreeNode(head.val);
        head = head.next;
        node.left = leftNode;
        node.right = printBSTHelper(size - size/2 - 1);
        return node;
    }
}
