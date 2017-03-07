package binaryTree.convert.dll;

import binaryTree.BT;
import binaryTree.Node;

/**
 * Created by apple on 27/02/17.
 */
public class Main {
    public static void main(String[] args) {
        BT bt = new BT(10);
        bt.head.left = new Node(11);
        bt.head.left.right = new Node(15);
        bt.head.right = new Node(12);
        bt.head.left.left = new Node(13);
        bt.head.right.left = new Node(16);
        bt.head.right.right = new Node(14);

        Node head = convertDll(bt.head);
        while(head != null) {
            System.out.println(head.value);
            head = head.right;
        }
    }

    private static Node convertDll(Node head) {
        if(head == null) {
            return head;
        }
        Node leftTreeHead = convertDll(head.left);
        Node rightTreeHead = convertDll(head.right);
        head = merge(leftTreeHead, head, true);
        head = merge(head, rightTreeHead, false);
        while(head.left != null) {
            head = head.left;
        }
        return head;
    }

    private static Node merge(Node left, Node right, boolean leftSide) {
        if(left != null && right != null) {
            if(leftSide) {
                while (left.right != null) {
                    left = left.right;
                }
            }
            left.right = right;
            right.left = left;
            return right;
        } else if(left == null) {
            return right;
        } else {
            return left;
        }
    }


}
