import Enums.Color;
import Enums.MoveType;
import Utility.Move;
import Utility.Position;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Color player = Color.White;
    Cell[][] board = new Cell[8][8];
    int halfTurnCounter = 0;
    String[][][] printMatrix = new String[8][8][3];
    boolean check;
    boolean checkMate;
    Position selectedPiecePosition;
    List<Move> selectedPieceMoveList = new ArrayList<>();

    public Game() {}

    public void gameLoop(){

    }

    public boolean selectPiece(Position piecePosition){
        Piece piece = board[piecePosition.getX()][piecePosition.getY()].getPiece();
        if(piece != null && piece.getColor() == player){
            selectedPiecePosition = piecePosition;
            piece.createMoves(board);
            selectedPieceMoveList = piece.getMoveList();
            return true;
        }
        return false;
    }

    public void move(Position piecePosition, Position destination){
        Piece piece = board[piecePosition.getX()][piecePosition.getY()].getPiece();
        MoveType moveType = piece.move(destination, board);
        if(moveType != MoveType.Undefined){
            board[piecePosition.getX()][piecePosition.getY()].setPiece(null);
            board[destination.getX()][destination.getY()].setPiece(piece);
            halfTurnCounter++;
            if(player == Color.White) player= Color.Black;
            else player = Color.White;
            selectedPieceMoveList = new ArrayList<>();
        }
    }

    public void init(){
        board = new Cell[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                board[x][y] = new Cell(new Position(x, y));
            }
        }
        board[0][0].setPiece(new Rook(Color.White, new Position(0, 0), true));
        board[1][0].setPiece(new Knight(Color.White, new Position(1, 0), true));
        board[2][0].setPiece(new Bishop(Color.White, new Position(2, 0), true));
        board[3][0].setPiece(new Queen(Color.White, new Position(3, 0), true));
        board[4][0].setPiece(new King(Color.White, new Position(4, 0), true));
        board[5][0].setPiece(new Bishop(Color.White, new Position(5, 0), true));
        board[6][0].setPiece(new Knight(Color.White, new Position(6, 0), true));
        board[7][0].setPiece(new Rook(Color.White, new Position(7, 0), true));
        for (int x = 0; x < 8; x++) {
            board[x][1].setPiece(new Pawn(Color.White, new Position(x, 1), true));
        }
        for (int x = 0; x < 8; x++) {
            board[x][6].setPiece(new Pawn(Color.Black, new Position(x, 6), true));
        }
        board[0][7].setPiece(new Rook(Color.Black, new Position(0, 7), true));
        board[1][7].setPiece(new Knight(Color.Black, new Position(1, 7), true));
        board[2][7].setPiece(new Bishop(Color.Black, new Position(2, 7), true));
        board[3][7].setPiece(new Queen(Color.Black, new Position(3, 7), true));
        board[4][7].setPiece(new King(Color.Black, new Position(4, 7), true));
        board[5][7].setPiece(new Bishop(Color.Black, new Position(5, 7), true));
        board[6][7].setPiece(new Knight(Color.Black, new Position(6, 7), true));
        board[7][7].setPiece(new Rook(Color.Black, new Position(7, 7), true));
    }

    public void print(){
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                printMatrix[x][y][0] = "[";
                printMatrix[x][y][2] = "]";
                if(board[x][y].getPiece() != null) printMatrix[x][y][1] = board[x][y].getPiece().getAsciiRepresentation();
                else printMatrix[x][y][1] = "  ";
            }
        }
        for (Move move: selectedPieceMoveList) {
            printMatrix[move.getPosition().getX()][move.getPosition().getY()][0] = move.getType() == MoveType.Move ? "(" : "{";
            printMatrix[move.getPosition().getX()][move.getPosition().getY()][2] = move.getType() == MoveType.Move ? ")" : "}";
        }
        System.out.println("Player: " + player);
        for (int y = 7; y >= 0; y--) {
            for (int x = 0; x < 8; x++) {
                System.out.print(printMatrix[x][y][0] + printMatrix[x][y][1] + printMatrix[x][y][2]);
            }
            System.out.println();
        }
    }
}
