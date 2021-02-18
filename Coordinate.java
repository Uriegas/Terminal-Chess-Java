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
}
