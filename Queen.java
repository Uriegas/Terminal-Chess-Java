import java.util.*;

public class Queen extends Piece{
    //private char figure = '♛';

    private List<Coordinate> mvm = new ArrayList<Coordinate>();
    private void initPossibleMoves(){
        //Esto posiblemente este mal, porque la reina no se mueve asi
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
    
    //Prueba Viernes
    public Queen(){
        super(Color.WHITE, new Coordinate(0,3));
    }
    //

}
