package pay;

public enum PaymentType {
    CARD("카드 결제"),
    CASH("현금 결제"),
    POINT("포인트 결제");
    private String displayName;

    PaymentType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
