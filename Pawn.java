
import java.util.*;

public class Pawn extends Piece{
    //private char figure = '♟';

    private List<Coordinate> mvm = new ArrayList<Coordinate>();

    public Pawn(Color color, Coordinate position){
        super('♟', "Pawn", color, position);
        this.initPossibleMoves();
    }
    
    //Copy Constructor
    public Pawn(Pawn p){
        this(p.getColor(), p.getCoordinate());
    }

    @Override
    public Pawn deepCopy(){
        return new Pawn(this);
    }

    private void initPossibleMoves(){
        if(super.getColor() == Color.WHITE){
            this.mvm.add(new Coordinate(0, 1));
        }else if(super.getColor() == Color.BLACK){
            this.mvm.add(new Coordinate(0, -1));
        }
    }

    public char getFigure(){
        return super.getFigure();
    }
    public void setFigureToFigure(){
        super.setFigure('♟');
    }
    
    //Prueba Viernes
    public Pawn(){
        super(Color.WHITE, new Coordinate(0,3));
    }
    //
}