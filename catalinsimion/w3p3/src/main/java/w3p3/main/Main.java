package w3p3.main;

import w3p3.file.*;

public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        Point point2 = new Point();
        Point point3 = new Point();
        Point point4 = new Point();
        Line line = new Line(point, point2);
        Line line2 = new Line(point3, point2);
        Line line3 = new Line(point4, point2);
        Line line4 = new Line(point3, point4);
        Rectangle rectangle = new Rectangle(point, point2, point3, point4, line, line2, line3, line4);
        Circle circle = new Circle();
        Canvas canvas = new Canvas();
        Canvas canvas2 = new Canvas();
        canvas.addShape(point);
        canvas.addShape(line);
        canvas.addShape(rectangle);
        canvas.addShape(circle);
        canvas.addShape(canvas2);
        canvas.describe();
    }
}
