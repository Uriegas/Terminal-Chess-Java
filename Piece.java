import java.util.ArrayList;

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
        if( this.getCoordinate().equals(p.getCoordinate()) && this.getColor() == p.getColor())//Si tienen la misma coordenada
            return true;
        else
            return false;
    }

    public abstract ArrayList<Move> getMoves(Board b);

    public ArrayList<Move> getMovesFromDirections(ArrayList<Coordinate> directions, Board b){
        ArrayList<Move> m = new ArrayList<Move>();

        for(Coordinate direction : directions )
            if( !(this.moveInDirectionFromPos(direction, b).isEmpty()) )
                m.addAll(this.moveInDirectionFromPos(direction, b));
        return m;
    }

    public ArrayList<Move> moveInDirectionFromPos(Coordinate direction, Board b){
        ArrayList<Move> m = new ArrayList<Move>();
        Coordinate newPos = this.position;
        Piece attacked = null;
        do{
            newPos = newPos.add(direction);
            if(newPos.isInsideBoard()){
                if(b.obtenerPiezaCoordenadas(newPos) != null)
                    attacked = b.obtenerPiezaCoordenadas(newPos).deepCopy();
                else
                    attacked = null;
                if(attacked == null)
                    m.add(new Move(this, newPos, null));
                else
                    if(attacked.getColor() != this.getColor())
                        m.add(new Move(this, newPos, attacked));
                    else
                        break;
            }
        }while(newPos.isInsideBoard());
        return m;
    }

    //Just get move in the coordinate passed
    public Move getNextMove(Coordinate direction, Board b){
        Coordinate newPos = this.position;
        Piece attacked = null;

        newPos = newPos.add(direction);
        if(newPos.isInsideBoard()){
            if(b.obtenerPiezaCoordenadas(newPos) != null){
                attacked = b.obtenerPiezaCoordenadas(newPos).deepCopy();
            }
            else
                attacked = null;

            if(attacked == null)
                return new Move(this, newPos, null);
            else
                if(attacked.getColor() != this.getColor())
                    return new Move(this, newPos, attacked);
                else
                    return null;
        }
        return null;
    }
}
