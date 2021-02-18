
/*Caracteres con figuritas *.*
DISPLAY_LOOKUP = {
    "R": '♜',
    "N": '♞',
    "B": '♝',
    "K": '♚',	
    "Q": '♛',
    "P": '♟',
    "p": '▲',
}
*/
enum Color{WHITE, BLACK};
enum Alive{LIVE, DEAD};

public abstract class Piece extends Coordinate{
    private Coordinate position;
    private Color color;
    private Alive alive;

    public Piece(Color color, Coordinate position){
        this.color = color;
        this.alive = Alive.LIVE;
        this.position = position;
    }

    public void setPosition(Coordinate other){
        position.setPosition(other);
    }

    public Coordinate getPosition(){
        return position;
    }

    public String toString(){
        return  (this.color == Color.WHITE ? "WHITE" : "BLACK") +
                ' ' + (this.alive == Alive.LIVE ? "LIVE" : "DEAD");
    }

}
