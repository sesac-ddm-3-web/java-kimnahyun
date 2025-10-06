public interface PaymentMethod {
    boolean processPayment(int amount);
    String getPaymentInfo();
}