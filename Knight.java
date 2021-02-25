import java.util.*;

public class Knight extends Piece{
    //private char figure = '♞';

    private List<Coordinate> mvm = new ArrayList<Coordinate>();
    
    private void initPossibleMoves(){
        //Esto posiblemente este mal, porque el alfil no se mueve asi, sino completos
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
    public char getFigure(){
        return super.getFigure();
    }
    public void setFigureToFigure(){
        super.setFigure('♚');
    }
    
    //Prueba Viernes  ¿? XD, le puse donde debería estar 1 vdd
    public Knight(){
        super(Color.WHITE, new Coordinate(1,0));
    }
    //

    //Esto se haría implementando lo de isaac
    //@Override
    public String getName(){
        return "Knight";
    }

}
