package design.scrabble.src.main.java.com.scrabble;

import java.util.Scanner;

/**
 * Created by sarvesh on 20/12/17.
 */
public class ScrabbleGame {
    private final int countPlayers;
    private Player[] players;
    private int currentPlayerIndex;
    private ScrabbleBoard scrabbleBoard;
    private ScrabbleBag scrabbleBag;

    public ScrabbleGame(int countPlayers) {
        this.countPlayers = countPlayers;
        players = new Player[countPlayers];
        scrabbleBoard = new StandardScrabbleBoard();
        scrabbleBag = new ScrabbleBag(100);
    }

    public void startGame() {
        while(scrabbleBag.getSize() > 7) {
            PlayerTurnManager.takeTurn(players[currentPlayerIndex]);
            currentPlayerIndex = getNextPlayerIndex(currentPlayerIndex);
        }
        decideWinner();
    }

    private void decideWinner() {
        int maxPoints = 0;
        int winner = -1;
        for(int i = 0; i < countPlayers; i++) {
            if(players[i].getCurrentPoints() > maxPoints) {
                maxPoints = players[i].getCurrentPoints();
                winner = i;
            }
        }
        System.out.println(winner);
    }

    public int getNextPlayerIndex(int index) {
        return (index + 1) % countPlayers;
    }

    public void registerPlayers() {
        for(int i = 0; i < countPlayers; i++) {
            Player player = new Player(getPlayerNameInput(), scrabbleBoard, scrabbleBag);
            players[i] = player;
        }
        currentPlayerIndex = 0;
        assignInitialLetters();
    }

    private void assignInitialLetters() {
        for(int i = 0; i < players.length; i++) {
            players[i].getLettersFromBag(7);
        }
    }

    private String getPlayerNameInput() {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter player name : ");
        return reader.nextLine();
    }
}
