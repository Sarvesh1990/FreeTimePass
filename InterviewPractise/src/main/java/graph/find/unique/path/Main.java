package graph.find.unique.path;

import com.sun.tools.corba.se.idl.InterfaceGen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by apple on 16/03/17.
 */
public class Main {
    public static void main(String[] args) {
        int numIntersections = 5;
        int[][] routes = new int[numIntersections][numIntersections];

        for(int i = 0; i < numIntersections; i++) {
            for(int j = 0; j < numIntersections; j++) {
                routes[i][j] = 0;
            }
        }

        routes[0][1] = 1;
        routes[0][2] = 1;
        routes[2][1] = 1;
        routes[2][4] = 1;
        routes[4][0] = 1;
        routes[3][4] = 1;


        boolean[] bfsVisited = new boolean[numIntersections];

        for (int i = 0; i < numIntersections; i++) {
            bfsVisited[i] = false;
        }

        boolean allTraversed = false;

        while (!allTraversed) {
            for(int i = 0; i < numIntersections; i++) {
                if(!bfsVisited[i]) {
                    System.out.println("Traversing for " + i);
                    boolean[] bfsVisitedTemp = new boolean[numIntersections];
                    for (int j = 0; j < numIntersections; j++) {
                        bfsVisitedTemp[j] = false;
                    }
                    printPaths(routes, bfsVisitedTemp, i, numIntersections);
                    for(int k = 0; k < numIntersections; k++) {
                        if (!bfsVisited[k] && bfsVisitedTemp[k]) {
                            bfsVisited[k] = true;
                        }
                    }
                    allTraversed = false;
                    break;
                }
                allTraversed = true;
            }
        }
    }

    public static void printPaths(int[][] graph, boolean[] bfsVisited, int startNode, int numVertices) {
        LinkedList<Integer> bfsQueue = new LinkedList<>();
        Map<Integer, Integer> pathMap = new HashMap<>();
        Integer[] parent = new Integer[numVertices];

        for(int i = 0; i < numVertices; i++) {
            parent[i] = -1;
        }

        bfsVisited[startNode] = true;
        bfsQueue.add(startNode);

        while(!bfsQueue.isEmpty()) {
            int number = bfsQueue.removeFirst();
            for(int j = 0; j < numVertices; j++) {
                if (!(graph[number][j] == 0) && !bfsVisited[j]) {
                    bfsVisited[j] = true;
                    bfsQueue.add(j);
                    pathMap.put(j, number);
                } else if(!(graph[number][j] == 0) && j != startNode) {
                    ArrayList<Integer> keysToBeRemoved = new ArrayList<>()
;                    for(Integer key : pathMap.keySet()) {
                        if(pathMap.get(key) == j) {
                            keysToBeRemoved.add(key);
                        }
                    }
                    for(int i = 0; i < keysToBeRemoved.size(); i++) {
                        pathMap.remove(keysToBeRemoved.get(i));
                    }
                    if(pathMap.containsKey(j)) {
                        pathMap.remove(j);
                        System.out.println("Removing " + j);
                    }
                }
            }
        }
        System.out.println(pathMap);
    }
}
