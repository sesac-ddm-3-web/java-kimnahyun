package part3;

import java.util.Scanner;

public class Practice10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("국어: ");
        int korean = sc.nextInt();

        System.out.print("영어: ");
        int english = sc.nextInt();
        System.out.print("수학: ");
        int math = sc.nextInt();

        System.out.print("결석일: ");
        int absent = sc.nextInt();

        double average = (korean + english + math) / 3.0;

        boolean honor = (average >= 90) && (korean >= 80) && (english >= 80) && (math >= 80);
        boolean scholarship = (average >= 85) && (absent <= 5);
        boolean retest = (korean < 60) || (english < 60) || (math < 60);
        boolean fail = (average < 60) || (absent > 30);

        System.out.println("\n국어: " + korean + "점");
        System.out.println("영어: " + english + "점");
        System.out.println("수학: " + math + "점");
        System.out.printf("평균: %.2f점\n", average);
        System.out.println("결석일: " + absent + "일\n");

        System.out.println("우등생: " + honor);
        System.out.println("장학생: " + scholarship);
        System.out.println("재시험 대상: " + retest);
        System.out.println("유급 대상: " + fail);

        sc.close();
    }
}
