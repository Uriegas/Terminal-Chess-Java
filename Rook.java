import java.util.*;

public class Rook extends Piece{

    public Rook(Color color, Coordinate position){
        super('♜', "Rook", color, position);
    }

    public char getFigure(){
        return super.getFigure();
    }

    public void setFigureToFigure(){
        super.setFigure('♜');
    }
    
    //Copy Constructor
    public Rook(Rook r){
        this(r.getColor(), new Coordinate(r.getCoordinate()));
    }

    @Override
    public Rook deepCopy(){
        return new Rook(this);
    }

    public String getName(){
        return "Rook";
    }

    public ArrayList<Move> getMoves(Board b){
        ArrayList<Coordinate> mvm = new ArrayList<Coordinate>();
        mvm.add(new Coordinate(1, 0));
        mvm.add(new Coordinate(-1, 0));
        mvm.add(new Coordinate(0, 1));
        mvm.add(new Coordinate(0, -1));

        ArrayList<Move> m = new ArrayList<Move>();
        m.addAll(super.getMovesFromDirections(mvm, b));
        return m;
    }
}
