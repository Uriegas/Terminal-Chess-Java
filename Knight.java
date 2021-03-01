import java.util.*;

public class Knight extends Piece{
    private List<Coordinate> mvm = new ArrayList<Coordinate>();
    
    private void initPossibleMoves(){
        this.mvm.add(new Coordinate(2, 1));
        this.mvm.add(new Coordinate(2, -1));
        this.mvm.add(new Coordinate(-2, 1));
        this.mvm.add(new Coordinate(-2, -1));
        this.mvm.add(new Coordinate(1, 2));
        this.mvm.add(new Coordinate(-1, 2));
        this.mvm.add(new Coordinate(1, -2));
        this.mvm.add(new Coordinate(-1, -2));
        
    }

    public Knight(Color color, Coordinate position){
        super('♞', "Night", color, position);
        this.initPossibleMoves();
    }

    //Copy Constructor
    public Knight(Knight k){
        this(k.getColor(), new Coordinate(k.getCoordinate()));
    }

    @Override
    public Knight deepCopy(){
        return new Knight(this);
    }

    public char getFigure(){
        return super.getFigure();
    }
    public void setFigureToFigure(){
        super.setFigure('♚');
    }

    //@Override
    public String getName(){
        return "Knight";
    }

}
