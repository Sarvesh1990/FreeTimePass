package graph.surrounded.regions;

/**
 * Created by sarvesh on 19/4/17.
 */
public class Solution {
    public static void main(String[] args) {

    }
    public static void solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O') {
                board[i][0] = '1';
                dfs(board, i, 0);
            }
            if(board[i][board[0].length - 1] == 'O') {
                board[i][board[0].length - 1] = '1';
                dfs(board, i, board[0].length - 1);
            }
        }

        for(int i = 0; i < board[0].length; i++) {
            if(board[0][i] == 'O') {
                board[0][i] = '1';
                dfs(board, 0, i);
            }

            if(board[board.length - 1][i] == 'O') {
                board[board.length - 1][i] = '1';
                dfs(board, board.length - 1, i);
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '1') {
                    board[i][j] = '0';
                }
            }
        }

    }

    public static void dfs(char[][] board, int i, int j) {
        if(i > 0) {
            if(board[i - 1][j] == 'O') {
                board[i - 1][j] = '1';
                dfs (board, i - 1, j);
            }
        }
        if(i < board.length - 1) {
            if(board[i + 1][j] == 'O') {
                board[i + 1][j] = '1';
                dfs (board, i + 1, j);
            }
        }
        if(j > 0) {
            if(board[i][j - 1] == 'O') {
                board[i][j  - 1] = '1';
                dfs (board, i, j - 1);
            }
        }
        if(j < board[0].length - 1) {
            if(board[i][j + 1] == 'O') {
                board[i][j  + 1] = '1';
                dfs (board, i, j + 1);
            }
        }
    }
}
