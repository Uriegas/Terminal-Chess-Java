import java.util.*;

public class Bishop extends Piece implements Cloneable{

    public Bishop(Color color, Coordinate position){
        super('♝', "Bishop", color, position);
    }

    //Copy Constructor
    public Bishop(Bishop b){
        this(b.getColor(), new Coordinate(b.getCoordinate()));
    }

    @Override
    public Bishop deepCopy(){
        return new Bishop(this);
    }

    public char getFigure(){
        return super.getFigure();
    }

    public void setFigureToFigure(){
        super.setFigure('♝');
    }
    
    //Esto se haría implementando lo de isaac
    //@Override
    public String getName(){
        return "Bishop";
    }

    public ArrayList<Move> getMoves(Board b){
        ArrayList<Coordinate> mvm = new ArrayList<Coordinate>();
        mvm.add(new Coordinate(1, 1));
        mvm.add(new Coordinate(1, -1));
        mvm.add(new Coordinate(-1, 1));
        mvm.add(new Coordinate(-1, -1));

        ArrayList<Move> m = new ArrayList<Move>();
        m.addAll(super.getMovesFromDirections(mvm, b));
        return m;
    }
}
