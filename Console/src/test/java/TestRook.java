import Enums.Color;
import Enums.PieceType;
import Game.Cell;
import Game.Pawn;
import Game.Piece;
import Game.Rook;
import Utility.Move;
import Utility.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestRook {
    Piece testRook;
    Position testRookPosition;
    Cell[][] board;

    TestRook(){
        board = new Cell[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                board[x][y] = new Cell(new Position(x, y));
            }
        }
        testRookPosition = new Position('c', 3);
        testRook = new Rook(Color.White, testRookPosition, true);
        testRook.createMoves(board);
        addPieceToBoard(testRook);
        addPieceToBoard(new Pawn(Color.Black, new Position('c', 7), true));
        addPieceToBoard(new Pawn(Color.White, new Position('g', 3), true));
    }

    public void addPieceToBoard(Piece piece){
        board[piece.getPosition().getX()][piece.getPosition().getY()].setPiece(piece);
    }

    public boolean testMove(Position position, List<Move> moveList, Piece pieceReference, Cell[][] boardReference){
        for (Move move: moveList) {
            if (move.getPosition().equals(position)) {
                if (boardReference[position.getX()][position.getY()].getPiece() == null) return true;
                else if(boardReference[position.getX()][position.getY()].getPiece().getColor() != pieceReference.getColor()) return true;
            }
        }
        return false;
    }

    @Test
    public void testConstruction(){
        Assertions.assertAll(
                () -> Assertions.assertTrue(testRook.getPosition().equals(testRookPosition)),
                () -> Assertions.assertTrue(testRook.getAvailability()),
                () -> Assertions.assertSame(testRook.getColor(), Color.White),
                () -> Assertions.assertSame(testRook.getType(), PieceType.Rook)
        );
    }

    @Test
    public void testMoveGeneration(){
        List<Move> moveList = testRook.getMoveList();
        Assertions.assertAll(
                () -> Assertions.assertTrue(testMove(new Position('c', 7), moveList, testRook, board)),
                () -> Assertions.assertTrue(testMove(new Position('c', 4), moveList, testRook, board)),
                () -> Assertions.assertTrue(testMove(new Position('d', 3), moveList, testRook, board)),
                () -> Assertions.assertFalse(testMove(new Position('g', 3), moveList, testRook, board)),
                () -> Assertions.assertTrue(testMove(new Position('c', 2), moveList, testRook, board)),
                () -> Assertions.assertTrue(testMove(new Position('c', 1), moveList, testRook, board)),
                () -> Assertions.assertFalse(testMove(new Position('c', 3), moveList, testRook, board)),
                () -> Assertions.assertTrue(testMove(new Position('a', 3), moveList, testRook, board))
        );
    }
}
