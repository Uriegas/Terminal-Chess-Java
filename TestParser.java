import java.util.Scanner;

public class TestParser {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Parser benito = new Parser();
        String s;
        while(true){
            System.out.print("> ");
            s = in.nextLine();
            benito.Parse(s);
            System.out.println("String is: " + s);
            System.out.println("Origin is: " + benito.getOrigin().toString() );
            System.out.println("Destination is: " + benito.getDestination().toString() );
        }
    }
}
