package DefinePersonClass_04;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<BankAccount> bankAccounts;

    public Person(String name, int age) {
        this(name, age, new ArrayList<>());
    }

    public Person(String name, int age, List<BankAccount> bankAccounts) {
        this.name = name;
        this.age = age;
        this.bankAccounts = bankAccounts;
    }

    public double getBalance() {
        return this.bankAccounts.stream()
                .mapToDouble(BankAccount::getBalance)
                .sum();
    }
}
