package linkedlist.palindrome.reverse;

import linkedlist.LinkedList;
import linkedlist.Node;

/**
 * Created by apple on 25/02/17.
 */
public class CheckIfLinkedListPalindromeByReversingMid {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.push(new Node(2));
        list.push(new Node(3));
        list.push(new Node(4));
        list.push(new Node(5));
        list.push(new Node(6));

        palindromeReverse(list);
        list.printList();
    }

    private static void palindromeReverse(LinkedList list) {
        if(list.getSize() == 0 || list.getSize() == 1)
            return;

        Node temp = list.getHead();
        int mid = (list.getSize() - 1)/2;
        for(int i = 0; i <= mid; i++) {
            temp = temp.getNext();
        }

        temp = reverse(temp);

        Node first = list.getHead();
        Node second = temp;

        for(int i = 0; i <= mid; i++) {
            if(first != null && second  != null) {
                int tempInt = second.getValue();
                second.setValue(first.getValue());
                first.setValue(tempInt);
                first = first.getNext();
                second = second.getNext();
            }
        }
        reverse(temp);
    }

    private static Node reverse(Node head) {
        Node first = head.getNext();
        head.setNext(null);

        while(first != null) {
            Node second = first.getNext();
            first.setNext(head);
            head = first;
            first = second;
        }

        return head;
    }


}
