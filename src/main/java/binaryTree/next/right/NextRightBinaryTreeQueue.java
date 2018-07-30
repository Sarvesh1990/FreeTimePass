package binaryTree.next.right;

import java.util.LinkedList;
import java.util.Queue;

public class NextRightBinaryTreeQueue {
    public void connect(TreeLinkNode treeLinkNode) {
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

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
     }
}
