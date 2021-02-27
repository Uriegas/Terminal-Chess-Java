import javax.print.attribute.standard.Destination;

//Parse from String to Coordinate
//Ex. 1f -> 3f  ==  (0,7) -> (2,7)
//l to see every legal move
//r to make a random move
//u to undo your last move
//? to see options
//Stores a object of type Move

public class Parser{
    //String to analyze
    private String s;
    //Substrings from s (Tokens)
    private String[] ss;
    private int x, y;
    private Coordinate origin, destination;
    private Move move;

    private boolean quitFlag;
    private boolean selectedOption; //Indica si el usuario no ingreso un movimiento, sino un 'comodin'
    private boolean isInvalidMovement;

    private boolean legalMoves;
    private boolean undoMoves;
    private boolean randomMove;

    public Parser(){
        //Initialize variables, except s
        this.ss = new String[3];
        this.x = 0;
        this.y = 0;
        this.origin = new Coordinate();
        this.destination = new Coordinate();
        this.quitFlag = false;
        this.selectedOption = true; //Por defecto verdadero, para no andar mandando coordenadas invalidas
        this.isInvalidMovement = false;
        this.move = null;
        this.legalMoves = false;
        this.undoMoves = false;
        this.randomMove = false;
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

    public boolean getSelectedOption(){
        return this.selectedOption;
    }

    public boolean getIsInvalidMovement(){
        return this.isInvalidMovement;
    }
    //Separate into strings of tokens 
    //Doesnt return value because it is treated inside the class
    private void Tokenizer(String s){
        this.ss[0] = s.substring(0, 2);
        this.ss[1] = s.substring(2, 4);
        this.ss[2] = s.substring(4, 6);
    }

    private void seeOptions(){//Imprime menu de opciones
        //Quiza esto deberia de ser un string para no imprimir dentro de la clase
        System.out.println("u : undo last move");
        System.out.println("l : show all legal moves");
        System.out.println("r : make a random move");
        System.out.println("quit : resign");
    }

    private boolean isValidMovement(){
        //Checa si esta el -> en lo que ingresó el usuario, tambien la longitud del string (siempre debe ser la misma)
        if( s.length() == 6)//Ej. 4f->12 (Todo movimiento tiene 6 caracteres)
            if( s.charAt(2) == '-' && s.charAt(3) == '>')//Checa el -> en el movimiento
                return true;
        return false;
    }

    //Parse from str 2 crd Ex. 3f == (2,7). RECUERDEN QUE EL ORIGEN EN VISTA DE IMPRESION SERA
    // LA 8a, pero en el codigo 8a sera (0,0)
    //Recives a string of 2 chars
    //Exception handling not implemented yet
    private Coordinate ParseCoordinate(String s){
            switch(s.charAt(0)){
                case 'a': x = 0; break;
                case 'b': x = 1; break;
                case 'c': x = 2; break;
                case 'd': x = 3; break;
                case 'e': x = 4; break;
                case 'f': x = 5; break;
                case 'g': x = 6; break;
                case 'h': x = 7; break;
                default: x = -1; break;
            }
            switch(s.charAt(1)){
                case '1': y = 7; break;
                case '2': y = 6; break;
                case '3': y = 5; break;
                case '4': y = 4; break;
                case '5': y = 3; break;
                case '6': y = 2; break;
                case '7': y = 1; break;
                case '8': y = 0; break;
                default: y = -1; break;
            }
        return new Coordinate(x, y);
    }

    public Move Parse(String s, Board b){
        //Save string into class
        this.s = s;

        this.formatString();//Replace white spaces

        if( s.equals("?") || s.equals("l") || s.equals("r") || s.equals("u") || s.equals("quit")){
            this.selectedOption = true;
            this.move = null;
            if(s.equals("l"))
                this.legalMoves = true;
            else if(s.equals("r"))
                this.randomMove = true;
            else if(s.equals("u"))
                this.undoMoves = true;
            else if(s.equals("?"))
                seeOptions();//See options
            else if(s.equals("quit"))
                this.quitFlag = true;//Send a quit signal or something like that
        }
        else{//Es una coordenada o una operación invalida
            //Para saber si es coordenada o invalido, usamos la coordenada como flag
            //Dado que obtenemos una coordenada de tipo (-1, -1) cuando es invalida.
            //La otra es comprar el movimiento con la lista de posibles movimientos.

            this.selectedOption = false; //No se seleccionó un 'comodín'
            this.legalMoves = false;
            this.undoMoves = false;
            this.randomMove = false;


            this.Tokenizer(this.s);
            this.origin = this.ParseCoordinate(this.ss[0]);
            this.destination = this.ParseCoordinate(this.ss[2]);

            //Si ingreso una coordenada invalida haz el movimiento nulo
            if( origin.isInvalid() || this.destination.isInvalid() || !isValidMovement() ){
                this.move = null;
                return null;
            }

            //Si es valido crea el objeto move
            Piece current = b.obtenerPiezaCoordenadas(origin);
            Piece capture = b.obtenerPiezaCoordenadas(destination);

            if( capture == null )
                move = new Move(current, destination, capture);
            else
                move = new Move(current, destination);
            /*
            if(isValidMovement() == true){
                isInvalidMovement = false;
                //Parsea la coordenada, ya checamos que si es valida, pero todavia no checamos si es movimiento valido
                this.Tokenizer(this.s);
                this.origin = this.ParseCoordinate(this.ss[0]);
                this.destination = this.ParseCoordinate(this.ss[2]);
                //Checar si no se ingreso una casilla invalida
                //Checar si esa casilla es un movimiento valido para la pieza en el origen
            }
            else//Ingreso algo invaldo
                isInvalidMovement = true;

            */
            /*
            if(pieceInCoordinate()){//Checar si la primer coordenada si tiene una pieza
                //Como si tiene seguimos con el codigus
                continue;
            }
            else
                //Return algo invalido
            */
        }
        return this.move;
    }
}

