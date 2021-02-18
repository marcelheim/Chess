import Enums.Color;
import Utility.Move;
import Utility.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestPieces {
    @Test
    public void testMoves(){
        Cell[][] board = new Cell[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                board[x][y] = new Cell(new Position(x, y));
            }
        }
        Piece testPawnWhite = new Pawn(Color.White, new Position('b', 2), true);
        Piece testPawnBlack = new Pawn(Color.Black, new Position('d', 7), true);
        testPawnWhite.createMoves(board);
        List<Move> moveList = testPawnWhite.getMoveList();
    }
}
