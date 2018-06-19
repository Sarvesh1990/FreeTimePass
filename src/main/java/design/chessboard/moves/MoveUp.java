package design.chessboard.moves;

import design.chessboard.ChessBoard;
import design.chessboard.Player;
import design.chessboard.chess.pieces.ChessPiece;

public class MoveUp implements Move {
    @Override
    public boolean checkValidMove(ChessBoard chessBoard, int[] startIndex, int[] endIndex, Player player) {
        ChessPiece chessPiece = chessBoard.getChessPiecePosition()[startIndex[0]][startIndex[1]];

        //Check if chess piece exist in start index
        //Check if chess piece is of player calling move
        //Check if endIndex has no chessPiece or chessPiece of other player
        //Do BFS from startIndex to endIndex
        //For soldier only one step.

        if(chessPiece == null || chessPiece.getPlayer() != player) {
            return false;
        }

        ChessPiece chessPieceEnd = chessBoard.getChessPiecePosition()[endIndex[0]][endIndex[1]];

        if(chessPieceEnd != null && chessPieceEnd.getPlayer() == player) {
            return false;
        }

        if(chessPieceEnd != null && chessPieceEnd.getPlayer() != player && chessPiece.getName().equals("Soldier")) {
            return false;
        }

        return findPath(chessBoard, startIndex, endIndex);

    }

    public boolean findPath(ChessBoard chessBoard, int[] startIndex, int[] endIndex) {
        ChessPiece chessPiece = chessBoard.getChessPiecePosition()[startIndex[0]][startIndex[1]];

        if(chessPiece.getName().equals("Soldier")) {
            return endIndex[1] == startIndex[1] + 1;
        } else {
            //Traverse
        }
        return true;
    }
}
