package w3p3.file;


import java.util.ArrayList;
import java.util.List;

public class Canvas implements Shape {
    List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    public void describe() {
        System.out.println("I'm a canvas, and I have : ");
        for (Shape shape : shapes) {
            shape.describe();
        }
    }
}
