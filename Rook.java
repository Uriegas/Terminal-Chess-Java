import java.util.*;

public class Rook extends Piece{
    private List<Coordinate> mvm = new ArrayList<Coordinate>();
    
    private void initPossibleMoves(){
        this.mvm.add(new Coordinate(1, 0));
        this.mvm.add(new Coordinate(-1, 0));
        this.mvm.add(new Coordinate(0, 1));
        this.mvm.add(new Coordinate(0, -1));
    }

    public Rook(Color color, Coordinate position){
        super('♜', "Rook", color, position);
        this.initPossibleMoves();
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
}
