import java.util.*;

public class TestBoard 
{
    public static void main(String[] args) 
    {
        Board myboard = new Board(8,8);
        System.out.println(myboard.drawBoard());
        myboard.boardToLetters();
        System.out.println(myboard.drawBoard());
        myboard.boardToFigures();
        System.out.println(myboard.drawBoard());

        System.out.println("\n----------- Movimientos Posibles -----------\n");
        //myboard.obtenerPiezasPorColor();

        //Peon
        //Coordinate coordinate = new Coordinate(4,6);
        //Reina
        //Coordinate coordinate = new Coordinate(3,7);
        //Caballito
        Coordinate coordinate = new Coordinate(1,7);

        Piece pieza = myboard.obtenerPiezaCoordenadas(coordinate);
        Movimientos movimientos = new Movimientos();
        ArrayList<Move> listaMovimientosMove = new ArrayList<>(movimientos.obtenerMovimientos(pieza, myboard));

        //System.out.println(piece.toString());
        for(Move move : listaMovimientosMove)
        {
            System.out.println(move.toString()); // No jala por toString null
        }

        if(listaMovimientosMove.isEmpty())
        {
            System.out.println("Lista vacia");
        }
    }
}
