package graph.assign.direction.to.undirected.edges.keep.graph.acyclic;

/*
Given a graph with both directed and undirected edges. It is given that the directed edges don’t form cycle.
How to assign directions to undirected edges so that the graph (with all directed edges) remains acyclic even after the assignment?

1) Consider the subgraph with directed edges only and find topological sorting of the subgraph.
2) Use above topological sorting to assign directions to undirected edges. For every undirected edge (u, v), assign it direction
from u to v if u comes before v in topological sorting, else assign it direction from v to u.
 */
public class AssignEdgesToUndirectedEdgesWhileKeepingGraphAcyclic {
}
