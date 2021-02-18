package Utility;

import Enums.MoveType;

public class Move {
    MoveType type;
    Position position;

    public Move(MoveType type, Position position) {
        this.type = type;
        this.position = position;
    }

    public MoveType getType() {
        return type;
    }

    public Position getPosition() {
        return position;
    }
}
