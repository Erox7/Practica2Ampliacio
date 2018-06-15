package main;

/**
 * Created by ssh5 on 13/06/18.
 */
public class Rectangle extends Figure {
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void accept(FigureVisitor fv){
        fv.visit(this);
    }
}
