public class TestMakeMovement {
    public static void main(String[] args) {
        Board myboard = new Board(8, 8);
        System.out.println( myboard.drawBoard() );
        //Agarrar la pieza en coordenada 4,6 o sea el peon
        //Caballo 1, 7
        Piece pieceToMove = myboard.obtenerPiezaCoordenadas(new Coordinate(1,7));
        Move move = new Move( pieceToMove, new Coordinate(3,5));

        if( myboard.makeMovement(move) )
            System.out.println("Valid Move");
        else
            System.out.println("Invalid Move");
        System.out.println( myboard.drawBoard() );
    }
}
