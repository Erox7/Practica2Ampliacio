/**
 * Created by ssh5 on 13/06/18.
 */
public interface FigureVisitor {
    void visit(Circle c);
    void visit(Rectangle r);
    void visit(Drawing d);
}
