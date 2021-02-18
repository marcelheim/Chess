import Enums.Color;
import Enums.MoveType;
import Enums.PieceType;
import Utility.Move;
import Utility.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private Color color;
    private Position position;
    private Boolean availability;
    private PieceType type;
    private int moveCounter;
    private List<Move> moveList = new ArrayList<>();

    public Piece(Color color, Position position, Boolean availability, PieceType type) {
        this.color = color;
        this.position = position;
        this.availability = availability;
        this.type = type;
        this.moveCounter = 0;

    }


    public abstract void createMoves(Cell[][] board);

    //ToDo: Implement universal move function
    public MoveType move(Position position, Cell[][] board){
        createMoves(board);
        for (Move move: moveList) {
            if(move.getPosition().equals(position)) {
                this.moveCounter++;
                this.position.set(position);
                return move.getType();
            }
        }
        return MoveType.Undefined;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public abstract String getAsciiRepresentation();

    public abstract String getUnicodeRepresentation();

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public PieceType getType() {
        return type;
    }

    public int getMoveCounter() {
        return moveCounter;
    }

    public List<Move> getMoveList() {
        return moveList;
    }
}
