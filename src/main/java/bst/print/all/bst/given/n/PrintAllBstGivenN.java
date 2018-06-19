package bst.print.all.bst.given.n;

import bst.TreeNode;

import java.util.LinkedList;
import java.util.List;

/*
Choose current node. Find list for left node. Find list for right. Traverse both and attach.
If start > end, return list will one null node.
 */

public class PrintAllBstGivenN {
    public static void main(String[] args) {
        PrintAllBstGivenN printAllBstGivenN = new PrintAllBstGivenN();
        for(TreeNode node : printAllBstGivenN.generateTrees(3)) {
            TreeNode.print(node);
            System.out.println();
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new LinkedList<>();
        }
        return generateTreesHelper(1, n);
    }

    public List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> nodeList = new LinkedList<>();
        if(start > end) {
            TreeNode node = null;
            nodeList.add(node);
            return nodeList;
        }

        for(int i = start; i <= end; i++) {
            List<TreeNode> leftList = generateTreesHelper(start, i - 1);
            List<TreeNode> rightList = generateTreesHelper(i + 1, end);

            for(TreeNode leftNode : leftList) {
                for(TreeNode rightNode: rightList) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    nodeList.add(node);
                }
            }
        }

        return nodeList;
    }
}
