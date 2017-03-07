package binaryTree.create;

import binaryTree.BT;
import binaryTree.Node;

/**
 * Created by apple on 25/02/17.
 */
public class Main {
    public static void main(String[] args) {
        Node head  = createTree(new int[] {4, 2, 5, 1, 2, 6, 7, 3, 9, 8, 11}, new int[] {1, 2, 4, 5, 3, 6, 2, 7, 8, 9, 11});
        BT bt = new BT();
        bt.head = head;
        bt.print(bt.head);

    }

    private static Node createTree(int[] inorder, int[] preorder) {
        int inorderStart = 0;
        int preorderStart = 0;
        int inorderEnd = inorder.length - 1;
        int preorderEnd = preorder.length - 1;
        return createTreeHelper(inorder, preorder, inorderStart, inorderEnd, preorderStart, preorderEnd);
    }

    private static Node createTreeHelper(int[] inorder, int[] preorder, int inorderStart, int inorderEnd, int preorderStart, int preorderEnd) {
        if(inorderStart > inorderEnd || preorderStart > preorderEnd) {
            return null;
        }

        BT bt = new BT(preorder[preorderStart]);

        if(inorderStart == inorderEnd) {
            return bt.head;
        }

        for(int i = inorderStart; i <= inorderEnd; i++) {
            if(inorder[i] == preorder[preorderStart]) {
                bt.head.left = createTreeHelper(inorder, preorder, inorderStart, i - 1, preorderStart + 1, preorderStart + (i - inorderStart));
                bt.head.right = createTreeHelper(inorder, preorder, i + 1, inorderEnd, preorderStart + (i + 1 - inorderStart), preorderEnd);
            }
        }
        return bt.head;
    }


}
