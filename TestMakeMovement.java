public class TestMakeMovement {
    public static void main(String[] args) {
        Board myboard = new Board(8, 8);
        System.out.println( myboard.drawBoard() );
        //Agarrar la pieza en coordenada 4,6 o sea el peon
        Piece pieceToMove = myboard.obtenerPiezaCoordenadas(new Coordinate(4,6));
        Move move = new Move( pieceToMove, new Coordinate(4,4));

        myboard.makeMovement(move);
        System.out.println( myboard.drawBoard() );
    }
}
