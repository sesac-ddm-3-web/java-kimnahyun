package part3;

import java.util.Scanner;

public class Practice6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 수: ");
        int num1 = sc.nextInt();

        System.out.print("두 번째 수: ");
        int num2 = sc.nextInt();

        System.out.print("성적: ");
        int score = sc.nextInt();

        int max = (num1 > num2) ? num1 : num2;
        int absNum1 = (num1 >= 0) ? num1 : -num1;
        String grade = (score >= 90) ? "A" :
                (score >= 80) ? "B" :
                        (score >= 70) ? "C" : "D";

        System.out.println("\n더 큰 수: " + max);
        System.out.println(num1 + "의 절댓값: " + absNum1);
        System.out.println("성적 " + score + "점의 등급 : " + grade);

        sc.close();
    }
}
