package graph.matrix.best.meeting.point;

/**
 * Created by apple on 23/04/17.
 */

/*
People are standing 2D matrix. Find best meeting point.
Find for row and column. Check how many people are there in each row and
use that to decide best row. Distance = row * rowNumber.
First get distance if bestRow = topRow. Then keep coming down for each row.
Same ways for row.
 */

public class BestMeetingPointIn2D {
    public static void main(String[] args) {
        int[][] matrix = new int[3][5];

        matrix[0][0] = 1;
        matrix[2][2] = 1;
        matrix[1][1] = 1;
        matrix[1][2] = 1;

        findBestMeetingPoint(matrix);
    }

    private static void findBestMeetingPoint(int[][] matrix) {
        if(matrix == null) {
            return;
        }

        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    row[i]++;
                    column[j]++;
                }
            }
        }

        int bestRow = 0;
        int currentRowDistance = 0;
        int minimumRowDistance = 0;
        int totalRowUp = 0;
        int totalRowBottom = 0;

        for(int i = row.length - 1; i > 0; i--) {
            totalRowBottom = totalRowBottom + row[i];
            currentRowDistance = currentRowDistance + row[i]*i;
            minimumRowDistance = currentRowDistance;
        }

        int bestColumn = 0;
        int currentColumnDistance = 0;
        int minimumColumnDistance = 0;
        int totalColumnLeft = 0;
        int totalColumnRight = 0;

        for(int i = column.length - 1; i > 0; i--) {
            totalColumnRight = totalColumnRight + column[i];
            currentColumnDistance = currentColumnDistance + column[i] * i;
            minimumColumnDistance = currentColumnDistance;
        }

        System.out.println(currentColumnDistance + " " + currentRowDistance);

        for(int i = 1; i < row.length; i++) {
            totalRowUp = totalRowUp + row[i - 1];
            currentRowDistance = currentRowDistance + totalRowUp - totalRowBottom;
            totalRowBottom = totalRowBottom - row[i];
            if(currentRowDistance < minimumRowDistance) {
                minimumRowDistance = currentRowDistance;
                bestRow = i;
            }
        }

        for(int i = 1; i < column.length; i++) {
            totalColumnLeft = totalColumnLeft + column[i - 1];
            currentColumnDistance = currentColumnDistance + totalColumnLeft - totalColumnRight;
            totalColumnRight = totalColumnRight - column[i];
            if(currentColumnDistance < minimumColumnDistance) {
                minimumColumnDistance = currentColumnDistance;
                bestColumn = i;
            }
        }

        System.out.println(bestColumn + " " + bestRow);

    }
}
