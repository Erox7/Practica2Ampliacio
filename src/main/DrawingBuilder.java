package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssh5 on 13/06/18.
 */
public class DrawingBuilder {
    private List<Figure> components;
    private double x;
    private double y;

    public DrawingBuilder(double x, double y){
        this.x = x;
        this.y = y;
        this.components = new ArrayList<>();
    }

    public DrawingBuilder addFigure(Figure f){
        components.add(f);
        return this;
    }

    public Drawing buildDrawing(){
        return new Drawing(x,y, components);
    }
}