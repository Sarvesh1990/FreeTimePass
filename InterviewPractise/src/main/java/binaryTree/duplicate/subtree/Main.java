package binaryTree.duplicate.subtree;

import binaryTree.BT;
import binaryTree.Node;

/**
 * Created by sarvesh on 12/3/17.
 */
public class Main {
    public static void main(String[] args) {
        BT bt = new BT(1);
        bt.head.left = new Node(2);
        bt.head.left.left = new Node(4);
        bt.head.right = new Node(3);
        bt.head.right.left = new Node(2);
        bt.head.right.left.left = new Node(4);
        bt.head.right.right = new Node(4);

        printAllSubtrees(bt.head);
    }

    private static String printAllSubtrees(Node head) {
        String signature = null;
        if(head == null) {
            return null;
        }

        String left = printAllSubtrees(head.left);
        String right = printAllSubtrees(head.right);

        signature = (left != null ? left + "+" : "") + head.value + (right != null ? "+" + right : "");
        System.out.println(signature);
        return signature;
    }


}
