package bst.check.valid.bst;

import bst.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Do inorder traversal and check if inorder sorted.
 */
public class CheckIfValidBST {
    public static void main(String[] args) {
        TreeNode node  = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.right.left = new TreeNode(2);

        CheckIfValidBST cv = new CheckIfValidBST();
        System.out.println(cv.isValidBST(node));
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrder = inOrderTraversal(root);

        boolean isValid = true;
        for(int i = 0; i < inOrder.size() - 1; i++) {
            if(inOrder.get(i) >= inOrder.get(i + 1)) {
                return false;
            }
        }
        return isValid;
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = inOrderTraversal(root.left);
        list.add(root.val);
        for(Integer number : inOrderTraversal(root.right)) {
            list.add(number);
        }

        return list;
    }
}
