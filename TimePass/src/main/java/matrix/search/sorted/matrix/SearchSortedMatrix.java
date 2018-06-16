package matrix.search.sorted.matrix;

/*
Search for row Index using binary. Check boundary condition properly
Then search for column in that row.
 */

public class SearchSortedMatrix {
    public static void main(String[] args) {
        SearchSortedMatrix ss = new SearchSortedMatrix();

        int[][] matrix = new int[3][4];
        matrix[0][0] = 1;
        matrix[0][1] = 3;
        matrix[0][2] = 5;
        matrix[0][3] = 7;
        matrix[1][0] = 10;
        matrix[1][1] = 11;
        matrix[1][2] = 16;
        matrix[1][3] = 20;
        matrix[2][0] = 23;
        matrix[2][1] = 30;
        matrix[2][2] = 34;
        matrix[2][3] = 50;

        System.out.println(ss.searchMatrix(matrix, 3));

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = searchBinaryRow(matrix, target, 0, matrix.length - 1);
        if(rowIndex == -1) {
            return false;
        }
        return searchBinaryColumn(matrix[rowIndex], target, 0, matrix[0].length - 1);
    }

    public int searchBinaryRow(int[][] matrix, int target, int start, int end) {
        if(start > end) {
            return -1;
        }
        if(start == end) {
            return start;
        }

        int mid = start + (end - start)/2;

        if(matrix[mid][0] <= target &&  matrix[mid + 1][0] > target) {
            return mid;
        } else if (matrix[mid][0] > target) {
            return searchBinaryRow(matrix, target, start, mid - 1);
        } else {
            return searchBinaryRow(matrix, target, mid + 1, end);
        }
    }

    public boolean searchBinaryColumn(int[] matrixColumn, int target, int start, int end) {
        if(start > end) {
            return false;
        }
        if(start == end) {
            if(matrixColumn[start] == target) {
                return true;
            } else {
                return false;
            }
        }

        int mid = start + (end - start)/2;

        if(matrixColumn[mid] == target) {
            return true;
        } else if (matrixColumn[mid] > target) {
            return searchBinaryColumn(matrixColumn, target, start, mid - 1);
        } else {
            return searchBinaryColumn(matrixColumn, target, mid + 1, end);
        }
    }
}
