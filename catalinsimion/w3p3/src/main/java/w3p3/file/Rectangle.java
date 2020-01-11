package w3p3.file;

public class Rectangle implements Shape {

    private Point point, point2, point3, point4;
    private Line line, line2, line3, line4;
    public Rectangle(Point point,Point point2, Point point3, Point point4, Line line,Line line2,Line line3, Line line4){
        this.point = point;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
        this.line=line;
        this.line2=line2;
        this.line3=line3;
        this.line4=line4;
}
    public void describe() {
        System.out.println("I'm a rectangle");
    }
}