package bst;

import java.util.Stack;

/**
 * Created by apple on 20/02/17.
 */
public class BST {
    public Node head;

    public BST(int value) {
        this.head = new Node(value);
    }

    public void insert(int value, Node head) {
        if(value <= head.value) {
            if(head.left == null) {
                head.left = new Node(value);
            } else {
                insert(value, head.left);
            }
        } else {
            if(head.right == null) {
                head.right = new Node(value);
            } else {
                insert(value, head.right);
            }
        }
    }

    public void print(Node head) {
        if(head == null) {
            return;
        }
        print(head.left);
        System.out.println(head.value + " ");
        print(head.right);
    }

    public void printStack(Node head) {
        Stack<Node> stack = new Stack<>();
        if(head == null) {
            return;
        }
        Node currentNode = head;

        while(!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                Node temp = stack.pop();
                System.out.println(temp.value + " ");
                currentNode = temp.right;
            }
        }
    }

    public void printLeaf(Node head) {
        Stack<Node> stack = new Stack<>();
        if(head == null) {
            return;
        }
        Node currentNode = head;

        boolean done = false;
        while(!done) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (!stack.isEmpty()) {
                    Node temp = stack.pop();
                    if(temp.left == null && temp.right == null) {
                        System.out.println(temp.value + " ");
                    }
                    currentNode = temp.right;
                } else {
                    done = true;
                }
            }
        }
    }
}
