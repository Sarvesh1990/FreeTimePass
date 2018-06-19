package linkedlist.remove.element.which.have.duplicates;

import linkedlist.ListNode;

/*
Keep two pointers. One previous and one temp. Initialise previous to be head and temp to be head.next.
Till we get temp == null, we keep traversing. Check if temp.next exist and temp.next.val = temp.val. If yes, remove temp.next.
If none of the above case if there, check if we need to remove current temp because of duplicate.
In the end check if we need to remove head value too. That value is not removed in the beginning as we start temp from temp.next;
 */

public class RemoveElementsWhichHaveDuplicates {
    public static void main(String[] args) {
        RemoveElementsWhichHaveDuplicates re = new RemoveElementsWhichHaveDuplicates();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        re.deleteDuplicates(head).print();
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = head.next;
        ListNode previous = head;
        boolean duplicateExist = false;
        boolean headDuplicateExiste = false;

        if(previous.val == temp.val) {
            headDuplicateExiste = true;
            duplicateExist = true;
        }

        while(temp != null) {
            if(temp.next != null && temp.val == temp.next.val) {
                duplicateExist = true;
                temp.next = temp.next.next;
            } else {
                if(duplicateExist) {
                    temp = temp.next;
                    previous.next = temp;
                    duplicateExist = false;
                } else {
                    temp = temp.next;
                    previous = previous.next;
                }
            }
        }

        if(headDuplicateExiste) {
            head = head.next;
        }

        return head;
    }
}
