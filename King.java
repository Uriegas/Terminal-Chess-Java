import java.util.*;


public class King extends Piece{
    //private char figure = '♚';

    //Possible movements around the piece
    //El bato les llama direcciones, hay lo vez Isaac
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

    public King(Color color, Coordinate position){
        super('♚', "King", color, position);
        this.initPossibleMoves();
    }

    //Copy Constructor
    public King(King k){
        this(k.getColor(), k.getCoordinate());
    }

    @Override
    public King deepCopy(){
        return new King(this);
    }

    public King(){
        this(Color.WHITE, new Coordinate(0,4));
    }

    public char getFigure(){
        return super.getFigure();
    }

    public void setFigureToFigure(){
        super.setFigure('♚');
    }
}
