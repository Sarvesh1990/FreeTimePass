package bst.inorder.successor;

import bst.BST;
import bst.Node;

import java.util.regex.Pattern;

/**
 * Created by sarvesh on 7/3/17.
 */
public class Main {
    public static void main(String[] args) {
        BST bst = new BST(20);
        bst.insert(8, bst.head);
        bst.insert(4, bst.head);
        bst.insert(22, bst.head);
        bst.insert(12, bst.head);
        bst.insert(10, bst.head);
        bst.insert(14, bst.head);

        System.out.println(inorderSuccessor(bst.head, 2, -1));
    }

    private static Integer inorderSuccessor(Node head, int k, int currentSuccessor) {
        if(head == null) {
            return -1;
        }
        if(head.value == k) {
            if(head.right != null) {
                return inorderValue(head.right);
            } else {
                return currentSuccessor;
            }
        } else {
            if(k > head.value) {
                if(head.right != null) {
                    return inorderSuccessor(head.right, k, currentSuccessor);
                } else {
                    return -1;
                }
            } else {
                if(head.left != null) {
                    return inorderSuccessor(head.left, k, head.value);
                } else {
                    return -1;
                }
            }
        }
    }

    private static Integer inorderValue(Node head) {
        while(head.left != null) {
            head = head.left;
        }
        return head.value;
    }


}
