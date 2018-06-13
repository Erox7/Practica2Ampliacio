import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssh5 on 13/06/18.
 */
public class MainClass {

    public static void main(String[] args) {
        AreaDoubler ad = new AreaDoubler();
        List<Figure> lF = new ArrayList<Figure>();

        lF.add(new Circle(1.0,2.0,2));
        Drawing d = new Drawing(1.0,2.0, lF);
        d.accept(ad);
        Drawing d2 = (Drawing) ad.getDoubledArea();
        for(Figure f : d2.getComponents()){
            System.out.println(f.getArea());
        }
    }
}
