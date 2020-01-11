package w3p3.file;


public class Line implements Shape {
    private Point point, point2;

    public Line(Point point, Point point2) {
        this.point = point;
        this.point2 = point2;
    }

    public void describe() {
        System.out.println("I'm a line");
    }
}