package part8.num3;

public class CashPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("현금으로 " + amount + "원 결제했습니다. ");
        printReceipt(amount);
    }

    @Override
    public void printReceipt(double amount) {
        System.out.println("=== 현금 영수증 ===");
        System.out.println("결제 금액 : " + amount + "원");
        System.out.println("거스름돈 : 없음");
    }
}
