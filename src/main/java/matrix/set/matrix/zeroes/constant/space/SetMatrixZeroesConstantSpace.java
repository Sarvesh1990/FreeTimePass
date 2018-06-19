package matrix.set.matrix.zeroes.constant.space;


/*
We need to do this in constant space.
First traverse first row and first column of matrix and decide if we need to set it zero.
Then traverse entire matrix and whichever row and column is zero, mark first row and first column corresponding to zero.
Then use first row and first column to decide which row and column to set zero entirely.
Then check boolean to decide if we need to set first row and column zero.
 */
public class SetMatrixZeroesConstantSpace {
    public static void main(String[] args) {
        SetMatrixZeroesConstantSpace sm = new SetMatrixZeroesConstantSpace();
        int[][] matrix = new int[3][4];
        matrix[0][0] = 0;
        matrix[0][1] = 1;
        matrix[0][2] = 2;
        matrix[0][3] = 0;
        matrix[1][0] = 3;
        matrix[1][1] = 4;
        matrix[1][2] = 5;
        matrix[1][3] = 2;
        matrix[2][0] = 1;
        matrix[2][1] = 3;
        matrix[2][2] = 1;
        matrix[2][3] = 5;

        int[][] matrixDone = new int[3][4];
        matrixDone = sm.setZeroes(matrix);

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.println(matrixDone[i][j]);
            }
        }

    }

    public int[][] setZeroes(int[][] matrix) {
        boolean setFirstRow = false;
        boolean setFirstColumn = false;

        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                setFirstColumn = true;
                break;
            }
        }

        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                setFirstRow = true;
                break;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(setFirstRow) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if(setFirstColumn) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        return matrix;

    }
}
