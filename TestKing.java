import java.util.Scanner;

public class TestKing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);//Para leer teclado
        King myking = new King();//Instanciar King
        Parser userInput = new Parser();//Parser
        String s;//Guarda lo que ingreso el usuario

        //Imprimir toda la info del rey
        System.out.println(myking.toString());

        //Integrando Parser para mover coordenadas
        while(true){
            System.out.print("> ");
            s = in.nextLine();

            //Pasa de string a coordenada y cambia la coordenada del rey
            myking.setPosition( userInput.Parse(s) );
            System.out.println("Pieza en: " + myking.getPosition().toString());
            System.out.println("Pieza en: " + myking.getPosition().toChessNotation());
        }
    }
}
