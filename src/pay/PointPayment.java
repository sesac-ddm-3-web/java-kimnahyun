package pay;

public class PointPayment implements PaymentMethod {
    private int availablePoint;
    private PaymentType type;

    public PointPayment(int availablePoint) {
        this.availablePoint = availablePoint;
        this.type = PaymentType.POINT;
    }

    @Override
    public boolean processPayment(int amount) {
        if (!checkBalance(amount)) {
            System.out.println("❌ 포인트가 부족합니다. 결제를 실패했습니다.");
            return false;
        }
        availablePoint -= amount;

        System.out.println(getPaymentInfo());
        System.out.println("✅ 포인트 결제 완료!");
        return true;
    }

    @Override
    public String getPaymentInfo() {
        return "\uD83C\uDFE6 포인트 잔액 : " + availablePoint;
    }

    @Override
    public String getPaymentReceipt() {
        return null;
    }

    @Override
    public PaymentType getType() {
        return type;
    }

    private boolean checkBalance(int amount) {
        return availablePoint >= amount;
    }
}
