package graph.word.exist;

/**
 * Created by apple on 06/04/17.
 */
public class Main {
    public static void main(String[] args) {
        int row = 3;
        int column = 4;
        char[][] board = new char[row][column];

        board[0][0] = 'A';
        board[0][1] = 'B';
        board[0][2] = 'C';
        board[0][3] = 'E';
        board[1][0] = 'S';
        board[1][1] = 'F';
        board[1][2] = 'E';
        board[1][3] = 'S';
        board[2][0] = 'A';
        board[2][1] = 'D';
        board[2][2] = 'E';
        board[2][3] = 'E';

        System.out.println(exist(board, "ABCESEEEFS"));
    }

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[row][column];
                    if(checkIfWordExist(board, i, j, visited, word, 0, row, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkIfWordExist(char[][] board, int i, int j, boolean[][] visited, String word, int pos, int row, int column) {
        if(pos == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        if(i < row - 1) {
            if(board[i + 1][j] == word.charAt(pos + 1) && !visited[i + 1][j]) {
                if(checkIfWordExist(board, i + 1, j, visited, word, pos + 1, row, column)) {
                    return true;
                }
            }
        }
        if(i > 0) {
            if(board[i - 1][j] == word.charAt(pos + 1) && !visited[i - 1][j]) {
                if(checkIfWordExist(board, i - 1, j, visited, word, pos + 1, row, column)) {
                    return true;
                }
            }
        }
        if(j < column - 1) {
            if(board[i][j + 1] == word.charAt(pos + 1) && !visited[i][j + 1]) {
                if(checkIfWordExist(board, i, j + 1, visited, word, pos + 1, row, column)) {
                    return true;
                }
            }
        }
        if(j > 0) {
            if(board[i][j - 1] == word.charAt(pos + 1) && !visited[i][j - 1]) {
                if(checkIfWordExist(board, i, j - 1, visited, word, pos + 1, row, column)) {
                    return true;
                }
            }
        }
        visited[i][j] = false;
        return false;
    }
}
