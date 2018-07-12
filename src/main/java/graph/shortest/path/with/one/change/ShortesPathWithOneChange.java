package graph.shortest.path.with.one.change;

import java.util.LinkedList;
import java.util.List;

public class ShortesPathWithOneChange {
    public static void main(String[] args) {

    }


    //1 If visited without conversion
    //2 If visited after conversion
    //0 Not visited
    //3 visited with both
    private List<int[]> findShortestPathWithOneChange(int[][] pathMatrix, int[] start, int[] end) {
        int[][] passingStatus = new int[pathMatrix.length][pathMatrix[0].length];
        List<int[]> pathList = new LinkedList<>();

        if(findShortestPath(pathMatrix, start, end, passingStatus, pathList, false)) {
            return pathList;
        } else {
            return null;
        }

    }


    //0 ->
    //Converted ->
    //Not visited -> Set passingStatus -> 2, Try, else return false

    //Not converted
    //Not visited -> Set passing status -> 1
    //visited with conversion -> set status 3 -> try, else return false

    //1
    //Converted -> return false
    //Not converted && not visited -> set path matrix to 2, try, else return false
    private boolean findShortestPath(int[][] pathMatrix, int[] start, int[] end, int[][] passingStatus, List<int[]> pathList, boolean converted) {
        pathList.add(start);
        if(start[0] != 0) {
            if(pathMatrix[start[0] - 1][start[1]] == 0) {
                if(!converted) {

                }
            }
        }
    }
}
