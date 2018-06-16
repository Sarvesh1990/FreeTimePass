package bst;

public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int x) { val = x; }

      public static void print (TreeNode node) {
          if(node == null) {
              return;
          }
          System.out.println(node.val);
          print(node.left);
          print(node.right);
      }
}
