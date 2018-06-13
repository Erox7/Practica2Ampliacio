/**
 * Created by ssh5 on 13/06/18.
 */
public class Circle extends Figure {
    private double radius;

    public Circle(double x, double y, double r) {
        super(x, y);
        this.radius = r;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(FigureVisitor fv){
        fv.visit(this);
    }
}
