package DefiningClasses;

public class BankAccount {
    private int id;
    private Double balance;

    public BankAccount(int id) {
        this.id = id;
        this.balance = 0.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Account ID%s, balance %.2f", id, balance);
    }
}
