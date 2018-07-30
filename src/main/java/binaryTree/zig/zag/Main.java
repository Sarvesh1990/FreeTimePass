package binaryTree.zig.zag;

import binaryTree.BT;
import binaryTree.Node;

import java.util.Stack;

/**
 * Created by apple on 23/03/17.
 */
public class Main {
    public static void main(String[] args) {
        BT bt = new BT(8);
        bt.head.left = new Node(6);
        bt.head.right = new Node(5);
        bt.head.left.left = new Node(3);
        bt.head.left.left.left = new Node(4);
        bt.head.left.left.right = new Node(100);
        bt.head.left.right = new Node(2);
        bt.head.right.right = new Node(1);
        bt.head.right.right.left = new Node(10);

        printBinaryTreeZigZag(bt.head);
    }

    private static void printBinaryTreeZigZag(Node head) {
        if(head == null) {
            return;
        }

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        boolean printRight = true;

        System.out.println(head.val);
        s1.push(head);

        while(!s1.empty() || !s2.empty()) {
            if(s1.empty() && printRight) {
                printRight = false;
            }
            if(s2.empty() && !printRight) {
                printRight = true;
            }

            if(printRight) {
                Node node = s1.pop();
                if(node.right != null) {
                    System.out.println(node.right.val);
                    s2.push(node.right);
                }
                if(node.left != null) {
                    System.out.println(node.left.val);
                    s2.push(node.left);
                }
            }

            if(!printRight) {
                Node node = s2.pop();
                if(node.left != null) {
                    System.out.println(node.left.val);
                    s1.push(node.left);
                }
                if(node.right != null) {
                    System.out.println(node.right.val);
                    s1.push(node.right);
                }
            }
        }
    }
}
