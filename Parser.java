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
    private Move move;

    private boolean quitFlag;
    private boolean selectedOption; //Indica si el usuario no ingreso un movimiento, sino un 'comodin'

    private boolean legalMoves;
    private boolean undoMoves;
    private boolean randomMove;

    public Parser(){
        //Initialize variables, except s, it is initialized in Parser function
        this.ss = new String[3];
        this.move = null;

        //Flags
        this.selectedOption = true; //Por defecto verdadero, para no andar mandando coordenadas invalidas
        this.legalMoves = false;
        this.undoMoves = false;
        this.randomMove = false;
        this.quitFlag = false;
    }

    public boolean getSelectedOption(){
        return this.selectedOption;
    }

    public boolean getLegal(){
        return this.legalMoves;
    }

    public boolean getUndo(){
        return this.undoMoves;
    }

    public boolean getRandom(){
        return this.randomMove;
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

    //Parse from str 2 coordinate
    //Recives a string of 2 chars
    private Coordinate ParseCoordinate(String s){
        int x, y;
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
        else{
            this.selectedOption = false; //No se seleccionó un 'comodín'
            this.legalMoves = false;
            this.undoMoves = false;
            this.randomMove = false;

            //Parsear lo que ingreso
            this.Tokenizer(this.s);
            Coordinate origin = this.ParseCoordinate(this.ss[0]);
            Coordinate destination = this.ParseCoordinate(this.ss[2]);

            //Si ingreso algo invalido haz el movimiento nulo
            if( origin.isInvalid() || destination.isInvalid() || !isValidMovement() ){
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
        }
        return this.move;
    }
}