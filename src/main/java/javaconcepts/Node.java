package javaconcepts;

/**
 * Created by apple on 30/03/17.
 */
public class Node {
    public int key;
    public int value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        String foo = "key " + key + " val " + value;
        return foo;
    }
}
