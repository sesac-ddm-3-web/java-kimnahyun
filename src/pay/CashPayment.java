package pay;

import view.View;

import java.util.Scanner;

public class CashPayment implements PaymentMethod {
    Scanner sc = new Scanner(System.in);
    private int change;
    private int received;
    private PaymentType type;

    public CashPayment() {
        this.change = 0;
        this.received = 0;
        this.type = PaymentType.CASH;
    }

    // 거스름돈 계산
    @Override
    public boolean processPayment(int amount) {
        System.out.println("💵 결제 금액: " + amount + "원");
        System.out.print("받은 금액 입력: ");
        received = sc.nextInt();

        if (received < amount) {
            System.out.println("❌ 받은 금액이 부족합니다.");
            return false;
        }

        change = received - amount;
        System.out.println(getPaymentInfo());
        System.out.println("✅ 현금 결제 완료!");


        return true;
    }
    @Override
    public String getPaymentInfo() {
        return "💰 받은 금액: " + received + "원\n" +
                "💰 거스름돈: " + change + "원";
    }

    @Override
    public String getPaymentReceipt() {
        return null;
    }

    @Override
    public PaymentType getType() {
        return type;
    }

}
