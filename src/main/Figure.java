package main;

/**
 * Created by ssh5 on 13/06/18.
 */
public abstract class Figure {
    private double x;
    private double y;

    public Figure(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public abstract void accept(FigureVisitor fv);
}
