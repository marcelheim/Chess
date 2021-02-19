import Game.Game;
import Utility.Position;

public class Main {
    public static void main(String[] args){
        Game game = new Game();
        game.init();
        game.print();
        game.selectPiece(new Position('g', 1));
        game.print();
        game.move(new Position('g', 1), new Position('f', 3));
        game.print();
        game.selectPiece(new Position('e', 7));
        game.print();
        game.move(new Position('e', 7), new Position('e', 5));
        game.print();
        game.selectPiece(new Position('f', 3));
        game.print();
        game.move(new Position('f', 3), new Position('e', 5));
        game.print();
    }
}
