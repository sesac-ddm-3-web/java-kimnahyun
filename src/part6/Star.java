package part6;

public class Star {

    //1
    public void rightTriangle() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }

    //2
    public void invertedRightTriangle() {
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= i; j++) System.out.print("*");
            System.out.println();
        }
    }

    //3
    public void pyramid() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5 - i; j++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }

    //4
    public void invertedPyramid() {
        for (int i = 5; i >= 1; i--) {
            for (int j = 1; j <= 5 - i; j++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }

    //5
    public void diamond() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5 - i; j++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= 5 - i; j++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Star s = new Star();
        s.rightTriangle();
        System.out.println();
        s.invertedRightTriangle();
        System.out.println();
        s.pyramid();
        System.out.println();
        s.invertedPyramid();
        System.out.println();
        s.diamond();
    }
}
