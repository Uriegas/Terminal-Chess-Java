public class Coordinate {
    private int x;
    private int y;

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void changePosition(Coordinate other){
        this.x = other.x;
        this.y = other.y;
    }
}
