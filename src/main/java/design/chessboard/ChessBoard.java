package design.chessboard;

import design.chessboard.chess.pieces.ChessPiece;

public class ChessBoard {
    ChessPiece[][] chessPiecePosition;

    public ChessBoard() {
        chessPiecePosition = new ChessPiece[8][8];
        init();
    }

    private void init() {

    }

    public ChessPiece[][] getChessPiecePosition() {
        return chessPiecePosition;
    }
}
