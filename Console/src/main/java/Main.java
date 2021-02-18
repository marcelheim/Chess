import Utility.Position;

public class Main {
    public static void main(String[] args){
        Game game = new Game();
        game.init();
        game.print();
        game.selectPiece(new Position('g', 1));
        game.print();
        game.move(new Position('g', 1), new Position('h', 3));
        game.print();
    }
}
