package bst.match.leaf;

import bst.BST;
import bst.Node;

import java.util.Stack;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        BST bst1 = new BST(5);
        bst1.insert(6, bst1.head);
        bst1.insert(9, bst1.head);
        bst1.insert(1, bst1.head);
        bst1.insert(2, bst1.head);
        bst1.insert(3, bst1.head);
        bst1.insert(4, bst1.head);

        BST bst2 = new BST(8);
        bst2.insert(9, bst2.head);
        bst2.insert(7, bst2.head);
        bst2.insert(3, bst2.head);
        bst2.insert(4, bst2.head);

        System.out.println(checkIfLeafSame(bst1, bst2));
    }

    private static boolean checkIfLeafSame(BST bst1, BST bst2) {
        Stack<Node> stack1 = new Stack();
        Stack<Node> stack2 = new Stack();

        if(bst1.head == null) {
            return false;
        }

        if(bst2.head == null) {
            return false;
        }

        stack1.push(bst1.head);
        stack2.push(bst2.head);

        Node currentNode1 = bst1.head.left;
        Node currentNode2 = bst2.head.left;

        while(currentNode1 != null || currentNode2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            if(currentNode1 == null && currentNode2 == null) {
                if(!stack1.isEmpty() && !stack2.isEmpty()) {
                    Node temp1 = stack1.peek();
                    Node temp2 = stack2.peek();

                    if(temp1.isLeaf() && temp2.isLeaf()) {
                        if(temp1.value != temp2.value) {
                            return false;
                        }
                        currentNode1 = stack1.pop().right;
                        currentNode2 = stack2.pop().right;
                    }
                    if(!temp1.isLeaf()) {
                        currentNode1 = stack1.pop().right;
                    }
                    if(!temp2.isLeaf()) {
                        currentNode2 = stack2.pop().right;
                    }
                } else if(!stack1.isEmpty()) {
                    if(stack1.peek().isLeaf()) {
                        return false;
                    }
                    currentNode1 = stack1.pop().right;
                } else {
                    if(stack2.peek().isLeaf()) {
                        return false;
                    }
                    currentNode2 = stack2.pop().right;
                }

            } else if (currentNode1 != null) {
                stack1.push(currentNode1);
                currentNode1 = currentNode1.left;
            } else {
                stack2.push(currentNode2);
                currentNode2 = currentNode2.left;
            }
        }
        return true;
    }
}
