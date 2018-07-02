package graph.all.topological.sorts;

/*
Initialize all vertices as unvisited.
Now choose vertex which is unvisited and has zero indegree and decrease indegree of all those vertices by 1 (corresponding to removing edges) now add this vertex to result and call the recursive function again and backtrack.
After returning from function reset values of visited, result and indegree for enumeration of other possibilities.
 */
