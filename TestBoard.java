import java.util.*;

public class TestBoard 
{
    public static void main(String[] args) 
    {
        Board myboard = new Board(8,8);
        System.out.println(myboard.drawBoard());

        System.out.println("\n----------- Movimientos Posibles -----------\n");
        //myboard.obtenerPiezasPorColor();

        //Peon
        //Coordinate coordinate = new Coordinate(4,6);
        //Reina
        //Coordinate coordinate = new Coordinate(3,7);
        //Caballito
        System.out.println("\n\nPEIZA 1");
        Coordinate coordinate = new Coordinate(1,0);
        Piece pieza = myboard.obtenerPiezaCoordenadas(coordinate);
        Movimientos movimientos = new Movimientos();
        ArrayList<Move> listaMovimientosMove = new ArrayList<>(movimientos.obtenerMovimientos(pieza, myboard));

        System.out.println("\n\n");
        for(Move move : listaMovimientosMove)
        {
            System.out.println(move.toString()); // No jala por toString null
        }

        System.out.println("\n\nPEIZA 2");
        coordinate = new Coordinate(0,6);
        pieza = myboard.obtenerPiezaCoordenadas(coordinate);
        listaMovimientosMove = new ArrayList<>(movimientos.obtenerMovimientos(pieza, myboard));

        System.out.println("\n\n");
        for(Move move : listaMovimientosMove)
        {
            System.out.println(move.toString()); // No jala por toString null
        }

        //NEGROS == ROJO
        //WHITE == AZUL
        if(listaMovimientosMove.isEmpty())
        {
            System.out.println("Lista vacia");
        }
    }
}
