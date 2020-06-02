package StaticIdAndRate_fd_5;

public class BankAccount {
    private static final double DEFAULT_INTEREST_RATE = 0.02;
    private static int idSequence;
    private static double interestRate;

    private int id;
    private double balance;

    public BankAccount(){
        interestRate = DEFAULT_INTEREST_RATE;
        this.id = ++idSequence;
    }

    public int getId(){
        return id;
    }

    public void setInterest(double interest){
        interestRate = interest;
    }

    public double getInterestRate(int year){
        return this.balance * interestRate * year;
    }

    public static double setInterestRate(double interest){
        return interestRate = interest;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

}
