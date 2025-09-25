package exam;

import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        System.out.print("원금을 입력하세요: ");
        int principal = sc.nextInt();

        System.out.print("연이율(%)을 입력하세요: ");
        double interestRate = sc.nextDouble();

        System.out.print("예치 기간(년)을 입력하세요: ");
        int years = sc.nextInt();

        // 계산
        double interestIncome = principal * (interestRate / 100) * years;
        int total = principal + (int) interestIncome;

        // 출력
        System.out.println("\n=== 최종 계산 결과 ===");
        System.out.println("원금: " + principal);
        System.out.println("연이율: " + interestRate + "%");
        System.out.println("기간: " + years + "년");
        System.out.println("--------------");
        System.out.println("총 이자 수익: " + (int) interestIncome + "원");
        System.out.println("최종 수령액: " + total + "원");
    }
}
