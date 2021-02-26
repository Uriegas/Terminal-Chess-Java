import javax.management.QueryEval;

public class TestMove {
    public static void main(String[] args) {
        Piece reina = new Queen(Color.WHITE, new Coordinate(0,0));
        Piece king = new King(Color.WHITE, new Coordinate(0,3));
        Coordinate dest = new Coordinate(0,3);

        Move movement = new Move(reina, dest, king);
        System.out.println(movement.toString());
    }
}
