package binaryTree;


import java.util.Stack;

/**
 * Created by apple on 20/02/17.
 */
public class BT {
    public Node head;

    public BT(int value) {
        this.head = new Node(value);
    }

    public BT() {

    }

    public void print(Node head) {
        if(head == null) {
            return;
        }
        print(head.left);
        System.out.println(head.val + " ");
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
                System.out.println(temp.val + " ");
                currentNode = temp.right;
            }
        }
    }
}
