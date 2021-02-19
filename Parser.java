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

    public Parser(){
        //Initialize variables, except s
        this.ss = new String[3];
        this.x = 0;
        this.y = 0;
        this.origin = new Coordinate();
        this.destination = new Coordinate();
    }

    private void formatString(){
        //Remove white-spaces. Ex. 3 f - > 1 f == 3f->1f
        s.replaceAll(" ", "");
    }

    //Separate into strings of tokens 
    //Doesnt return value because it is treated inside the class
    private void Tokenizer(String s){
        this.ss[0] = s.substring(0, 2);
        this.ss[1] = s.substring(2, 4);
        this.ss[2] = s.substring(4, 6);
    }

    //Parse from str 2 crd Ex. 3f == (2,7)
    //Recives a string of 2 chars
    //Exception handling not implemented yet
    private Coordinate ParseCoordinate(String s){
            switch(s.charAt(0)){
                case '1': x = 0;
                case '2': x = 1;
                case '3': x = 2;
                case '4': x = 3;
                case '5': x = 4;
                case '6': x = 5;
                case '7': x = 6;
                case '8': x = 7;
            }
            switch(s.charAt(1)){
                case 'a': y = 0;
                case 'b': y = 1;
                case 'c': y = 2;
                case 'd': y = 3;
                case 'e': y = 4;
                case 'f': y = 5;
                case 'g': y = 6;
                case 'h': y = 7;
            }
        return new Coordinate(x, y);
    }

    public Coordinate Parse(String s){
        //Save string into class
        this.s = s;

        this.formatString();
        this.Tokenizer(this.s);
        //Parse first coordinate
        this.origin = this.ParseCoordinate(this.ss[0]);

        //We ignore the arrow aka ->
        //If implemented it should be something like:
        //this.checkArrow();

        //Parse second coordinate
        this.destination = this.ParseCoordinate(this.ss[2]);

        return this.destination;
    }
}

