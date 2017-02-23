package bst;

/**
 * Created by apple on 20/02/17.
 */
public class Main {
    public static void main(String[] args) {
        BST bst = new BST(10);
        bst.insert(9, bst.head);
        bst.insert(12, bst.head);
        bst.insert(1, bst.head);
        bst.insert(2, bst.head);
        bst.insert(4, bst.head);
        bst.insert(20, bst.head);
        bst.insert(19, bst.head);
        bst.insert(10, bst.head);
        bst.print(bst.head);
        System.out.println(lca(bst.head, 19, 11));
    }

    public static int lca(Node head, int first, int second) {
        if(head.value == first || head.value == second) {
            return head.value;
        } else if ((head.value < first && head.value > second) || (head.value > first && head.value < second)) {
            return head.value;
        } else if (head.value > first) {
            return lca(head.left, first, second);
        } else {
            return lca(head.right, first, second);
        }
    }
}
