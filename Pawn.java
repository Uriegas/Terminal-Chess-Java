
import java.util.*;

public class Pawn extends Piece{
    private char figure = '♟';

    private List<Coordinate> mvm = new ArrayList<Coordinate>();

    public Pawn(Color color, Coordinate position){
        super(color, position);
        this.initPossibleMoves();
    }

    private void initPossibleMoves(){
        if(super.getColor() == Color.WHITE){
            this.mvm.add(new Coordinate(0, 1));
        }else if(super.getColor() == Color.BLACK){
            this.mvm.add(new Coordinate(0, -1));
        }
    }

    public char toChar(){
        return this.figure;
    }
    
    //Prueba Viernes
    public Pawn(){
        super(Color.WHITE, new Coordinate(0,3));
    }
    //
}