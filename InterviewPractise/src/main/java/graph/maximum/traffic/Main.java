package graph.maximum.traffic;

import java.util.LinkedList;

/**
 * Created by apple on 22/03/17.
 */

public class Main {
    public static void main(String[] args) {
        int cities = 9;
        int[][] pathMatrix = new int[cities][cities];
        int[] cityPopulation = new int[cities];

        cityPopulation[0] = 1;
        cityPopulation[1] = 2;
        cityPopulation[2] = 3;
        cityPopulation[3] = 4;
        cityPopulation[4] = 5;
        cityPopulation[5] = 7;
        cityPopulation[6] = 8;
        cityPopulation[7] = 15;
        cityPopulation[8] = 38;

        pathMatrix[0][4] = 1;
        pathMatrix[4][0] = 1;
        pathMatrix[1][4] = 1;
        pathMatrix[1][5] = 1;
        pathMatrix[1][7] = 1;
        pathMatrix[5][1] = 1;
        pathMatrix[5][6] = 1;
        pathMatrix[6][5] = 1;
        pathMatrix[6][8] = 1;
        pathMatrix[8][6] = 1;
        pathMatrix[7][1] = 1;
        pathMatrix[4][1] = 1;
        pathMatrix[2][4] = 1;
        pathMatrix[4][2] = 1;
        pathMatrix[3][4] = 1;
        pathMatrix[4][3] = 1;

        boolean[] visited = new boolean[cities];

        printMaxPath(pathMatrix, 0, visited, cities, cityPopulation);
    }

    private static void printMaxPath(int[][] pathMatrix, int startNode, boolean[] bfsVisited, int cityCount, int[] cityPopulation) {
        LinkedList<Integer> bfsQueue = new LinkedList<>();
        int[][] traffic = new int[cityCount][cityCount];

        bfsVisited[startNode] = true;
        bfsQueue.add(startNode);

        while(!bfsQueue.isEmpty()) {
            int number = bfsQueue.removeFirst();
            for(int i = 0; i < cityCount; i++) {
                if(pathMatrix[number][i] == 1) {
                    if(traffic[number][i] == 0) {
                        traffic[number][i] = getTraffic(pathMatrix, traffic, number, i, cityCount, cityPopulation);
                    }
                    if(!bfsVisited[i]) {
                        bfsVisited[i] = true;
                        bfsQueue.add(i);
                    }
                }
            }
        }

        for (int i = 0; i < cityCount; i++) {
            int max = 0;
            for(int j = 0 ; j < cityCount; j++) {
                if(max < traffic[j][i]) {
                    max = traffic[j][i];
                }
            }
            System.out.println((cityPopulation[i]) + " " + max) ;
        };
    }

    private static int getTraffic(int[][] pathMatrix, int[][] traffic, int from, int dest, int cityCount, int[] cityPop) {
        traffic[from][dest] = cityPop[from];
        for(int i = 0; i < cityCount; i++) {
            if(i != dest && pathMatrix[i][from] == 1) {
                traffic[from][dest] = traffic[from][dest] + (traffic[i][from] !=  0 ? traffic[i][from]
                        : getTraffic(pathMatrix, traffic, i, from, cityCount, cityPop));
            }
        }
        return traffic[from][dest];
    }


}
