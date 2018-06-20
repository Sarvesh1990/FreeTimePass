package graph.minimum.height.vertex;

import java.util.*;

/*
Start with each leaf (edge == 1). Keep moving till you have 2 vertex left in total vertex.
Keep creating new leaves. If vertex near to leaf has two edges one leaf and one another, remove its leaf edge and add this to new leaves list,
otherwise wait for other vertex to come to it and get itself removed
 */
public class MinimumHeightVertexOptimised {
    public static void main(String[] args) {
        MinimumHeightVertexOptimised mo = new MinimumHeightVertexOptimised();
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        System.out.println(mo.findMinHeightTrees(6, edges));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
