package matrix.sudoku.solver;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by apple on 23/04/17.
 */
public class Main {
    public static void main(String[] args) {
        Character[][] board = new Character[9][9];
        board[0][0] = '5';
        board[0][1] = '3';
        board[0][4] = '7';
        board[1][0] = '6';
        board[1][3] = '1';
        board[1][4] = '9';
        board[1][5] = '5';
        board[2][1] = '9';
        board[2][2] = '8';
        board[2][7] = '6';
        board[3][0] = '8';
        board[3][4] = '6';
        board[3][8] = '3';
        board[4][0] = '4';
        board[4][3] = '8';
        board[4][5] = '3';
        board[4][8] = '1';
        board[5][0] = '7';
        board[5][4] = '2';
        board[5][8] = '6';
        board[6][1] = '6';
        board[6][6] = '2';
        board[6][7] = '8';
        board[7][3] = '4';
        board[7][4] = '1';
        board[7][5] = '9';
        board[7][8] = '5';
        board[8][4] = '8';
        board[8][7] = '7';
        board[8][8] = '9';
        solveSudoku(board);

    }
    public static void solveSudoku(Character[][] board) {

        Map<Integer, LinkedList<Character>> rowMap = new HashMap<>();
        Map<Integer, LinkedList<Character>> columnMap = new HashMap<>();
        Map<Integer, LinkedList<Character>> boxMap = new HashMap<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] != null) {
                    LinkedList<Character> rowList = new LinkedList<>();
                    LinkedList<Character> columnList = new LinkedList<>();
                    LinkedList<Character> boxList = new LinkedList<>();
                    if(rowMap.containsKey(i)) {
                        rowList = rowMap.get(i);

                    }
                    rowList.add(board[i][j]);
                    rowMap.put(i, rowList);
                    if(columnMap.containsKey(j)) {
                        columnList = columnMap.get(j);
                    }
                    columnList.add(board[i][j]);
                    columnMap.put(j, columnList);
                    if(i <= 2) {
                        if(j <= 2) {
                            if (boxMap.containsKey(0)) {
                                boxList = boxMap.get(0);
                            }
                            boxList.add(board[i][j]);
                            boxMap.put(0, boxList);
                        } else if(j <= 5) {
                            if (boxMap.containsKey(1)) {
                                boxList = boxMap.get(1);
                            }
                            boxList.add(board[i][j]);
                            boxMap.put(1, boxList);
                        } else {
                            if (boxMap.containsKey(2)) {
                                boxList = boxMap.get(2);
                            }
                            boxList.add(board[i][j]);
                            boxMap.put(2, boxList);
                        }
                    } else if(i <= 5) {
                        if(j <= 2) {
                            if (boxMap.containsKey(3)) {
                                boxList = boxMap.get(3);
                            }
                            boxList.add(board[i][j]);
                            boxMap.put(3, boxList);
                        } else if(j <= 5) {
                            if (boxMap.containsKey(4)) {
                                boxList = boxMap.get(4);
                            }
                            boxList.add(board[i][j]);
                            boxMap.put(4, boxList);
                        } else {
                            if (boxMap.containsKey(5)) {
                                boxList = boxMap.get(5);
                            }
                            boxList.add(board[i][j]);
                            boxMap.put(5, boxList);
                        }
                    } else {
                        if(j <= 2) {
                            if (boxMap.containsKey(6)) {
                                boxList = boxMap.get(6);
                            }
                            boxList.add(board[i][j]);
                            boxMap.put(6, boxList);
                        } else if(j <= 5) {
                            if (boxMap.containsKey(7)) {
                                boxList = boxMap.get(7);
                            }
                            boxList.add(board[i][j]);
                            boxMap.put(7, boxList);
                        } else {
                            if (boxMap.containsKey(8)) {
                                boxList = boxMap.get(8);
                            }
                            boxList.add(board[i][j]);
                            boxMap.put(8, boxList);
                        }
                    }

                }
            }
        }

       /* System.out.println(rowMap);
        System.out.println(columnMap);
        System.out.println(boxMap);*/

        solveSudokuHelper(board, rowMap, columnMap, boxMap);

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.println(board[i][j]);
            }
        }
    }

    private static boolean solveSudokuHelper(Character[][] board, Map<Integer, LinkedList<Character>> rowMap, Map<Integer, LinkedList<Character>> columnMap, Map<Integer, LinkedList<Character>> boxMap) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == null) {
                    for(int m = 1; m <= 9; m++) {
//                        System.out.println(i + " " + j + " " + m);
                        Character k = (char) (m + '0');
                        LinkedList<Character> rowList = new LinkedList<>();
                        LinkedList<Character> columnList = new LinkedList<>();
                        LinkedList<Character> boxList = new LinkedList<>();

                        int boxNumber = 0;
                        if (i <= 2) {
                            if (j <= 2) {
                                boxNumber = 0;
                            } else if (j <= 5) {
                                boxNumber = 1;
                            } else {
                                boxNumber = 2;
                            }
                        } else if (i <= 5) {
                            if (j <= 2) {
                                boxNumber = 3;
                            } else if (j <= 5) {
                                boxNumber = 4;
                            } else {
                                boxNumber = 5;
                            }
                        } else {
                            if (j <= 2) {
                                boxNumber = 6;
                            } else if (j <= 5) {
                                boxNumber = 7;
                            } else {
                                boxNumber = 8;
                            }
                        }

                        if((!rowMap.containsKey(i) || !rowMap.get(i).contains(k)) && (!columnMap.containsKey(j) || !columnMap.get(j).contains(k))
                                && (!boxMap.containsKey(boxNumber) || !boxMap.get(boxNumber).contains(k))) {
                            rowList = rowMap.containsKey(i) ? rowMap.get(i) : new LinkedList<>();
                            columnList = columnMap.containsKey(j) ? columnMap.get(j) : new LinkedList<>();
                            boxList = boxMap.containsKey(boxNumber) ? boxMap.get(boxNumber) : new LinkedList<>();
                            board[i][j] = k;
                            boxList.add(k);
                            rowList.add(k);
                            columnList.add(k);
                            boxMap.put(boxNumber, boxList);
                            rowMap.put(i, rowList);
                            columnMap.put(j, columnList);
                            if (solveSudokuHelper(board, rowMap, columnMap, boxMap)) {
                                return true;
                            } else {
                                rowList.remove(k);
                                columnList.remove(k);
                                boxList.remove(k);
                                boxMap.put(boxNumber, boxList);
                                rowMap.put(i, rowList);
                                columnMap.put(j, columnList);
                                board[i][j] = null;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
