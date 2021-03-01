import java.util.*;

public class Bishop extends Piece implements Cloneable{
    //private char figure = '♝';

    private List<Coordinate> mvm = new ArrayList<Coordinate>();
    
    private void initPossibleMoves(){
        //Esto posiblemente este mal, porque el alfil no se mueve asi, sino completos
        this.mvm.add(new Coordinate(1, 1));
        this.mvm.add(new Coordinate(1, -1));
        this.mvm.add(new Coordinate(-1, 1));
        this.mvm.add(new Coordinate(-1, -1));
    }

    public Bishop(Color color, Coordinate position){
        super('♝', "Bishop", color, position);
        this.initPossibleMoves();
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

}
