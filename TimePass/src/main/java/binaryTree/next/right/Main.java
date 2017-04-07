package binaryTree.next.right;

import binaryTree.BT;
import binaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sarvesh on 6/4/17.
 */
public class Main {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x)  {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode treeLinkNode = new TreeLinkNode(1);
        treeLinkNode.left = new TreeLinkNode(2);
        treeLinkNode.right = new TreeLinkNode(3);
        treeLinkNode.left.left = new TreeLinkNode(4);
        treeLinkNode.left.right = new TreeLinkNode(5);
        treeLinkNode.right.right = new TreeLinkNode(7);

        connect(treeLinkNode);


    }

    private static void connect(TreeLinkNode treeLinkNode) {
        if(treeLinkNode == null) {
            return;
        }
        Queue<TreeLinkNode> queue1 = new LinkedList<>();
        Queue<TreeLinkNode> queue2 = new LinkedList<>();

        queue1.add(treeLinkNode);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if(!queue1.isEmpty()) {
                while(!queue1.isEmpty()) {
                    TreeLinkNode current = queue1.poll();
                    if(current.left != null) {
                        queue2.add(current.left);
                    }
                    if(current.right != null) {
                        queue2.add(current.right);
                    }

                    if(!queue1.isEmpty()) {
                        current.next = queue1.peek();
                    }
                }
            } else {
                while(!queue2.isEmpty()) {
                    TreeLinkNode current = queue2.poll();
                    if(current.left != null) {
                        queue1.add(current.left);
                    }
                    if(current.right != null) {
                        queue1.add(current.right);
                    }

                    if(!queue2.isEmpty()) {
                        current.next = queue2.peek();
                    }
                }
            }
        }
    }
}
