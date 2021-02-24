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

    public King(Color color){
        //King starts at position 0,3
        //Solo ocupamos saber de que color es la pieza
        super('♚', "king", color, new Coordinate(0,4));
        //Si la pieza es negra cambiar la posicion inicial
        if(color == Color.BLACK)
            this.setPosition(new Coordinate(7, 4));
    }

    public King(){
        this(Color.WHITE);
    }

    /*
    //Check if the destination Coordinate aka Movement is valid,
    //if so which one.
    public boolean isValid(Coordinate destination){
        //Coordinate possibleMoves[];
    }

    public char getFigure(){
        return this.figure;
    }
    public String toString(){
        return "Pieza:" + this.getFigure() + '\n' + super.toString();
    }
*/
}
