//Parse from String to Coordinate
//Ex. 1f -> (0, 4)
//TODO: l, r, u, ? 
//l to see every legal move
//r to make a random move
//u to undo your last move
//? to see options

public class Parser extends Coordinate{
    private String s;
    private int[] tokens = new int[2];
    private Coordinate position;

    public Coordinate Parse(){
            switch(s.charAt(0)){
                case '1': tokens[0] = 0;
                case '2': tokens[0] = 1;
                case '3': tokens[0] = 2;
                case '4': tokens[0] = 3;
                case '5': tokens[0] = 4;
                case '6': tokens[0] = 5;
                case '7': tokens[0] = 6;
                case '8': tokens[0] = 7;
            }
            switch(s.charAt(1)){
                case 'a': tokens[1] = 0;
                case 'b': tokens[1] = 1;
                case 'c': tokens[1] = 2;
                case 'd': tokens[1] = 3;
                case 'e': tokens[1] = 4;
                case 'f': tokens[1] = 5;
                case 'g': tokens[1] = 6;
                case 'h': tokens[1] = 7;
            }
        this.position.setPosition(tokens[0], tokens[1]);
        return this.position;
    }
}

