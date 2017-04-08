package bst.inorder.stack;

import bst.BST;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.insert(9, bst.head);
        bst.insert(12, bst.head);
        bst.insert(1, bst.head);
        bst.insert(2, bst.head);
        bst.insert(4, bst.head);
        bst.insert(20, bst.head);
        bst.insert(19, bst.head);
        bst.insert(10, bst.head);
        bst.printStack(bst.head);
    }
}
