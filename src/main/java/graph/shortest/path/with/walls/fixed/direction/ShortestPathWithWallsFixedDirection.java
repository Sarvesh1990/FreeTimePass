package graph.shortest.path.with.walls.fixed.direction;

/*
Given a matrix where edge can be a wall. Find shortest path from source to destination. Given a direction, you have to move
in that direction only for shortest path unless you hit a wall.
 */

//0 -> top
//1 -> right
//2 -> bottom
//3 -> left
public class ShortestPathWithWallsFixedDirection {
    public static void main(String[] args) {
        int[][][] matrix = new int[2][2][4];
        matrix[0][0][1] = 1;

        ShortestPathWithWallsFixedDirection sp = new ShortestPathWithWallsFixedDirection();
        System.out.println(sp.findShortestPath(matrix, new int[] {0, 0}, new int[] {1, 1}));
    }

    public int findShortestPath(int[][][] matrix, int[] source, int[] destination) {
        int[][][] minSteps = new int[matrix.length][matrix[0].length][4];

        for(int i = 0; i < minSteps.length; i++) {
            for(int j = 0; j < minSteps[0].length; j++) {
                for(int k = 0; k < 4; k++) {
                    minSteps[i][j][k] = -2;
                }
            }
        }

        int minTop, minRight, minBottom, minLeft;


        minTop = findShortestPathHelper(matrix, source, destination, 0, minSteps);
        minRight = findShortestPathHelper(matrix, source, destination, 1, minSteps);
        minBottom = findShortestPathHelper(matrix, source, destination, 2, minSteps);
        minLeft = findShortestPathHelper(matrix, source, destination, 3, minSteps);

        System.out.println(minTop + " " + minRight + " " + minBottom + " " + minLeft);
        return Math.min(Math.min(minTop, minRight), Math.min(minBottom, minLeft));
    }

    public int findShortestPathHelper(int[][][] matrix, int[] source, int[] destination, int direction, int[][][] minSteps) {
        if(source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }

        if(direction == 0) {
            int minTop = 0;
            if (source[0] > 0 && matrix[source[0]][source[1]][0] != 1) {
                if (minSteps[source[0] - 1][source[1]][0] == -2) {
                    minTop = findShortestPathHelper(matrix, new int[]{source[0] - 1, source[1]}, destination, 0, minSteps);
                } else {
                    minTop = minSteps[source[0] - 1][source[1]][0] != -1 ? minSteps[source[0] - 1][source[1]][0] + 1 : -1;
                }
            } else if (source[1] < matrix[0].length - 1 && matrix[source[0]][source[1]][1] != 1) {
                if (minSteps[source[0]][source[1] + 1][1] == -2) {
                    minTop = findShortestPathHelper(matrix, new int[]{source[0], source[1] + 1}, destination, 1, minSteps);
                } else {
                    minTop = minSteps[source[0]][source[1] + 1][1] != -1 ? minSteps[source[0]][source[1] + 1][1] + 1 : -1;
                }
            } else if (source[0] < matrix.length - 1 && matrix[source[0]][source[1]][2] != 1) {
                if (minSteps[source[0] + 1][source[1]][2] == -2) {
                    minTop = findShortestPathHelper(matrix, new int[]{source[0] + 1, source[1]}, destination, 2, minSteps);
                } else {
                    minTop = minSteps[source[0] + 1][source[1]][2] != -1 ? minSteps[source[0] + 1][source[1]][2] + 1 : -1;
                }
            } else {
                minTop = -1;
            }
            minSteps[source[0]][source[1]][0] = minTop;
            return minTop;
        }

        if(direction == 1) {
            int minRight = 0;
            if (source[1] < matrix[0].length - 1 && matrix[source[0]][source[1]][1] != 1) {
                if (minSteps[source[0]][source[1] + 1][1] == -2) {
                    minRight = findShortestPathHelper(matrix, new int[]{source[0], source[1] + 1}, destination, 1, minSteps);
                } else {
                    minRight = minSteps[source[0]][source[1] + 1][1] != -1 ? minSteps[source[0]][source[1] + 1][1] + 1 : -1;
                }
            } else if (source[0] < matrix.length - 1 && matrix[source[0]][source[1]][2] != 1) {
                if (minSteps[source[0] + 1][source[1]][2] == -2) {
                    minRight = findShortestPathHelper(matrix, new int[]{source[0] + 1, source[1]}, destination, 2, minSteps);
                } else {
                    minRight = minSteps[source[0] + 1][source[1]][2] != -1 ? minSteps[source[0] + 1][source[1]][2] + 1 : -1;
                }
            } else if (source[1] > 0 && matrix[source[0]][source[1]][3] != 1) {
                if (minSteps[source[0]][source[1] - 1][3] == -2) {
                    minRight = findShortestPathHelper(matrix, new int[]{source[0], source[1] - 1}, destination, 3, minSteps);
                } else {
                    minRight = minSteps[source[0]][source[1] - 1][3] != -1 ? minSteps[source[0]][source[1] - 1][3] + 1 : -1;
                }
            } else {
                minRight = -1;
            }
            minSteps[source[0]][source[1]][1] = minRight;
            return minRight;
        }

        if(direction == 2) {
            int minBottom = 0;
            if (source[0] < matrix.length - 1 && matrix[source[0]][source[1]][2] != 1) {
                if (minSteps[source[0] + 1][source[1]][2] == -2) {
                    minBottom = findShortestPathHelper(matrix, new int[]{source[0] + 1, source[1]}, destination, 2, minSteps);
                } else {
                    minBottom = minSteps[source[0] + 1][source[1]][2] != -1 ? minSteps[source[0] + 1][source[1]][2] + 1 : -1;
                }
            } else if (source[1] > 0 && matrix[source[0]][source[1]][3] != 1) {
                if (minSteps[source[0]][source[1] - 1][3] == -2) {
                    minBottom = findShortestPathHelper(matrix, new int[]{source[0], source[1] - 1}, destination, 3, minSteps);
                } else {
                    minBottom = minSteps[source[0]][source[1] - 1][3] != -1 ? minSteps[source[0]][source[1] - 1][3] + 1 : -1;
                }
            } else if (source[0] > 0 && matrix[source[0]][source[1]][0] != 1) {
                if (minSteps[source[0] - 1][source[1]][0] == -2) {
                    minBottom = findShortestPathHelper(matrix, new int[]{source[0] - 1, source[1]}, destination, 0, minSteps);
                } else {
                    minBottom = minSteps[source[0] - 1][source[1]][0] != -1 ? minSteps[source[0] - 1][source[1]][0] + 1 : -1;
                }
            } else {
                minBottom = -1;
            }
            minSteps[source[0]][source[1]][2] = minBottom;
            return minBottom;
        }

        if(direction == 3) {
            int minLeft = 0;
            if (source[1] > 0 && matrix[source[0]][source[1]][3] != 1) {
                if (minSteps[source[0]][source[1] - 1][3] == -2) {
                    minLeft = findShortestPathHelper(matrix, new int[]{source[0], source[1] - 1}, destination, 3, minSteps);
                } else {
                    minLeft = minSteps[source[0]][source[1] - 1][3] != -1 ? minSteps[source[0]][source[1] - 1][3] + 1 : -1;
                }
            } else if (source[0] > 0 && matrix[source[0]][source[1]][0] != 1) {
                if (minSteps[source[0] - 1][source[1]][0] == -2) {
                    minLeft = findShortestPathHelper(matrix, new int[]{source[0] - 1, source[1]}, destination, 0, minSteps);
                } else {
                    minLeft = minSteps[source[0] - 1][source[1]][0] != -1 ? minSteps[source[0] - 1][source[1]][0] + 1 : -1;
                }
            } else if (source[1] < matrix[0].length - 1 && matrix[source[0]][source[1]][1] != 1) {
                if (minSteps[source[0]][source[1] + 1][1] == -2) {
                    minLeft = findShortestPathHelper(matrix, new int[]{source[0], source[1] + 1}, destination, 1, minSteps);
                } else {
                    minLeft = minSteps[source[0]][source[1] + 1][1] != -1 ? minSteps[source[0]][source[1] + 1][1] + 1 : -1;
                }
            } else {
                minLeft = -1;
            }
            minSteps[source[0]][source[1]][3] = minLeft;
            return minLeft;
        }

        return -1;
    }
}
