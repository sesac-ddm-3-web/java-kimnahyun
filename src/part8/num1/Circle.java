package part8.num1;

public class Circle implements Shape {
    private double v;

    public Circle(double v) {
        this.v = v;
    }

    @Override
    public double calculateArea() {
        return v * v * 3.14;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * v * 3.14;
    }
}
