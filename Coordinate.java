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

    public void add(Coordinate other){
        this.x += other.getX();
        this.y += other.getY();
    }

    public String toString(){
        return "(" + this.getX() + ", " + this.getY() + ")";
    }

    public boolean equals(Coordinate c){
        //Si x y y en ambas coordenadas son iguales entonces retornar true
        if(this.getX() == c.getX() && this.getY() == c.getY())
            return true;
        else
            return false;
    }

    //Returns in position in chess notation
    public String toChessNotation(){
        String s = "";
        switch(this.x){
            case 0: s+='1'; break;
            case 1: s+='2'; break;
            case 2: s+='3'; break;
            case 3: s+='4'; break;
            case 4: s+='5'; break;
            case 5: s+='6'; break;
            case 6: s+='7'; break;
            case 7: s+='8'; break;
            default: s+="-1"; break;//Invalid
        }
        switch(this.y){
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
        return s;
    }
}
