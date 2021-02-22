
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

    //Añado el get color para cuestiones de implementación de color de figuras en posiciones (Creo que se usará)
    public Color getColor(){
        return this.getColor();
    }

    //Imprime información de la pieza
    //Ya se que se ve horrible
    public String toString(){
        return  "Color: " + (this.color == Color.WHITE ? "WHITE" : "BLACK") + '\n' +
                "Live: " + (this.alive == Alive.LIVE ? "LIVE" : "DEAD") + '\n' +
                "Position: " + (this.position.toString()) + '\n';
    }

}
