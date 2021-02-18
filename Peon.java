
import java.util.*;

public class Pawn extends Piece{
    private char figure = '♟';

    private List<Coordinate> mvm = new ArrayList<Coordinate>();

    public Pawn(Color color, Coordinate position){
        super(color, position);
        this.initPossibleMoves();
    }

    private void initPossibleMoves(){
        if(super.getColor() == "WHITE"){
            this.mvm.add(new Coordinate(0, 1));
        }else if(super.getColor() == "BLACK"){
            this.mvm.add(new Coordinate(0, -1));
        }
    }

    public char toChar(){
        return this.figure;
    }
}