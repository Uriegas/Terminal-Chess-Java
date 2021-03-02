//Parse from String to Coordinate
//Ex. 1f -> 3f  ==  (0,7) -> (2,7)
//l to see every legal move
//r to make a random move
//u to undo your last move
//? to see options
//Stores a object of type Move

import java.util.*;

public class Parser{
    //String to analyze
    private String s;
    //Substrings from s (Tokens)
    private String[] ss;
    private Move move;
    private Random rand;
    private boolean quitFlag;

    public Parser(){
        //Initialize variables, except s, it is initialized in Parser function
        this.ss = new String[3];
        this.move = null;
        this.rand = new Random();
        this.quitFlag = false;
    }

    //--------------
    //Flags
    //--------------
    public void getLegal(Board b){
        System.out.println(b.listPlayerMoves());
    }

    public void getUndo(Board b){
        b.undoMovement();
    }

    public void getRandom(Board b){
        ArrayList<Move> m = b.getAllPossibleMoves(b.getCurrentPlayer());
        this.move = m.get( rand.nextInt(m.size()) );
    }

    public boolean getQuitFlag(){
        return this.quitFlag;
    }

    //--------------
    //Parsing
    //--------------
    private void formatString(){
        this.s = this.s.replaceAll("\\s", "");
    }

    //Separate into strings of tokens 
    private void Tokenizer(String s){
        this.ss[0] = s.substring(0, 2);
        this.ss[1] = s.substring(2, 4);
        this.ss[2] = s.substring(4, 6);
    }

    private void seeOptions(){//Imprime menu de opciones
        System.out.println("u : undo last move");
        System.out.println("l : show all legal moves");
        System.out.println("r : make a random move");
        System.out.println("quit : resign");
    }

    private boolean isValidMovement(){
        if( s.length() == 6)//Ej. 4f->12 (Todo movimiento tiene 6 caracteres)
            if( s.charAt(2) == '-' && s.charAt(3) == '>')//Checa el -> en el movimiento
                return true;
        return false;
    }

    //Parse from str 2 coordinate
    //Recieves a string of 2 chars
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

        if(s.equals("l")){
            this.getLegal(b);
            this.move = null;
        }
        else if(s.equals("r"))
            this.getRandom(b);
        else if(s.equals("u")){
            this.getUndo(b);
            this.move = null;
        }
        else if(s.equals("?")){
            this.seeOptions();//See options
            this.move = null;
        }
        else if(s.equals("quit"))
            this.quitFlag = true;//Send a quit signal or something like that
        else{
            //Verificar la longitud del string
            if(this.s.length() != 6){
                System.out.println("Invalid Value");
                this.move = null;
                return null;
            }

            //Parsear lo que ingreso
            this.Tokenizer(this.s);
            Coordinate origin = this.ParseCoordinate(this.ss[0]);
            Coordinate destination = this.ParseCoordinate(this.ss[2]);

            //Si ingreso algo invalido haz el movimiento nulo
            if( origin.isInvalid() || destination.isInvalid() || !isValidMovement() ){
                System.out.println("Invalid Value");
                this.move = null;
                return null;
            }

            //Si es valido crea el objeto move
            Piece current = b.obtenerPiezaCoordenadas(origin).deepCopy();
            Piece capture = null;
            if(b.obtenerPiezaCoordenadas(destination) != null){
                capture = b.obtenerPiezaCoordenadas(destination).deepCopy();
                move = new Move(current, destination, capture);
            }
            else{
                move = new Move(current, destination, null);
            }
        }
        this.s = "";
        return this.move;
    }
}