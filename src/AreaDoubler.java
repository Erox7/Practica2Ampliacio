import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssh5 on 13/06/18.
 */
public class AreaDoubler implements FigureVisitor{
    /*private Drawing areaDoubledDrawing;
    private Rectangle areaDoubledRectangle;
    private Circle areaDoubledCircle;*/
    private Figure areaDoubledFigure;

    @Override
    public void visit(Circle c) {
        double newRadius = c.getRadius()* Math.sqrt(2.0);
        //areaDoubledCircle = new Circle(c.getX(),c.getY(), newRadius);
        areaDoubledFigure = new Circle(c.getX(),c.getY(), newRadius);
    }

    @Override
    public void visit(Rectangle r) {
        double newHeight = r.getHeight() * Math.sqrt(2.0);
        double newWidth = r.getWidth() * Math.sqrt(2.0);
        //areaDoubledRectangle = new Rectangle(r.getX(),r.getY(), newWidth, newHeight);
        areaDoubledFigure = new Rectangle(r.getX(),r.getY(), newWidth, newHeight);
    }

    @Override
    public void visit(Drawing d) {
        DrawingBuilder db = new DrawingBuilder(d.getX(), d.getY());
        AreaDoubler ad = new AreaDoubler();
        for(Figure f : d.getComponents()){
            f.accept(ad);
            db.addFigure(ad.getDoubledArea());
        }
        //areaDoubledDrawing = db.buildDrawing();
        areaDoubledFigure = db.buildDrawing();
    }

    public Figure getDoubledArea(){
        return areaDoubledFigure;
    }
}
