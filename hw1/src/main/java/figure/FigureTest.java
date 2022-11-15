package figure;

import java.util.ArrayList;
import java.util.List;

public class FigureTest {
    public static void main(String[] args) {
        Figure figure1 = new Circle(1);
        Figure figure2 = new Square(2);
        Figure figure3 = new Triangle(1,2,2);

        List<Figure> items =  new ArrayList<>();
        items.add(figure1);
        items.add(figure2);
        items.add(figure3);

        items.forEach(a-> System.out.println(a.getArea()));

    }
}
