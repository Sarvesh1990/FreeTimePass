package stack.next.greater.element;

/**
 * Created by apple on 18/02/17.
 */
public class Main {
    public static void main (String[] args) {
        int[] array = {23, 12, 14, 3, 6, 8, 2, 3, 5, 18};

        Stack list = new Stack(array[0]);

        for(int i = 1; i < array.length; i++) {
            Node poppedNode = list.pop();

            while(poppedNode != null && poppedNode.getValue() < array[i]) {
                System.out.println(poppedNode.getValue() + " -> " + array[i]);
                poppedNode = list.pop();
            }

            list.push(poppedNode);
            list.push(new Node(array[i]));
        }

        list.printList();
    }
}
