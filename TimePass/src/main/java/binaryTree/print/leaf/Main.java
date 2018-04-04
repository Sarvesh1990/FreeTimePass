package binaryTree.print.leaf;

import binaryTree.BT;
import binaryTree.Node;

import java.util.LinkedList;
import java.util.List;

import static java.lang.StrictMath.abs;

/**
 * Created by apple on 16/03/17.
 */
public class Main {
    public static void main(String[] args) {
        BT bt = new BT(1);
        bt.head.left = new Node(2);
        bt.head.right = new Node(3);
        bt.head.left.left = new Node(4);
        bt.head.left.right = new Node(5);
        bt.head.right.left = new Node(6);
        bt.head.right.right = new Node(7);
        bt.head.right.left.left = new Node(8);

        LinkedList<Depth> valueQueue = new LinkedList<>();

        pathToLeafWithUnderscore(bt.head, valueQueue, 0, 0);
    }

    private static void pathToLeafWithUnderscore(Node head, LinkedList<Depth> valueQueue, int currentDepth, int maxCount) {
        if(head == null) {
            return;
        }

        valueQueue.add(new Depth(head.value, currentDepth));

        if(currentDepth > maxCount) {
            maxCount = currentDepth;
        }

        if(head.left == null && head.right == null) {
            LinkedList<Depth> temp = new LinkedList<>();
            temp.addAll(valueQueue);

            for(int i = 0; i < temp.size(); i++) {
                int numUnderScore = abs(temp.get(i).depth - (maxCount > 0 ? maxCount : 0));
                String print = "";
                for(int j = 0; j < numUnderScore; j++) {
                    print = print + "_";
                }
                print = print + temp.get(i).value;
                System.out.println(print);
            }
        } else {
            if(head.left != null)
                pathToLeafWithUnderscore(head.left, valueQueue, currentDepth + 1, maxCount);
            if(head.right != null)
                pathToLeafWithUnderscore(head.right, valueQueue, currentDepth - 1, maxCount);
        }
        valueQueue.removeLast();
    }
}
