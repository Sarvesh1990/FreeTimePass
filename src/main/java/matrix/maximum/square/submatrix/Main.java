package matrix.maximum.square.submatrix;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        matrix[0][0] = 1;
        matrix[0][1] = 0;
        matrix[0][2] = 1;
        matrix[0][3] = 1;
        matrix[1][0] = 0;
        matrix[1][1] = 0;
        matrix[1][2] = 1;
        matrix[1][3] = 1;
        matrix[2][0] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 0;
        matrix[2][3] = 1;

        int[][][] sizeMatrix = findOneSize(matrix);

        int maxSquareSize = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(sizeMatrix[0][i][j]);
                if(matrix[i][j] == 1) {
                    int possibleMaxSquare = Math.min(sizeMatrix[0][i][j], sizeMatrix[3][i][j]);
                    int tempMaxSquare = possibleMaxSquare + 1;
                    for (int m = i + 1; m <= i + possibleMaxSquare; m++) {
                        if(matrix[m][j] == 0) {
                            tempMaxSquare = 0;
                            break;
                        } else if(sizeMatrix[0][m][j] + 1 < tempMaxSquare) {
                            tempMaxSquare = sizeMatrix[0][m][j] + 1;
                            System.out.println(i + " " + j + " " + m + " " + tempMaxSquare);
                        }
                    }
                    if (tempMaxSquare > maxSquareSize) {
                        maxSquareSize = tempMaxSquare;
                    }
                }
            }
        }
        System.out.println(maxSquareSize);
    }

    private static int[][][] findOneSize(int[][] matrix) {
        int[][][] sizeMatrix = new int[4][3][4];

        sizeMatrix[0] = findSizeMatrix(matrix, 0);
        sizeMatrix[1] = findSizeMatrix(matrix, 1);
        sizeMatrix[2] = findSizeMatrix(matrix, 2);
        sizeMatrix[3] = findSizeMatrix(matrix, 3);

        return sizeMatrix;
    }

    private static int[][] findSizeMatrix(int[][] matrix, int direction) {
        int[][] sizeMatrix = new int[3][4];
        if(direction == 0) {
            for(int j = 3; j >=0; j-- ) {
                for(int i = 0; i < 3; i++) {
                    if(j == 3) {
                        sizeMatrix[i][j] = 0;
                    } else {
                        sizeMatrix[i][j] = matrix[i][j+1] == 1 ? sizeMatrix[i][j+1] + 1 : 0;
                    }
                }
            }
        }
        if(direction == 1) {
            for(int j = 0; j < 4; j++ ) {
                for(int i = 0; i < 3; i++) {
                    if(j == 0) {
                        sizeMatrix[i][j] = 0;
                    } else {
                        sizeMatrix[i][j] = matrix[i][j-1] == 1 ? sizeMatrix[i][j-1] + 1 : 0;
                    }
                }
            }
        }
        if(direction == 2) {
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 4; j++ ) {
                    if(i == 0) {
                        sizeMatrix[i][j] = 0;
                    } else {
                        sizeMatrix[i][j] = matrix[i-1][j] == 1 ? sizeMatrix[i-1][j] + 1 : 0;
                    }
                }
            }
        }
        if(direction == 3) {
            for(int i = 2; i >= 0; i--) {
                for(int j = 0; j < 4; j++ ) {
                    if(i == 2) {
                        sizeMatrix[i][j] = 0;
                    } else {
                        sizeMatrix[i][j] = matrix[i+1][j] == 1 ? sizeMatrix[i+1][j] + 1 : 0;
                    }
                }
            }
        }

        return sizeMatrix;
    }
}
