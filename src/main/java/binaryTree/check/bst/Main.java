package binaryTree.check.bst;

import binaryTree.BT;
import binaryTree.Node;

/**
 * Created by apple on 08/03/17.
 */
public class Main {
    public static void main(String[] args) {
        BT bt = new BT(10);
        bt.head.left = new Node(9);
        bt.head.right = new Node(11);
        bt.head.left.left = new Node(8);
        bt.head.right.left = new Node(7);
        bt.head.right.right = new Node(12);

        System.out.println(checkIfBST(bt.head));
    }

    private static boolean checkIfBST(Node head) {
        if(head.left == null && head.right == null) {
            return true;
        }

        boolean leftIfBST = false;
        boolean rightIfBST = false;

        if(head.left != null) {
            if(head.left.value > head.value) {
                System.out.println(head.left.value);
                return false;
            }
            leftIfBST = checkIfBST(head.left);
        } else  {
            leftIfBST = true;
        }

        if(head.right != null) {
            if(head.right.value < head.value) {
                System.out.println(head.right.value);
                return false;
            }
            rightIfBST = checkIfBST(head.right);
        } else {
            rightIfBST = true;
        }

        return leftIfBST && rightIfBST;
    }

}

