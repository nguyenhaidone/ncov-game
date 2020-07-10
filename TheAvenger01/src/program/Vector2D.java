package program;

public class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(){
        this(0,0);
    }

    public void add(double x, double y){
        this.x +=x;
        this.y +=y;
    }

    public void add(Vector2D other) {
        this.add(other.x,other.y);
    }

    public void substract(double x, double y){
        this.x -=x;
        this.y -=y;
    }

    public void substract(Vector2D other){
        this.substract(other.x,other.y);
    }

    public void scale(double rate){
        this.x *=rate;
        this.y *=rate;
    }

    public Vector2D clone() {
        return new Vector2D(this.x,this.y);
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y);
    }

    public void setLength(double length) {
        double currentLength = this.getLength();
        if(currentLength != 0) {
            x = x * length / currentLength;
            y = y * length / currentLength;
        }
    }

    public double getAngle() {
        return Math.atan(y / x);
    }

    public void setAngle(double angle) {
        double length = this.getLength();
        if(length != 0) {
            x = length * Math.cos(angle);
            y = length * Math.sin(angle);
        }
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void set(double x,double y){
        this.x= x;
        this.y= y;
    }

    public void set(Vector2D other){
        this.set(other.x,other.y);
    }
    public static void main(String[] args) {
//        Vector2D v1 = new Vector2D(1,1);
    }
}
