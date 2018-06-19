package design.chessboard.moves;

import design.chessboard.ChessBoard;
import design.chessboard.Player;

public interface Move {
    public boolean checkValidMove(ChessBoard chessBoard, int[] startIndex, int[] endIndex, Player player);
}
