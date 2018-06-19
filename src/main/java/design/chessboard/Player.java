package design.chessboard;

public class Player {
    public boolean takeTurn(ChessBoard chessBoard) {
        return move(chessBoard, new int[] {1, 2}, new int[] {3, 4});
    }

    public boolean move (ChessBoard chessBoard, int[] startPosition, int[] endPosition) {
        return chessBoard.getChessPiecePosition()[startPosition[0]][startPosition[1]].move(chessBoard, startPosition, endPosition, this);
    }
}
