package com.scrabble;

/**
 * Created by sarvesh on 20/12/17.
 */
public class Main {
    public static void main(String[] args) {
        ScrabbleGame scrabbleGame = new ScrabbleGame(3);
        scrabbleGame.registerPlayers();
        scrabbleGame.startGame();
    }
}
