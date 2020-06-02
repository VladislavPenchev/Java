package BankAccount;

public class BankAccount {
    private double balance;

    public BankAccount() {

    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amount){
        if(amount < 0)
            throw new IllegalArgumentException("Amount should be more than 0.");
        this.balance += amount;
    }

    public void withDraw(double amount){
        if(amount < 0){
            throw new IllegalArgumentException("Amount should be more than 0");
        }else if(this.balance < amount){
            throw new IllegalArgumentException("Not enough money");
        }
        this.balance -= amount;
    }
}
