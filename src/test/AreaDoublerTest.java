package test;
import main.*;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.css.Rect;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by ssh5 on 15/06/18.
 */
public class AreaDoublerTest {
    private Circle circle;
    private Rectangle rect;
    private Drawing draw;
    private AreaDoubler ad;
    private final double DOUBLE_RATE = Math.sqrt(2.0);
    private final double FINAL_X = 1.0,FINAL_Y = 2.0;

    @Before
    public void prepareFigures(){
        ad = new AreaDoubler();
        circle = new Circle(FINAL_X,FINAL_Y, 3.0);
        rect = new Rectangle(FINAL_X,FINAL_Y, 1.0,1.0);
        DrawingBuilder db = new DrawingBuilder(FINAL_X,FINAL_Y);
        draw = db.addFigure(circle).addFigure(rect).buildDrawing();
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testListNotModifiable(){
        List<Figure> lf = draw.getComponents();
        Figure newFigure = new Rectangle(FINAL_X, FINAL_Y, 2.0,2.0);
        lf.add(newFigure);
    }
    @Test
    public void circleDoubled(){
        circle.accept(ad);
        Circle tmpCircle = (Circle) ad.getDoubledArea();
        double shouldBe = circle.getRadius()*DOUBLE_RATE;
        double is = tmpCircle.getRadius();
        Integer compareResult = Double.compare(shouldBe,is);
        assertTrue("Doubled correctly", compareResult.equals(0));
    }

    @Test
    public void rectDoubled(){
        rect.accept(ad);
        Rectangle tmpRect = (Rectangle) ad.getDoubledArea();
        double shouldBe = rect.getHeight()*DOUBLE_RATE;
        double is = tmpRect.getHeight();
        Integer compareResult = Double.compare(shouldBe,is);
        assertTrue("Doubled correctly",
                compareResult.equals(0));
    }

    @Test
    public void drawingDoubled(){
        double shouldBe, is;
        Integer compareResult;
        draw.accept(ad);
        Drawing tmpDraw = (Drawing) ad.getDoubledArea();
        Circle doubledCircle = (Circle) tmpDraw.getComponents().get(0);
        shouldBe = circle.getRadius()*DOUBLE_RATE;
        is = doubledCircle.getRadius();
        compareResult = Double.compare(shouldBe,is);
        assertTrue("Doubled correctly",compareResult.equals(0));

        Rectangle doubledRect = (Rectangle) tmpDraw.getComponents().get(1);
        shouldBe = rect.getHeight()*DOUBLE_RATE;
        is = doubledRect.getHeight();
        compareResult = Double.compare(shouldBe,is);
        assertTrue("Doubled correctly",compareResult.equals(0));

    }
}
