package part8.num1;

public class Rectangle implements Shape {
    private double v;
    private double v1;

    public Rectangle(double v, double v1) {
        this.v = v;
        this.v1 = v1;
    }

    @Override
    public double calculateArea() {
        return v * v1;
    }

    @Override
    public double calculatePerimeter() {
        return (v + v1) * 2;
    }
}
