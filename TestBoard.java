public class TestBoard {
    public static void main(String[] args) {
        Board myboard = new Board(8,8);
        String drawedBoard = myboard.drawBoard();
        System.out.println(drawedBoard);
    }
}
