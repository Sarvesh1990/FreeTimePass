package bst.merge.bsts;

import bst.BST;
import bst.Node;

import java.util.Stack;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        BST bst1 = new BST(8);
        bst1.insert(11, bst1.head);
        bst1.insert(1, bst1.head);
        bst1.insert(19, bst1.head);

        BST bst2 = new BST(5);
        bst2.insert(3, bst2.head);
        bst2.insert(0, bst2.head);
        bst2.insert(2, bst2.head);

        merge(bst1, bst2);
    }

    private static void merge(BST bst1, BST bst2) {
        Stack<Node> stack1 = new Stack();
        Stack<Node> stack2 = new Stack();

        if(bst1.head == null) {
            bst2.printStack(bst2.head);
            return;
        }

        if(bst2.head == null) {
            bst1.printStack(bst1.head);
            return;
        }

        stack1.push(bst1.head);
        stack2.push(bst2.head);

        Node currentNode1 = bst1.head.left;
        Node currentNode2 = bst2.head.left;

        while(currentNode1 != null || currentNode2 != null || !stack1.isEmpty() || !stack2.isEmpty()) {
            if(currentNode1 == null && currentNode2 == null) {
                //Do something
                if(!stack1.isEmpty() && !stack2.isEmpty()) {
                    int temp1 = stack1.peek().value;
                    int temp2 = stack2.peek().value;

                    if(temp1 < temp2) {
                        System.out.println(temp1 + " ");
                        currentNode1 = stack1.pop().right;
                    } else {
                        System.out.println(temp2 + " ");
                        currentNode2 =  stack2.pop().right;
                    }
                } else if(!stack1.isEmpty()) {
                    System.out.println(stack1.peek().value + " ");
                    currentNode1 = stack1.pop().right;
                } else {
                    System.out.println(stack2.peek().value + " ");
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
    }
}
