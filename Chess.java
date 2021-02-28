import java.util.Scanner;

//Main del Chess
public class Chess {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Parser parser = new Parser();
        String input;
        Board board = new Board(8,8);

        System.out.println("Welcome to Terminal Chess");
        System.out.println("A simple chess game from your terminal");
        System.out.println("¡¡Whites move first!!\n");

        while(!board.isCheckMate() && !parser.getQuitFlag() && !board.isStalemate() ){//While there is no checkmate, stalemate or a quit
            System.out.println(board.drawBoard() + '\n');
            if(board.getCurrentPlayer() == Color.WHITE)
                System.out.print("Blues");
            else
                System.out.print("Reds");
            System.out.print(" move. (Type '?' to see options.) > ");

            input = in.nextLine();
            parser.Parse(input, board);
        }

        //Solo existen 3 posibles resultados del juego
        if(board.isCheckMate())
            System.out.println(board.getCurrentPlayer().toString() + "won!!");
        else if(board.isStalemate())//Aqui creo que seria agarrar el otro jugador
            System.out.println("Draw :(");
        else
            System.out.println("Quiting game...");
        in.close();
    }
}
