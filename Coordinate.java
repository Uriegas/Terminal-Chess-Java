public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coordinate(){
        this(0, 0);
    }

    public Coordinate(Coordinate c){
        this(c.getX(), c.getY());
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setPosition(Coordinate other){
        this.x = other.x;
        this.y = other.y;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + this.getX() + ", " + this.getY() + ")";
    }

    //This function overrides public boolean equals(Obj c)
    public boolean equals(Coordinate c){
        if(this.getX() == c.getX() && this.getY() == c.getY())
            return true;
        else
            return false;
    }

    //Returns in position in chess notation
    public String toChessNotation(){
        String s = "";
        switch(this.x){
            case 0: s+='a'; break;
            case 1: s+='b'; break;
            case 2: s+='c'; break;
            case 3: s+='d'; break;
            case 4: s+='e'; break;
            case 5: s+='f'; break;
            case 6: s+='g'; break;
            case 7: s+='h'; break;
            default: s+="-1"; break;//Invalid
        }
        switch(this.y){
            case 7: s+='1'; break;
            case 6: s+='2'; break;
            case 5: s+='3'; break;
            case 4: s+='4'; break;
            case 3: s+='5'; break;
            case 2: s+='6'; break;
            case 1: s+='7'; break;
            case 0: s+='8'; break;
            default: s+="-1"; break;//Invalid
        }
        return s;
    }

    public boolean isInvalid(){
        return ( this.x == -1 || this.y == -1 ) ? true : false;
    }

    public boolean isInsideBoard(){
        return ( 0 <= this.getX() && this.getX() <= 7 && 0 <= this.getY() && this.getY() <= 7 ) ? true : false;
    }
    
    public Coordinate add(Coordinate c){
        return new Coordinate( (this.getX() + c.getX()), (this.getY() + c.getY()) );
    }

    public Coordinate getDirectionFrom2Coordinates(Coordinate destination){
        int x, y;
        if( destination.getX() > this.getX() )//Movimiento positivo
            x = 1;
        else if( this.getX() > destination.getX() )
            x = -1;
        else
            x = 0;
        if( destination.getY() > this.getY() )//Movimiento positivo
            y = 1;
        else if( this.getY() > destination.getY() )
            y = -1;
        else
            y = 0;
        return new Coordinate(x,y);
    }
}
