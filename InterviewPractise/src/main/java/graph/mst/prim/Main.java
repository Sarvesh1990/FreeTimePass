package graph.mst.prim;

import graph.mst.Edge;
import graph.mst.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by apple on 13/03/17.
 */
public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(4, 5);
        graph.insertEdge(0, 1, 10);
        graph.insertEdge(0, 2, 3);
        graph.insertEdge(0, 3, 2);
        graph.insertEdge(1, 3, 15);
        graph.insertEdge(2, 3, 4);

        findPrimMST(graph);
    }

    private static void findPrimMST(Graph graph) {
        Map<Integer, Edge> weight = new HashMap<>();

        for(int i = 0; i < graph.vertices; i++) {
            weight.put(i, null);
        }

        int i = 0;
        ArrayList<Integer> currentVertexList = new ArrayList<>();
        currentVertexList.add(0);
        int currentVertex = 0;

        while (i < graph.vertices) {
            if(i == 0) {
            } else {
                Edge minEdge = null;
                for(Integer key : weight.keySet()) {
                    if(weight.get(key) != null) {
                        if (minEdge == null) {
                            minEdge = weight.get(key);
                        } else {
                            if (minEdge.weight > weight.get(key).weight) {
                                minEdge = weight.get(key);
                            }
                        }
                    }
                }
                currentVertex = (!currentVertexList.contains(minEdge.src)) ? minEdge.src : minEdge.dest;
                currentVertexList.add(currentVertex);
                System.out.println(minEdge.src + "->" + minEdge.dest);
            }
            weight.remove(currentVertex);
            updateVertices(currentVertex, weight, graph);
            i++;
         }
    }

    private static void updateVertices(int currentVertex, Map<Integer, Edge> weight, Graph graph) {
        for(int i = 0; i < graph.edgesList.size(); i++) {
            Edge curentEdge = graph.edgesList.get(i);
            if(curentEdge.src == currentVertex || curentEdge.dest == currentVertex) {
                if(curentEdge.src == currentVertex) {
                    if(weight.containsKey(curentEdge.dest)) {
                        if (weight.get(curentEdge.dest) != null) {
                            if ((weight.get(curentEdge.dest).weight > curentEdge.weight)) {
                                weight.put(curentEdge.dest, curentEdge);
                            }
                        } else {
                            weight.put(curentEdge.dest, curentEdge);
                        }
                    }
                } else {
                    if(weight.containsKey(curentEdge.src)) {
                        if (weight.get(curentEdge.src) != null) {
                            if ((weight.get(curentEdge.src).weight > curentEdge.weight)) {
                                weight.put(curentEdge.src, curentEdge);
                            }
                        } else {
                            weight.put(curentEdge.src, curentEdge);
                        }
                    }
                }
            }
        }
    }


}
