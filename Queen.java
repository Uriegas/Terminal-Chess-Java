import java.util.*;

public class Queen extends Piece{
    private List<Coordinate> mvm = new ArrayList<Coordinate>();
    private void initPossibleMoves(){
        this.mvm.add(new Coordinate(0, 1));
        this.mvm.add(new Coordinate(0, -1));
        this.mvm.add(new Coordinate(1, 0));
        this.mvm.add(new Coordinate(-1, 0));
        this.mvm.add(new Coordinate(1, 1));
        this.mvm.add(new Coordinate(1, -1));
        this.mvm.add(new Coordinate(-1, 1));
        this.mvm.add(new Coordinate(-1, -1));
    }

    public Queen(Color color, Coordinate position){
        super('♛', "Queen", color, position);
        this.initPossibleMoves();
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
}
