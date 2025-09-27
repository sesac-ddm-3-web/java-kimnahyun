package exam.part6;

public class BankAccount {
    private String accountNumber = "";
    private String ownerName = "";
    private long balance = 0;

    BankAccount(String accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0;
    }

    public void deposit(long amount) {
        if (amount < 0) {
            throw new IllegalStateException("유효하지 않은 금액입니다.");
        } else {
            balance += amount;
            System.out.println("입금 후 잔액: " + balance + "원");
        }
    }

    public void withdraw(long amount) {
        if (amount < 0) {
            System.out.println("0보다 작은 금액은 출금할 수 없습니다.");
        } else if (amount > balance) {
            System.out.println("잔액이 부족합니다.");
        } else {
            balance -= amount;
            System.out.println("출금 후 잔액: " + balance + "원");
        }
    }

    public void getBalanceInfo() {
        System.out.println("계좌번호: " + accountNumber + ", 예금주: " + ownerName + ", 현재 잔액: " + balance + "원");
    }
}
