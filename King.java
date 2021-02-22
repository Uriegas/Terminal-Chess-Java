import java.util.*;


public class King extends Piece{
//    private Coordinate[] possibleMoves = new Coordinate[4];
//    private char figure = '♚';

    //Possible movements around the piece
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
        super(color, position);
        this.initPossibleMoves();
    }

    public King(){
        //King starts at position 0,3
        //This should be done in board not here
        super('♚', "king", Color.WHITE, new Coordinate(0,3));
    }

    /*
    public char getFigure(){
        return this.figure;
    }
*/
    public String toString(){
        return "Pieza:" + this.getFigure() + '\n' + super.toString();
    }
}
