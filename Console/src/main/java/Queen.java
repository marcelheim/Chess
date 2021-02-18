import Enums.Color;
import Enums.MoveType;
import Enums.PieceType;
import Utility.Move;
import Utility.Position;

public class Queen extends Piece{
    public Queen(Color color, Position position, Boolean availability) {
        super(color, position, availability, PieceType.Queen);
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
                getMoveList().add(new Move(MoveType.Capture, new Position(x + offset, y + offset)));
                end = true;
            }
            offset++;
        }
        offset = 1;
        end = false;
        while (!end && y - offset >= 0 && x + offset < 8) {
            if(board[x + offset][y - offset].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(x + offset, y - offset)));
            else {
                getMoveList().add(new Move(MoveType.Capture, new Position(x + offset, y - offset)));
                end = true;
            }
            offset++;
        }
        offset = 1;
        end = false;
        while (!end && y - offset >= 0 && x - offset >= 0) {
            if(board[x - offset][y - offset].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(x - offset, y - offset)));
            else {
                getMoveList().add(new Move(MoveType.Capture, new Position(x - offset, y - offset)));
                end = true;
            }
            offset++;
        }
        offset = 1;
        end = false;
        while (!end && y + offset < 8 && x - offset >= 0) {
            if(board[x - offset][y + offset].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(x - offset, y + offset)));
            else {
                getMoveList().add(new Move(MoveType.Capture, new Position(x - offset, y + offset)));
                end = true;
            }
            offset++;
        }
        offset = 1;
        end = false;
        while (!end && y + offset < 8) {
            if(board[x][y + offset].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(x, y + offset)));
            else {
                getMoveList().add(new Move(MoveType.Capture, new Position(x, y + offset)));
                end = true;
            }
            offset++;
        }
        offset = 1;
        end = false;
        while (!end && y - offset >= 0) {
            if(board[x][y - offset].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(x, y - offset)));
            else {
                getMoveList().add(new Move(MoveType.Capture, new Position(x, y - offset)));
                end = true;
            }
            offset++;
        }
        offset = 1;
        end = false;
        while (!end && x + offset < 8) {
            if(board[x + offset][y].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(x + offset, y)));
            else {
                getMoveList().add(new Move(MoveType.Capture, new Position(x + offset, y)));
                end = true;
            }
            offset++;
        }
        offset = 1;
        end = false;
        while (!end && x - offset >= 0) {
            if(board[x - offset][y].getPiece() == null) getMoveList().add(new Move(MoveType.Move, new Position(x - offset, y)));
            else {
                getMoveList().add(new Move(MoveType.Capture, new Position(x - offset, y)));
                end = true;
            }
            offset++;
        }
    }

    @Override
    public String getAsciiRepresentation() {
        return this.getColor() ==  Color.White ? "wQ" : "bQ";
    }

    @Override
    public String getUnicodeRepresentation() {
        return null;
    }
}
