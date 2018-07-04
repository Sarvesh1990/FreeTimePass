package graph.adjacency.list;

import java.util.LinkedList;

/**
 * Created by apple on 27/02/17.
 */
public class GraphBFSDFSAdjacencyList {
    public static LinkedList<Integer>[] graph;
    private static boolean[] bfsVisited;
    private static boolean[] dfsVisited;
    private static boolean[] recStack;


    public GraphBFSDFSAdjacencyList(int size) {
        this.graph = new LinkedList[size];
        this.bfsVisited = new boolean[graph.length];
        this.dfsVisited = new boolean[graph.length];
        this.recStack = new boolean[graph.length];

        for(int i = 0; i < size; i++) {
            graph[i] = new LinkedList<>();
        }
        for(int i = 0; i < graph.length; i++) {
            bfsVisited[i] = false;
        }
        for(int i = 0; i < graph.length; i++) {
            dfsVisited[i] = false;
        }
        for(int i = 0; i < graph.length; i++) {
            recStack[i] = false;
        }
    }

    public static void addVertex(int from, int to) {
        graph[from].add(to);
    }

    public static boolean checkIfVertexExist(int from, int to) {
        return graph[from].contains(to);
    }

    public static void bfs(int startNode) {
        bfsVisited[startNode] = true;

        for(int i = 0; i < graph[startNode].size(); i++) {
            if(!bfsVisited[graph[startNode].get(i)]) {
                System.out.println(graph[startNode].get(i));
            }
        }

        for(int i = 0; i < graph[startNode].size(); i++) {
            if (!bfsVisited[graph[startNode].get(i)]) {
                bfs(graph[startNode].get(i));
            }
        }
    }

    public static void bfsQueue(int startNode) {
        LinkedList<Integer> bfsQueue = new LinkedList<>();
        bfsVisited[startNode] = true;
        bfsQueue.add(startNode);

        while(!bfsQueue.isEmpty()) {
            int number = bfsQueue.removeFirst();
            System.out.println(number);
            for(int i = 0; i < graph[number].size(); i++) {
                if(!bfsVisited[graph[number].get(i)]) {
                    bfsVisited[graph[number].get(i)] = true;
                    bfsQueue.add(graph[number].get(i));
                }
            }
        }
    }

    public static void dfs(int startNode) {
        dfsVisited[startNode] = true;
        System.out.println(startNode);
        for(int i = 0; i < graph[startNode].size(); i++) {
            if(!dfsVisited[graph[startNode].get(i)]) {
                dfs(graph[startNode].get(i));
            }
        }
    }

    public static boolean dfsLoop(int startNode) {
        dfsVisited[startNode] = true;
        recStack[startNode] = true;
        System.out.println(startNode);
        for(int i = 0; i < graph[startNode].size(); i++) {
            if (!dfsVisited[graph[startNode].get(i)] && dfsLoop(graph[startNode].get(i))) {
                return true;
            } else if (recStack[graph[startNode].get(i)]){
                return true;
            }
        }
        recStack[startNode] = false;
        return false;
    }

    public static void main(String[] args) {
        GraphBFSDFSAdjacencyList graph = new GraphBFSDFSAdjacencyList(6);
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
