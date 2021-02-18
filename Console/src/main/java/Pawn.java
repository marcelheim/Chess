import Enums.Color;
import Enums.MoveType;
import Enums.PieceType;
import Utility.Move;
import Utility.Position;


public class Pawn extends Piece{
    public Pawn(Color color, Position position, Boolean availability) {
        super(color, position, availability, PieceType.Pawn);
    }

    //ToDo: implement en passant and promotion
    @Override
    public void createMoves(Cell[][] board) {
        getMoveList().clear();
        if(getColor() == Color.White){
            if(getPosition().getY() == 7) return;
            if(getPosition().getY() < 7
                    && board[getPosition().getX()][getPosition().getY() + 1].getPiece() == null) {
                getMoveList().add(new Move(MoveType.Move, new Position(getPosition().getX(), getPosition().getY() + 1)));
                if(getPosition().getY() < 6
                        && board[getPosition().getX()][getPosition().getY() + 2].getPiece() == null)
                    getMoveList().add(new Move(MoveType.Move, new Position(getPosition().getX(), getPosition().getY() + 2)));
            }
            if(getPosition().getY() < 7 && getPosition().getX() < 7
                    && board[getPosition().getX() + 1][getPosition().getY() + 1].getPiece() != null
                    && board[getPosition().getX() + 1][getPosition().getY() + 1].getPiece().getColor() != getColor())
                getMoveList().add(new Move(MoveType.Capture, new Position(getPosition().getX() + 1, getPosition().getY() + 1)));
            if(getPosition().getY() < 7 && getPosition().getX() > 0
                    && board[getPosition().getX() - 1][getPosition().getY() + 1].getPiece() != null
                    && board[getPosition().getX() - 1][getPosition().getY() + 1].getPiece().getColor() != getColor())
                getMoveList().add(new Move(MoveType.Capture, new Position(getPosition().getX() - 1, getPosition().getY() + 1)));
        }
        else {
            if(getPosition().getY() == 0) return;
            if(getPosition().getY() > 0
                    && board[getPosition().getX()][getPosition().getY() - 1].getPiece() == null) {
                getMoveList().add(new Move(MoveType.Move, new Position(getPosition().getX(), getPosition().getY() - 1)));
                if(getPosition().getY() > 1
                        && board[getPosition().getX()][getPosition().getY() - 2].getPiece() == null)
                    getMoveList().add(new Move(MoveType.Move, new Position(getPosition().getX(), getPosition().getY() - 2)));
            }
            if(getPosition().getY() > 0 && getPosition().getX() < 7
                    && board[getPosition().getX() + 1][getPosition().getY() - 1].getPiece() != null
                    && board[getPosition().getX() + 1][getPosition().getY() - 1].getPiece().getColor() != getColor())
                getMoveList().add(new Move(MoveType.Capture, new Position(getPosition().getX() + 1, getPosition().getY() - 1)));
            if(getPosition().getY() > 0 && getPosition().getX() > 0
                    && board[getPosition().getX() - 1][getPosition().getY() - 1].getPiece() != null
                    && board[getPosition().getX() - 1][getPosition().getY() - 1].getPiece().getColor() != getColor())
                getMoveList().add(new Move(MoveType.Capture, new Position(getPosition().getX() - 1, getPosition().getY() - 1)));
        }
    }

    @Override
    public String getAsciiRepresentation() {
        return this.getColor() ==  Color.White ? "wP" : "bP";
    }

    @Override
    public String getUnicodeRepresentation() {
        return this.getColor() ==  Color.White ? "♙" : "♟";
    }
}
