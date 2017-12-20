package com.scrabble;

import java.util.ArrayList;

/**
 * Created by sarvesh on 20/12/17.
 */
public class Player {
    private final String name;
    private int currentPoints;
    private ArrayList<Letters> currentLetters;

    private ScrabbleBag scrabbleBag;
    private ScrabbleBoard scrabbleBoard;

    public Player(String name, ScrabbleBoard scrabbleBoard, ScrabbleBag scrabbleBag) {
        this.name = name;
        this.scrabbleBag = scrabbleBag;
        this.scrabbleBoard = scrabbleBoard;
        currentPoints = 0;
        currentLetters = new ArrayList<Letters>();
    }

    public void takeTurn(PlayerMove move) {
        if(move == PlayerMove.PLACE_CHAR) {
            currentPoints += 1;
            getLettersFromBag(7);
        } else if (move == PlayerMove.SWAP) {
            currentLetters = scrabbleBag.swapLettersFromBag(currentLetters);
        } else {
        }

        for(int i = 0; i < currentLetters.size(); i++) {
            System.out.print(currentLetters.get(i).getValue() + " " + scrabbleBag.getSize() + " ");
        }
        System.out.println();
    }

    public void getLettersFromBag(int count) {
        currentLetters = scrabbleBag.getLettersFromBag(7);
        for(int i = 0; i < currentLetters.size(); i++) {
            System.out.print(currentLetters.get(i).getValue() + " " + scrabbleBag.getSize() + " ");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public ArrayList<Letters> getCurrentLetters() {
        return currentLetters;
    }
}
