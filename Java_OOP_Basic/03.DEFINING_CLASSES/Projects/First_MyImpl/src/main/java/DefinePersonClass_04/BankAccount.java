package DefinePersonClass_04;

public class BankAccount {
    private final static Double DEFAULT_INTEREST_RATE = 0.02;

    private static int bankAccountCount;
    private static double rate;

    private int id;
    private double balance;

    public BankAccount() {
        this.rate = DEFAULT_INTEREST_RATE;
        this.id = ++bankAccountCount;
    }


    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate(double interestRate) {
        rate = interestRate;
    }

    public double getInterestRate(int years) {
        return this.balance * rate * years;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    @Override
    public String toString() {
        return String.format("ID%d", this.getId());
    }
}
