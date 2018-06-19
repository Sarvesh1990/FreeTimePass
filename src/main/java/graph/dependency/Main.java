package graph.dependency;

/**
 * Created by apple on 23/03/17.
 */
public class Main {
    public static void main(String[] args) {
        int numVertices = 7;
        int[][] dependencyMatrix = new int[numVertices][numVertices];
        dependencyMatrix[0][1] = 1;
        dependencyMatrix[0][2] = 1;
        dependencyMatrix[1][3] = 1;
        dependencyMatrix[2][3] = 1;
        dependencyMatrix[2][4] = 1;
        dependencyMatrix[3][4] = 1;
        dependencyMatrix[6][3] = 1;
        dependencyMatrix[5][6] = 1;

        boolean[] dfsVisited = new boolean[numVertices];

        for(int i = 0; i < numVertices; i++) {
            if(!dfsVisited[i]) {
                printDependencyReverse(dependencyMatrix, dfsVisited, i, numVertices);
            }
        }
    }

    public static void printDependencyReverse(int[][] graph, boolean[] dfsVisited, int startNode, int numVertices) {
        dfsVisited[startNode] = true;
        int i = startNode;
        for(int j = 0; j < numVertices; j++) {
            if (!(graph[i][j] == 0) && !dfsVisited[j]) {
                printDependencyReverse(graph, dfsVisited, j, numVertices   );
            }
        }
        System.out.println(startNode);
    }
}
