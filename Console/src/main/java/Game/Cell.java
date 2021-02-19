package Game;

import Enums.Color;
import Utility.Position;

public class Cell {
    private Piece piece;
    private Color inDangerBy;
    private Position position;

    public Cell(){}

    public Cell(Position position) {
        this.position = position;
    }

    public Piece getPiece() {
        return piece;
    }

    public Color isInDanger() {
        return inDangerBy;
    }

    public Position getPosition() {
        return position;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setInDanger(Color inDanger) {
        this.inDangerBy = inDanger;
    }
}
