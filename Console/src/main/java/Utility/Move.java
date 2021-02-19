package Utility;

import Enums.MoveType;

public class Move {
    MoveType type;
    Position position;
    Position capturePosition;

    public Move(MoveType type, Position position) {
        this.type = type;
        this.position = position;
        this.capturePosition = null;
    }

    public Move(MoveType type, Position position, Position capturePosition) {
        this.type = type;
        this.position = position;
        this.capturePosition = capturePosition;
    }

    public MoveType getType() {
        return type;
    }

    public Position getPosition() {
        return position;
    }
}
