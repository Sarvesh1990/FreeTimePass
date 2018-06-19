package design.chessboard.chess.pieces;

import design.chessboard.ChessBoard;
import design.chessboard.Player;
import design.chessboard.moves.Move;

import java.util.LinkedList;
import java.util.List;

public abstract class ChessPiece {
    protected String name;
    protected Player player;

    protected List<Move> allowedMoves;

    public ChessPiece () {
        allowedMoves = new LinkedList<>();
    }

    public abstract boolean move(ChessBoard board, int[] startPosition, int[] endPosition, Player player);


    public Player getPlayer () {
        return player;
    }

    public String getName() {
        return name;
    }
}
