public class TestBoard {
    public static void main(String[] args) {
        Board myboard = new Board(8,8);
        System.out.println(myboard.drawBoard());
        myboard.boardToLetters();
        System.out.println(myboard.drawBoard());
        myboard.boardToFigures();
        System.out.println(myboard.drawBoard());
    }
}
