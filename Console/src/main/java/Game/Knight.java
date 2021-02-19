package Game;

import Enums.Color;
import Enums.MoveType;
import Enums.PieceType;
import Utility.Move;
import Utility.Position;

public class Knight extends Piece {
    public Knight(Color color, Position position, Boolean availability) {
        super(color, position, availability, PieceType.Knight);
    }

    @Override
    public void createMoves(Cell[][] board) {
        int x = getPosition().getX();
        int y = getPosition().getY();
        int newX = x + 1;
        int newY = y + 2;
        if(newX < 8 && newY < 8){
            if(board[newX][newY].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(newX, newY)));
            else if(board[newX][newY].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(newX, newY)));
        }
        newX = x + 2;
        newY = y + 1;
        if(newX < 8 && newY < 8){
            if(board[newX][newY].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(newX, newY)));
            else if(board[newX][newY].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(newX, newY)));
        }
        newX = x + 2;
        newY = y - 1;
        if(newX < 8 && newY >= 0){
            if(board[newX][newY].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(newX, newY)));
            else if(board[newX][newY].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(newX, newY)));
        }
        newX = x + 1;
        newY = y - 2;
        if(newX < 8 && newY >= 0){
            if(board[newX][newY].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(newX, newY)));
            else if(board[newX][newY].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(newX, newY)));
        }
        newX = x - 1;
        newY = y - 2;
        if(newX >= 0 && newY >= 0){
            if(board[newX][newY].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(newX, newY)));
            else if(board[newX][newY].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(newX, newY)));
        }
        newX = x - 2;
        newY = y - 1;
        if(newX >= 0 && newY >= 0){
            if(board[newX][newY].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(newX, newY)));
            else if(board[newX][newY].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(newX, newY)));
        }
        newX = x - 2;
        newY = y + 1;
        if(newX >= 0 && newY < 8){
            if(board[newX][newY].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(newX, newY)));
            else if(board[newX][newY].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(newX, newY)));
        }
        newX = x - 1;
        newY = y + 2;
        if(newX >= 0 && newY < 8){
            if(board[newX][newY].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(newX, newY)));
            else if(board[newX][newY].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(newX, newY)));
        }
    }

    @Override
    public String getAsciiRepresentation() {
        return this.getColor() ==  Color.White ? "wN" : "bN";
    }

    @Override
    public String getUnicodeRepresentation() {
        return null;
    }
}
