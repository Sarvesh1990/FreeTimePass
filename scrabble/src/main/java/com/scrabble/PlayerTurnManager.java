package com.scrabble;

import java.util.Scanner;

/**
 * Created by sarvesh on 20/12/17.
 */
public class PlayerTurnManager {
    public static void takeTurn(Player player) {
        PlayerMove move = decidePlayerMove(player);
        player.takeTurn(move);
    }

    private static PlayerMove decidePlayerMove(Player player) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Hello " + player.getName() + ". Its your turn. Please decide what you want to do. Type c -> place char, s -> swap, p -> pass");
        String move =  reader.nextLine();

        switch (move) {
            case "c" : return PlayerMove.PLACE_CHAR;
            case "s" : return PlayerMove.SWAP;
            case "p" : return PlayerMove.PASS;
            default :
                System.out.println("Wrong move. Play again");
                return decidePlayerMove(player);
        }
    }
}
