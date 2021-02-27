import java.util.Scanner;

public class TestParser {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Parser benito = new Parser();
        Board b = new Board(8,8);
        Move m = null;
        String s;
        while(true){
            System.out.println( b.drawBoard() );
            System.out.print("> ");
            s = in.nextLine();

            m = benito.Parse(s, b);
            if( m == null ){
                System.out.println("Valor Invalido o Flag");
            }
            else{
                System.out.println(m.toChessNotation());
                System.out.println(m.toString());
                b.makeMovement(m);
            }
            System.out.println("String is: " + s);
        }
    }
}
