package linkedlist;

/**
 * Created by apple on 12/06/18.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public void print() {
        ListNode head = this;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
