package graph.words;

import java.util.ArrayList;

/**
 * Created by apple on 28/02/17.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> dictionary = new ArrayList<String>() {
            {
                add("GEEKS");
                add("FOR");
                add("QUIZ");
                add("GO");
            }};
        Character[][] boggle = new Character[3][3];
        boggle[0][0] = 'G';
        boggle[0][1] = 'I';
        boggle[0][2] = 'Z';
        boggle[1][0] = 'U';
        boggle[1][1] = 'E';
        boggle[1][2] = 'K';
        boggle[2][0] = 'Q';
        boggle[2][1] = 'S';
        boggle[2][2] = 'E';

        boolean[][] visited = new boolean[3][3];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                visited[i][j] = false;
            }
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                findWords(boggle, visited, i, j, 3, 3, "", dictionary);
            }
        }
    }

    private static void findWords(Character[][] boggle, boolean[][] visited, int i, int j, int m, int n, String str, ArrayList<String> dict) {
        visited[i][j] = true;
        str = str + boggle[i][j];
        if(dict.contains(str)) {
            System.out.println(str);
        }
        for(int row = i - 1; (row <= i + 1 && row < m); row++) {
            for(int column = j - 1; (column <= j  + 1 && column < n); column++) {
                if(row >= 0 && column >= 0 && !visited[row][column]) {
                    findWords(boggle, visited, row, column, 3, 3, str, dict);
                }
            }
        }
        visited[i][j] = false;
        str.substring(0, str.length() - 1);
    }
}
