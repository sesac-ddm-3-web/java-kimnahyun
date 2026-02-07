package pay;

public class CardPayment implements PaymentMethod {
    private String cardNum;
    private PaymentType type;

    public CardPayment(String cardNum) {
        this.cardNum = cardNum;
        this.type = PaymentType.CARD;
    }

    // 결제 성공 여부
    @Override
    public boolean processPayment(int amount) { //결제 금액
        if (!validateCardNum(this.cardNum)) {
            System.out.println("❌ 카드 번호가 유효하지 않습니다. 결제를 실패했습니다.");
            return false;
        }
        System.out.println(getPaymentInfo());
        System.out.println("✅ 카드 승인 완료!");
        return true;
    }

    // 결제 정보 - 카드 번호
    @Override
    public String getPaymentInfo() {
        return "카드 번호 : " + cardNum;
    }

    @Override
    public String getPaymentReceipt() {
        return null;
    }

    @Override
    public PaymentType getType() {
        return PaymentType.CARD;
    }

    private boolean validateCardNum(String cardNum) {
        if (cardNum.length() == 16) {
            return true;
        }
        return false;
    }
}
