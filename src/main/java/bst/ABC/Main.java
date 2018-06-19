package bst.ABC;

import bst.BST;
import bst.Node;

public class Main {
    public static void main(String[] args) {
        BST bst = new BST(5);
        bst.insert(2, bst.head);
        bst.insert(8, bst.head);
        bst.insert(3, bst.head);
        bst.insert(6, bst.head);
        bst.insert(9, bst.head);
        bst.insert(1, bst.head);

        System.out.println(abc(bst, 6));
        System.out.println(abc(bst,1));
        System.out.println(abc(bst,10));
        System.out.println(abc(bst,2));
    }

    private static String abc(BST bst, int number) {
        StringBuilder notation = new StringBuilder("");
        boolean found = false;

        Node node = bst.head;

        while(node != null && !found) {
            if(node.value == number) {
                found = true;
            } else if (number > node.value) {
                notation.append("1");
                node = node.right;
            } else {
                notation.append("0");
                node = node.left;
            }
        }

        if(!found) {
            notation = new StringBuilder("NotFound");
        }

        return String.valueOf(notation);
    }
}
