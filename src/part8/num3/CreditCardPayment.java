package part8.num3;

public class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("금액 유효성 검사 통과: " + amount + "원");
        System.out.println("신용카드로 " + amount + "원 결제했습니다. ");
        printReceipt(amount);
    }

    @Override
    public void printReceipt(double amount) {
        System.out.println("=== 신용카드 영수증 ===");
        System.out.println("결제 금액 : " + amount + "원");
        System.out.println("결제 완료");

    }
}
