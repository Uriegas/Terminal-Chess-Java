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

        Coordinate coordinate = new Coordinate(1,0);
        Piece pieza = myboard.obtenerPiezaCoordenadas(coordinate);
        Movimientos movimientos = new Movimientos();
        ArrayList<Move> listaMovimientosMove = new ArrayList<>(movimientos.obtenerMovimientos(pieza, myboard));

        //System.out.println(piece.toString());
        for(Move move : listaMovimientosMove)
        {
            //System.out.println(move.toString()); No jala por toString null
        }

        if(listaMovimientosMove.isEmpty())
        {
            System.out.println("Lista vacia");
        }
    }
}
