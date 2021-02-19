package Game;

import Enums.Color;
import Enums.MoveType;
import Enums.PieceType;
import Utility.Move;
import Utility.Position;

public class King extends Piece {
    public King(Color color, Position position, Boolean availability) {
        super(color, position, availability, PieceType.King);
    }

    //ToDo: implement castling
    @Override
    public void createMoves(Cell[][] board) {
        int x = getPosition().getX();
        int y = getPosition().getY();
        int newX = x + 1;
        int newY = y + 1;
        if(newX < 8 && newY < 8){
            if(board[newX][newY].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(newX, newY)));
            else if(board[newX][newY].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(newX, newY)));
        }
        newX = x + 1;
        if(newX < 8){
            if(board[newX][y].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(newX, y)));
            else if(board[newX][y].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(newX, y)));
        }
        newX = x + 1;
        newY = y - 1;
        if(newX < 8 && newY >= 0){
            if(board[newX][newY].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(newX, newY)));
            else if(board[newX][newY].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(newX, newY)));
        }
        newY = y - 1;
        if(newY >= 0){
            if(board[x][newY].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(x, newY)));
            else if(board[x][newY].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(x, newY)));
        }
        newX = x - 1;
        newY = y - 1;
        if(newX >=0 && newY >= 0){
            if(board[newX][newY].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(newX, newY)));
            else if(board[newX][newY].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(newX, newY)));
        }
        newX = x - 1;
        if(newX >= 0){
            if(board[newX][y].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(newX, y)));
            else if(board[newX][y].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(newX, y)));
        }
        newX = x - 1;
        newY = y + 1;
        if(newX >=0 && newY < 8){
            if(board[newX][newY].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(newX, newY)));
            else if(board[newX][newY].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(newX, newY)));
        }
        newY = y + 1;
        if(newY < 8){
            if(board[x][newY].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(x, newY)));
            else if(board[x][newY].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(x, newY)));
        }
    }


    @Override
    public String getAsciiRepresentation() {
        return this.getColor() ==  Color.White ? "wK" : "bK";
    }

    @Override
    public String getUnicodeRepresentation() {
        return null;
    }
}
