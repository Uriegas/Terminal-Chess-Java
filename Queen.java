import java.util.*;

public class Queen extends Piece{

    public Queen(Color color, Coordinate position){
        super('♛', "Queen", color, position);
    }
    
    public char getFigure(){
        return super.getFigure();
    }

    public void setFigureToFigure(){
        super.setFigure('♛');
    }
    
    //Copy Constructor
    public Queen(Queen q){
        this(q.getColor(), new Coordinate(q.getCoordinate()));
    }

    @Override
    public Queen deepCopy(){
        return new Queen(this);
    }

    public ArrayList<Move> getMoves(Board b){
        ArrayList<Coordinate> mvm = new ArrayList<Coordinate>();
        mvm.add(new Coordinate(0, 1));
        mvm.add(new Coordinate(0, -1));
        mvm.add(new Coordinate(1, 0));
        mvm.add(new Coordinate(-1, 0));
        mvm.add(new Coordinate(1, 1));
        mvm.add(new Coordinate(1, -1));
        mvm.add(new Coordinate(-1, 1));
        mvm.add(new Coordinate(-1, -1));

        ArrayList<Move> m = new ArrayList<Move>();
        m.addAll(super.getMovesFromDirections(mvm, b));
        return m;
    }
}
