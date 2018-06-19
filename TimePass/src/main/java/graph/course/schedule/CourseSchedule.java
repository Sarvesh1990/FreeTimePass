package graph.course.schedule;


import java.util.LinkedList;
import java.util.List;

/*
Topological sort with cycling.
Given number of course to finish and a dependency matrix, find if he can finish all the course.
Use topological sort. Same like dfs. The only difference is we mark visted false in the end so that it can serve as dependency for other
vertex.
Keep another visitedMatrix to avoid running for vertex which are already visited.
 */
public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int numCourses = 3;
        int[][] courseDependency = new int[numCourses][numCourses];
        courseDependency[0][0] = 1;
        courseDependency[0][1] = 0;
        courseDependency[1][0] = 1;
        courseDependency[1][1] = 2;
        courseDependency[2][0] = 0;
        courseDependency[2][1] = 2;

        System.out.println(cs.canFinish(numCourses, courseDependency));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] visitedNode = new boolean[numCourses];

        for(int m = 0; m < numCourses; m++) {
            visited[m] = false;
            visitedNode[m] = false;
        }

        for(int i = 0; i < numCourses; i++) {
            if(!visitedNode[i]) {
                List<Integer> list = new LinkedList<>();
                for(int j = 0; j < prerequisites.length; j++) {
                    if(prerequisites[j][0] == i) {
                        if(!topologicalSort(i, visited, prerequisites, visitedNode, list)) {
                            return false;
                        }
                        break;
                    }
                }
                System.out.println(list);
            }
        }
        return true;
    }

    public boolean topologicalSort(int index, boolean[] visited, int[][] prerequisites, boolean[] visitedNode, List<Integer> list) {
        visited[index] = true;
        visitedNode[index] = true;
        for(int i = 0; i < prerequisites.length; i++) {
            if(prerequisites[i][0] == index) {
                if(visited[prerequisites[i][1]]) {
                    return false;
                } else {
                    if(!topologicalSort(prerequisites[i][1], visited, prerequisites, visitedNode, list)) {
                        return false;
                    }
                }
            }
        }
        list.add(index);
        visited[index] = false;
        return true;
    }
}
