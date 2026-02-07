package pay;

public interface PaymentMethod {

    boolean processPayment(int amount);

    String getPaymentInfo();

    String getPaymentReceipt();

    PaymentType getType();

}
