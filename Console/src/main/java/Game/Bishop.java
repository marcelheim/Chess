package Game;

import Enums.Color;
import Enums.MoveType;
import Enums.PieceType;
import Utility.Move;
import Utility.Position;

public class Bishop extends Piece {
    public Bishop(Color color, Position position, Boolean availability) {
        super(color, position, availability, PieceType.Bishop);
    }

    @Override
    public void createMoves(Cell[][] board) {
        int x = getPosition().getX();
        int y = getPosition().getY();
        int offset = 1;
        boolean end = false;
        while (!end && y + offset < 8 && x + offset < 8) {
            if(board[x + offset][y + offset].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(x + offset, y + offset)));
            else {
                if(board[x + offset][y + offset].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(x + offset, y + offset)));
                end = true;
            }
            offset++;
        }
        offset = 1;
        end = false;
        while (!end && y - offset >= 0 && x + offset < 8) {
            if(board[x + offset][y - offset].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(x + offset, y - offset)));
            else {
                if(board[x + offset][y - offset].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(x + offset, y - offset)));
                end = true;
            }
            offset++;
        }
        offset = 1;
        end = false;
        while (!end && y - offset >= 0 && x - offset >= 0) {
            if(board[x - offset][y - offset].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(x - offset, y - offset)));
            else {
                if(board[x - offset][y - offset].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(x - offset, y - offset)));
                end = true;
            }
            offset++;
        }
        offset = 1;
        end = false;
        while (!end && y + offset < 8 && x - offset >= 0) {
            if(board[x - offset][y + offset].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(x - offset, y + offset)));
            else {
                if(board[x - offset][y + offset].getPiece().getColor() != getColor()) getMoveList().add(new Move(MoveType.Capture, new Position(x - offset, y + offset)));
                end = true;
            }
            offset++;
        }
    }

    @Override
    public String getAsciiRepresentation() {
        return this.getColor() ==  Color.White ? "wB" : "bB";
    }

    @Override
    public String getUnicodeRepresentation() {
        return null;
    }
}
