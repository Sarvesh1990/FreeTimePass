package graph.shortest.path.with.one.change;

import java.util.*;

public class ShortesPathWithOneChange {
    public static void main(String[] args) {
        /*ShortesPathWithOneChange ss = new ShortesPathWithOneChange();
        int[][] pathMatrix = new int[3][3];
        pathMatrix[0][0] = 0;
        pathMatrix[0][1] = 0;
        pathMatrix[0][2] = 1;
        pathMatrix[1][0] = 1;
        pathMatrix[1][1] = 1;
        pathMatrix[1][2] = 0;
        pathMatrix[2][0] = 0;
        pathMatrix[2][1] = 1;
        pathMatrix[2][2] = 0;

        List<int[]> paths = ss.findShortestPathWithOneChange(pathMatrix, new int[] {0, 0}, new int[] {1, 1});
        if(paths != null) {
            for (int[] path : paths) {
                System.out.println(path[0] + " " + path[1]);
            }
        } else {
            System.out.println("Path could not be found");
        }*/

        int h;
        String key = "abc";
        System.out.println((key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16));
        System.out.println(5 & 3);
    }




    //1 If visited without conversion
    //2 If visited after conversion
    //0 Not visited
    //3 visited with both
    private List<int[]> findShortestPathWithOneChange(int[][] pathMatrix, int[] start, int[] end) {
        int[][] passingStatus = new int[pathMatrix.length][pathMatrix[0].length];
        LinkedList<int[]> pathList = new LinkedList<>();

        if(findShortestPath(pathMatrix, start, end, passingStatus, pathList, false)) {
            return pathList;
        } else {
            return null;
        }

    }


    //0 ->
    //Converted ->
    //Not visited -> Set passingStatus -> 2, Try
    //Visited without conversion -> Set passing status 3
    //return false

    //Not converted
    //Not visited -> Set passing status -> 1 -> try
    //visited with conversion -> set status 3 -> try
    //else return false

    //1
    //Converted :
    //Not visited -> Set passingStatus -> 2 return false
    //Visited without conversion -> Set passing status 3 -> return false
    //return false
    
    //Visited with conversion || not visited -> set path matrix to 3, try, 
    // else return false
    
    
    private boolean findShortestPath(int[][] pathMatrix, int[] start, int[] end, int[][] passingStatus, LinkedList<int[]> pathList, boolean converted) {
        pathList.add(start);
        if(start[0] == end[0] && start[1] == end[1]) {
            return true;
        }
        
        if(start[0] != 0) {
            if(checkForNearEdge(pathMatrix, start[0] - 1, start[1], end, passingStatus, pathList, converted)) {
                return true;
            }
        }
        if(start[0] != pathMatrix.length - 1) {
            if(checkForNearEdge(pathMatrix, start[0] + 1, start[1], end, passingStatus, pathList, converted)) {
                return true;
            }
        }
        if(start[1] != 0) {
            if(checkForNearEdge(pathMatrix, start[0], start[1] - 1, end, passingStatus, pathList, converted)) {
                return true;
            }
        }
        if(start[1] != pathMatrix[0].length - 1) {
            if(checkForNearEdge(pathMatrix, start[0], start[1] + 1, end, passingStatus, pathList, converted)) {
                return true;
            }
        }
        
        pathList.removeLast();
        return false;
    }
    
    private boolean checkForNearEdge(int[][] pathMatrix, int i, int j, int[] end, int[][] passingStatus, LinkedList<int[]> pathList, boolean converted) {
        if(pathMatrix[i][j] == 0) {
            if(converted) {
                if(passingStatus[i][j] == 0) {
                    passingStatus[i][j] = 2;
                    boolean shortestPathExist = findShortestPath(pathMatrix, new int[] {i, j}, end, passingStatus, pathList, converted);
                    if(shortestPathExist) {
                        return true;
                    }
                } else if (passingStatus[i][j] == 1) {
                    passingStatus[i][j] = 3;
                }
            } else {
                if(passingStatus[i][j] == 0) {
                    passingStatus[i][j] = 1;
                    boolean shortestPathExist = findShortestPath(pathMatrix, new int[] {i, j}, end, passingStatus, pathList, converted);
                    if(shortestPathExist) {
                        return true;
                    }
                } else if (passingStatus[i][j] == 2) {
                    passingStatus[i][j] = 3;
                    boolean shortestPathExist = findShortestPath(pathMatrix, new int[] {i, j}, end, passingStatus, pathList, converted);
                    if(shortestPathExist) {
                        return true;
                    }
                }
            }
        } else {
            if(converted) {
                if(passingStatus[i][j] == 0) {
                    passingStatus[i][j] = 2;
                } else if (passingStatus[i][j] == 1) {
                    passingStatus[i][j] = 3;
                }
            } else {
                if (passingStatus[i][j] == 0 || passingStatus[i][j] == 2) {
                    passingStatus[i][j] = 3;
                    boolean shortestPathExist = findShortestPath(pathMatrix, new int[]{i, j}, end, passingStatus, pathList, !converted);
                    if (shortestPathExist) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
