package bst.convert.to.dll;

import bst.Node;

/*
Left and right case different. First to dll for left, then do dll for right. If left = null : Make root dll, else merge left and root.
This merge will be normal merge.
Now if right == null, return current head. Else merge head with right. Both are DLL in this case.
 */

public class BSTToDoublyLinkedList {
    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(3);

        BSTToDoublyLinkedList bs = new BSTToDoublyLinkedList();
        Node head = bs.treeToDoublyList(node);

        Node temp = head;

        System.out.println(temp.value +  " " + temp.right.value + " " + temp.right.right.value + " " + temp.right.right.right.value + " "
         + temp.left.value);
    }

    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }

        Node head = null;
        Node rootLeft = null;
        Node rootRight = null;

        if(root.left != null) {
            rootLeft = treeToDoublyList(root.left);
        }
        if(root.right != null) {
            rootRight = treeToDoublyList(root.right);
        }

        if(rootLeft == null) {
            root.left = root;
            root.right = root;
            head = root;
        } else {
            head = merge(rootLeft, root, true);
        }

        if(rootRight == null) {
            return head;
        } else {
            head = merge(head, rootRight, false);
        }
        return head;
    }

    public Node merge(Node leftNode, Node rightNode, boolean ifLeft) {
        if(ifLeft) {
            Node temp = leftNode.left;
            leftNode.left = rightNode;
            temp.right = rightNode;
            rightNode.left = temp;
            rightNode.right = leftNode;
        } else {
            Node temp = leftNode.left;
            leftNode.left = rightNode.left;
            temp.right = rightNode;
            rightNode.left.right = leftNode;
            rightNode.left = temp;
        }


        return leftNode;
    }
}
