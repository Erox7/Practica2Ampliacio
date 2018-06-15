package main;

import java.util.Collections;
import java.util.List;

/**
 * Created by ssh5 on 13/06/18.
 */
public class Drawing extends Figure {
    private final List<Figure> components;
    public Drawing(double x, double y, List<Figure> components) {
        super(x, y);
        this.components = components;
    }

    public List<Figure> getComponents() {
        return Collections.unmodifiableList(components);
    }

    @Override
    public void accept(FigureVisitor fv){
        fv.visit(this);
    }
}