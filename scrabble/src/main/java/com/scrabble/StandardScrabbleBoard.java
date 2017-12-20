package com.scrabble;

/**
 * Created by sarvesh on 20/12/17.
 */
public class StandardScrabbleBoard implements ScrabbleBoard {
    private char[][] board = new char[15][15] ;
    private Points[][] boardPoints = new Points[15][15];

    public StandardScrabbleBoard() {
        //Init all board points
        boardPoints[1][1] = Points.DOUBLE_CHAR;
    }
}
