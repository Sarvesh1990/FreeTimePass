package design.chessboard.chess.pieces;

import design.chessboard.ChessBoard;
import design.chessboard.Player;
import design.chessboard.moves.Move;
import design.chessboard.moves.MoveUp;

public class Soldier extends ChessPiece {
    public Soldier() {
        super();

        //TODO Move to enum
        name = "Soldier";
        allowedMoves.add(new MoveUp());
    }

    @Override
    public boolean move(ChessBoard board, int[] startPosition, int[] endPosition, Player player) {
        for(Move move : allowedMoves) {
            if(move.checkValidMove(board, startPosition, endPosition, player)) {
                return true;
            }
        }
        return false;
    }
}
