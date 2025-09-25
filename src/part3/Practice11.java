package part3;

import java.util.Scanner;

public class Practice11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 수: ");
        double num1 = sc.nextDouble();

        System.out.print("연산자: ");
        char op = sc.next().charAt(0);

        System.out.print("두 번째 수: ");
        double num2 = sc.nextDouble();

        switch (op) {
            case '+':
                System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                break;
            case '-':
                System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                break;
            case '*':
                System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("결과: 오류 - 0으로 나눌 수 없습니다.");
                } else {
                    System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                }
                break;
            case '%':
                if (num2 == 0) {
                    System.out.println("결과: 오류 - 0으로 나눌 수 없습니다.");
                } else {
                    System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
                }
                break;
            default:
                System.out.println("결과: 오류 - 잘못된 연산자입니다.");
                break;
        }
        sc.close();
    }
}