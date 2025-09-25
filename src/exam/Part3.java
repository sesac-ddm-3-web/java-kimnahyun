package exam;

import java.util.Scanner;

public class Part3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        System.out.print("상품의 원가를 입력하세요: ");
        int principal = sc.nextInt();

        System.out.print("할인율(%)을 입력하세요: ");
        double saleRate = sc.nextDouble();

        // 계산
        double total = principal * (1 - saleRate / 100);
        double point = (total < 30000) ? (total / 100) * 1 : (total / 100) * 5;

        // 출력
        System.out.println("\n=== 결제 정보 ===");
        System.out.println("상품 원가: " + principal);
        System.out.println("할인율: " + saleRate + "%");
        System.out.println("--------------");
        System.out.println("최종 결제 금액: " + ((int) total / 10) * 10 + "원");
        System.out.println("적립 포인트: " + (int) point + "점");
    }
}
