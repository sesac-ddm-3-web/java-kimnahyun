package part8.num3;

public interface Payment {
    void processPayment(double amount);

    default void printReceipt(double amount) {
        System.out.println("결제 금액 : " + amount + "원");
    }

    default boolean validateAmount(double amount) {
        if (amount > 0) {
            return true;
        } else return false;
    }
}
