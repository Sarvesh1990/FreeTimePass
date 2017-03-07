package graph.adjacency;

/**
 * Created by apple on 27/02/17.
 */
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addVertex(0, 1);
//        graph.addVertex(5, 0);
        graph.addVertex(2, 1);
        graph.addVertex(1, 5);
        graph.addVertex(2, 3);
        graph.addVertex(3, 4);
        graph.addVertex(3, 5);
        graph.addVertex(4, 0);
//        graph.addVertex(5, 4);

//        graph.bfsQueue(2);
//        graph.bfsQueue(2);
        System.out.println(graph.dfsLoop(2));
    }
}
