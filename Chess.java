import java.util.Scanner;

//Aqui vamos a poner el juego, es el main, ya el definitivo
public class Chess {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Parser parser = new Parser();
        Board board = new Board(8,8);

        System.out.println("Welcome to Terminal Chess");
        System.out.println("A simple chess game from your terminal");
        System.out.println("¡¡Whites move first!!\n");

        System.out.println(board.drawBoard());
        System.out.print("Whites move. Type '?' to see options. >");

        in.close();
    }
}
