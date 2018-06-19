package graph.course.schedule;


import java.util.ArrayList;
import java.util.List;

/*
Topological sort with cycling.
Given number of course to finish and a dependency matrix, find if he can finish all the course.
Use topological sort. Same like dfs. The only difference is we mark visted false in the end so that it can serve as dependency for other
vertex.
Keep another visitedMatrix to avoid running for vertex which are already visited.
Pass list to get order too. Add in list if visitedNode is not true (node visited for first time). Also in the last add all node whose
visitedNode is false to list. No edge was there.
 */
public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int numCourses = 3;
        int[][] courseDependency = new int[1][2];
        courseDependency[0][0] = 1;
        courseDependency[0][1] = 0;
        /*courseDependency[1][0] = 1;
        courseDependency[1][1] = 2;
        courseDependency[2][0] = 0;
        courseDependency[2][1] = 2;*/

        int[] order = cs.canFinish(numCourses, courseDependency);
        for(int i = 0; i < numCourses; i++) {
            System.out.println(order[i]);
        }

    }

    public int[] canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] visitedNode = new boolean[numCourses];

        for(int m = 0; m < numCourses; m++) {
            visited[m] = false;
            visitedNode[m] = false;
        }

        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if(!visitedNode[i]) {
                for(int j = 0; j < prerequisites.length; j++) {
                    if (prerequisites[j][0] == i) {
                        if (!topologicalSort(i, visited, prerequisites, visitedNode, list)) {
                            return new int[0];
                        }
                        break;
                    }
                }
            }
        }


        int[] order = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!visitedNode[i]) {
                list.add(i);
            }
        }

        for(int i = 0; i < numCourses; i++) {
            order[i] = list.get(i);
        }

        return order;
    }

    public boolean topologicalSort(int index, boolean[] visited, int[][] prerequisites, boolean[] visitedNode, List<Integer> list) {
        visited[index] = true;
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

        if(!visitedNode[index]) {
            visitedNode[index] = true;
            list.add(index);
        }

        visited[index] = false;
        return true;
    }
}
