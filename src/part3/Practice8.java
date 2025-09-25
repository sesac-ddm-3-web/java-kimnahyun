package part3;

public class Practice8 {
    public static void main(String[] args) {
        int a = 10, b = 20, c = 30;

        int result1 = a + b * c;
        int result2 = (a + b) * c;
        int result3 = a > b ? a : b + c;
        boolean result4 = a + b > c && b - a < c;

        System.out.println("a = " + a + ", b = " + b + ", c = " + c );
        System.out.println("result1 = a + b * c = " + a + " + (" + b + " * " + c + ") = " + a + " + " + (b * c) + " = " + result1);
        System.out.println("result2 = (a + b) * c = (" + a + " + " + b + ") * " + c + " = " + (a + b) + " * " + c + " = " + result2);
        System.out.println("result3 = a > b ? a : b + c = " + a + " > " + b + " ? " + a + " : " + b + " + " + c + " = " + ((a > b) ? a : b + c));
        System.out.println("result4 = a + b > c && b - a < c = " + a + " + " + b + " > " + c + " && " + b + " - " + a + " < " + c + " = "
                + ((a + b) > c) + " && " + ((b - a) < c) + " = " + result4);
    }
}
