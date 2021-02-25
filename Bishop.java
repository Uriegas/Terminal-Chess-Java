import java.util.*;

public class Bishop extends Piece{
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
    public char getFigure(){
        return super.getFigure();
    }

    public void setFigureToFigure(){
        super.setFigure('♝');
    }
    
    //Prueba Viernes  ¿? XD, le puse donde debería estar 1 vdd
    public Bishop(){
        super(Color.WHITE, new Coordinate(2,0));
    }
    //

    //Esto se haría implementando lo de isaac
    //@Override
    public String getName(){
        return "Bishop";
    }

}
