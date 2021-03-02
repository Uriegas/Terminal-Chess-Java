import java.util.*;

public class Pawn extends Piece{
    int movesCounter;

    public Pawn(Color color, Coordinate position){
        super('♟', "Pawn", color, position);
        movesCounter = 0;
    }
    
    //Copy Constructor
    public Pawn(Pawn p){
        this(p.getColor(), new Coordinate(p.getCoordinate()));
    }

    @Override
    public Pawn deepCopy(){
        return new Pawn(this);
    }

    public char getFigure(){
        return super.getFigure();
    }
    public void setFigureToFigure(){
        super.setFigure('♟');
    }

    public ArrayList<Move> getMoves(Board b){
        ArrayList<Coordinate> mvm = new ArrayList<Coordinate>();
        if(this.getColor() == Color.WHITE){
            mvm.add(new Coordinate(0, -2));
            mvm.add(new Coordinate(0, -1));

            //Attack Moves
            mvm.add(new Coordinate(1, -1));
            mvm.add(new Coordinate(-1, -1));
        }
        else{
            mvm.add(new Coordinate(0, 2));
            mvm.add(new Coordinate(0, 1));

            //Attack Moves
            mvm.add(new Coordinate(1, 1));
            mvm.add(new Coordinate(-1, 1));
        }

        ArrayList<Move> m = new ArrayList<Move>();
        for(Coordinate direction : mvm ){
            if(super.getNextMove(direction, b) != null)
                m.add(super.getNextMove(direction, b));
        }
        //Remove null moves of the attack moves
        for(int i = 2; i < m.size(); i++)
            if(m.get(i).getPieceToCapture() == null)
                m.remove(i);

        if(movesCounter > 0 )
            m.remove(0);
        movesCounter++;
        return m;
    }
}