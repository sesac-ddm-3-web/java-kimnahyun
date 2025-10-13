package view;

import pay.PaymentMethod;

import java.util.Scanner;

public class View {
    Scanner sc = new Scanner(System.in);

    public void showStartOption() {
        System.out.println("===== \uD83C\uDF7D 레스토랑 주문 시스템 =====\n");
        System.out.print("1. 메뉴 보기\n" +
                "2. 주문하기\n" +
                "3. 결제하기\n" +
                "4. 종료\n" +
                "선택: ");
    }

    public void showSelectPayment() {
        System.out.println("===== 결제 수단 선택 =====");
        System.out.println("1. 카드 결제");
        System.out.println("2. 현금 결제");
        System.out.println("3. 포인트 결제");
        System.out.print("\n선택: ");
    }

    public String promptCard() {
        System.out.println("===== 카드 결제 =====");
        System.out.print("카드 번호를 입력하세요(숫자 16자리): ");
        sc.nextLine();
        String card = sc.nextLine();
        return card;
    }

    public void promptCash() {
        System.out.println("===== 현금 결제 =====");
        System.out.println("결제 정보: 현금 결제");
    }

    public int promptPoint() {
        System.out.println("===== 포인트 결제 =====");
        System.out.print("보유 포인트를 입력하세요: ");
        int points = sc.nextInt();
        return points;
    }

}
