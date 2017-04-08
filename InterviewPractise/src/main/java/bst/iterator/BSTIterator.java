package bst.iterator;
import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.val = value;
        }
    }
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        stack.push(root);
        while(root.left != null) {
            root = root.left;
            stack.push(root);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /** @return the next smallest number */
    public int next() {
        int val = -1;
        if(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            val = temp.val;
            if(temp.right != null) {
                TreeNode right = temp.right;
                stack.push(right);
                while (right.left != null) {
                    right = right.left;
                    stack.push(right);
                }
            }

        }
        return val;
    }

    public static void main(String[] args) {
        BSTIterator bstIterator = new BSTIterator(new TreeNode(12));
        System.out.println(bstIterator.next());
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */