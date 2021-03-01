/*
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

public abstract class Piece extends Coordinate{
    private char figure; //Ver DISPLAY_LOOKUP
    private String piece_type;//Reina, caballito, peon ...
    private Coordinate position;
    private Color color;

    //Lo deje por compatibilidad con las demas piezas
    public Piece(Color color, Coordinate position){
        this.color = color;
        this.position = position;
    }

    //Clase mas abstracta, maneja la figura y el nombre de la pieza
    public Piece(char figure, String piece, Color color, Coordinate position){
        this.figure = figure;
        this.piece_type = piece;
        this.color = color;
        this.position = position;
    }

    //Copy Constructor
    public Piece(Piece p){
        this(p.figure, p.piece_type, p.color, new Coordinate(p.position));
    }

    public abstract Piece deepCopy();

    public void setPosition(Coordinate other){
        this.position.setPosition(other);
    }

    public Coordinate getCoordinate(){
        return this.position;
    }

    public Color getColor(){
        return this.color;
    }

    public void setFigure(char f){
        this.figure = f;
    }

    public void setFigureToLetter(){
        this.figure = piece_type.charAt(0);
    }

    public char getFigure(){
        return this.figure;
    }

    public String getPiece_Type(){
        return this.piece_type;
    }

    //Imprime información de la pieza
    public String toString(){
        return  "Name: " + this.getPiece_Type() + '\n' + 
                "Figure: " + String.valueOf(this.getFigure()) + '\n' + 
                "Color: " + (this.color == Color.WHITE ? "WHITE" : "BLACK") + '\n' +
                "Position: " + this.position.toString() + '\n';
    }
    public void setFigureToFigure(){}

    public boolean isEqual(Piece p){
        if( this.getCoordinate().equals(p.getCoordinate()) )//Si tienen la misma coordenada
            return true;
        else
            return false;
    }
}
