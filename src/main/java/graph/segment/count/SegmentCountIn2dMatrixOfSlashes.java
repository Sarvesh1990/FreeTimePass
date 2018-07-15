package graph.segment.count;

public class SegmentCountIn2dMatrixOfSlashes {
    public static void main(String[] args) {
        char[][] matrix = new char[2][2];
        matrix[0][0] = '/';
        matrix[0][1] = '/';
        matrix[1][0] = '/';
        matrix[1][1] = '\\';

        System.out.println(new SegmentCountIn2dMatrixOfSlashes().segmentCount(matrix));

    }

    public int segmentCount(char[][] m) {
        int len = m[0].length;
        boolean[] upperHalf = new boolean[m.length * len];
        boolean[] lowerHalf = new boolean[m.length * len];

        int count = 0;
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < len; j++) {
                if(!upperHalf[i*len + j]) {
                    count++;
                    dfs(m, upperHalf, lowerHalf, i, j, 0);
                }
                if(!lowerHalf[i*len + j]) {
                    count++;
                    dfs(m, upperHalf, lowerHalf, i, j, 1);
                }
            }
        }
        return count;
    }
    //upper:0, lower:1, left:2, right:3
    private void dfs(char[][] m, boolean[] upperHalf, boolean[] lowerHalf, int x, int y, int position) {
        if(x < 0 || x == m.length || y == m[0].length || y < 0) {
            return;
        }
        if((position == 2 && m[x][y] == '\\') || (position == 3 && m[x][y] == '/')) position = 1;
        if((position == 2 && m[x][y] == '/') || position == 3 && m[x][y] == '\\') position = 0;
        int id = x * m[0].length + y;
        if((position == 0 && upperHalf[id]) || (position == 1 && lowerHalf[id])) { //if visited
            return;
        }
        if(position == 0) upperHalf[id] = true;
        else lowerHalf[id] = true;
        if(position == 0 && m[x][y] == '\\') {
            dfs(m, upperHalf, lowerHalf, x, y + 1, 2); //go right
            dfs(m, upperHalf, lowerHalf, x - 1, y, 1); //go up
        }
        if(position == 0 && m[x][y] == '/') {
            dfs(m, upperHalf, lowerHalf, x, y - 1, 3); //go left
            dfs(m, upperHalf, lowerHalf, x - 1, y, 1); //go up
        }
        if(position == 1 && m[x][y] == '\\') {
            dfs(m, upperHalf, lowerHalf, x, y - 1, 3); //go left
            dfs(m, upperHalf, lowerHalf, x + 1, y, 0); //go down
        }
        if(position == 1 && m[x][y] == '/') {
            dfs(m, upperHalf, lowerHalf, x, y + 1, 2); //go right
            dfs(m, upperHalf, lowerHalf, x + 1, y, 0); //go down
        }
    }
}
