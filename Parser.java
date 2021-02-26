//Parse from String to Coordinate
//Ex. 1f -> 3f  ==  (0,7) -> (2,7)
//TODO: l, r, u, ? 
//l to see every legal move
//r to make a random move
//u to undo your last move
//? to see options
//Doesn't check if origin coordinate is empty
//No default in switch cases implemented

public class Parser extends Coordinate{
    //String to analyze
    private String s;
    //Substrings from s (Tokens)
    private String[] ss;
    private int x, y;
    private Coordinate origin, destination;

    private boolean quitFlag;

    public Parser(){
        //Initialize variables, except s
        this.ss = new String[3];
        this.x = 0;
        this.y = 0;
        this.origin = new Coordinate();
        this.destination = new Coordinate();
        this.quitFlag = false;
    }

    public Coordinate getOrigin(){
        return this.origin;
    }

    public Coordinate getDestination(){
        return this.destination;
    }

    public boolean getQuitFlag(){
        return this.quitFlag;
    }

    private void formatString(){
        //Remove white-spaces. Ex. 3 f - > 1 f == 3f->1f
        this.s = this.s.replaceAll("\\s", "");
    }

    //Separate into strings of tokens 
    //Doesnt return value because it is treated inside the class
    private void Tokenizer(String s){
        this.ss[0] = s.substring(0, 2);
        this.ss[1] = s.substring(2, 4);
        this.ss[2] = s.substring(4, 6);
    }

    private void SeeLegalMoves(){
        System.out.println("Legal Moves:");
    }

    private void randomMove(){
        //Generar una coordenada aleatoria de un movimiento valido.
        //Esta función modificaria las coordenadas: origin y destination
    }

    private void undoMove(){
        //El vato aqui usa algo como history.pop()
        //O sea que lleva un registro de los movimientos
        //Y nada mas quita el ultimo
        //Seria implementar un "stack" con el historial de movimientos
        //A lo mejor esto ni siquiera va aqui, quizá en el tablero
    }
    private void seeOptions(){//Imprime menu de opciones
        //Quiza esto deberia de ser un string para no imprimir dentro de la clase
        System.out.println("u : undo last move");
        System.out.println("l : show all legal moves");
        System.out.println("r : make a random move");
        System.out.println("quit : resign");
    }

    //Parse from str 2 crd Ex. 3f == (2,7). RECUERDEN QUE EL ORIGEN EN VISTA DE IMPRESION SERA
    // LA 8a, pero en el codigo 8a sera (0,0)
    //Recives a string of 2 chars
    //Exception handling not implemented yet
    private Coordinate ParseCoordinate(String s){
            switch(s.charAt(0)){
                case '1': x = 7; break;
                case '2': x = 6; break;
                case '3': x = 5; break;
                case '4': x = 4; break;
                case '5': x = 3; break;
                case '6': x = 2; break;
                case '7': x = 1; break;
                case '8': x = 0; break;
                default: x = -1; break;
            }
            switch(s.charAt(1)){
                case 'a': y = 0; break;
                case 'b': y = 1; break;
                case 'c': y = 2; break;
                case 'd': y = 3; break;
                case 'e': y = 4; break;
                case 'f': y = 5; break;
                case 'g': y = 6; break;
                case 'h': y = 7; break;
                default: y = -1; break;
            }
        return new Coordinate(x, y);
    }

    public Coordinate Parse(String s){
        //Save string into class
        this.s = s;

        this.formatString();//Replace white spaces

        if(s == "l")
            SeeLegalMoves();//See every legal move
        else if(s == "r")
            randomMove();//random move
        else if(s == "u")
            undoMove();//Undo move
        else if(s == "?")
            seeOptions();//See options
        else if(s == "quit")
            this.quitFlag = true;//Send a quit signal or something like that
        else{
            this.Tokenizer(this.s);
            //Parse first coordinate
            this.origin = this.ParseCoordinate(this.ss[0]);
            /*
            if(pieceInCoordinate()){//Checar si la primer coordenada si tiene una pieza
                //Como si tiene seguimos con el codigus
                continue;
            }
            else
                //Return algo invalido
            */

            //We ignore the arrow aka ->
            //If implemented it should be something like:
            //this.checkArrowNotation();

            //Parse second coordinate
            this.destination = this.ParseCoordinate(this.ss[2]);
            //Checar si esa casilla es un movimiento valido para la pieza en el origen
        }
        return this.destination;
    }
}

