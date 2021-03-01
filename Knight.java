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
    public ArrayList<Move> getMoves(Board b){
        ArrayList<Coordinate> mvm = new ArrayList<Coordinate>();
        mvm.add(new Coordinate(2, 1));
        mvm.add(new Coordinate(2, -1));
        mvm.add(new Coordinate(-2, 1));
        mvm.add(new Coordinate(-2, -1));
        mvm.add(new Coordinate(1, 2));
        mvm.add(new Coordinate(1, -2));
        mvm.add(new Coordinate(-1, -2));
        mvm.add(new Coordinate(-1, 2));

        ArrayList<Move> m = new ArrayList<Move>();
        for(Coordinate direction : mvm ){
            if(super.getNextMove(direction, b) != null)
                m.add(super.getNextMove(direction, b));
        }
        return m;
    }
}
