package Utility;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position(char file, int rank){
        setRank(rank);
        setFile(file);
    }

    public boolean equals(Position position){
        return (position.getX() == x && position.getY() == y);
    }

    public void set(Position position){
        this.x = position.getX();
        this.y = position.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRank(int file){
        this.y = file - 1;
    }

    public void setFile(char rank){
        this.x = (int) rank - 97;
    }

    public int getRank(){
        return this.x + 1;
    }

    public char getFile(){
        return (char) (this.y + 97);
    }
}
