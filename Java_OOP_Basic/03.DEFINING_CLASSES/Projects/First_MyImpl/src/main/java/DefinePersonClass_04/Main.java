package DefinePersonClass_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<BankAccount> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        BankAccount bankAccount = null;

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] lineArgs = line.split("\\s+");

            switch (lineArgs[0]) {
                case "Create":
                    bankAccount = new BankAccount();
                    list.add(bankAccount);
                    sb.append(String.format("Account %s created", bankAccount.toString()))
                    .append(System.lineSeparator());
                    break;
                case "Deposit":
                    if (hasBankAccount(list, lineArgs[1]) == 0) {
                        sb.append("Account does not exist")
                                .append(System.lineSeparator());
                    } else {
                        bankAccount = getBankAccountById(list, lineArgs[1]);
                        bankAccount.deposit(Integer.parseInt(lineArgs[2]));

                        sb.append(String.format("Deposited %d to %s", Integer.parseInt(lineArgs[2]), bankAccount.toString()))
                        .append(System.lineSeparator());
                    }

                    break;
                case "GetInterest":
                    if (hasBankAccount(list, lineArgs[1]) == 0) {
                        sb.append("Account does not exist")
                                .append(System.lineSeparator());
                    } else {
                        bankAccount = getBankAccountById(list, lineArgs[1]);
                        double interestRateResult = bankAccount.getInterestRate(Integer.parseInt(lineArgs[2]));

                        sb.append(String.format("%.2f", interestRateResult))
                        .append(System.lineSeparator());
                    }

                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(lineArgs[1]));
                    break;
                case "Print":
                    if (hasBankAccount(list, lineArgs[1]) <= 0) {
                        sb.append("Account does not exist")
                                .append(System.lineSeparator());
                    } else {
                        sb.append(bankAccount.toString())
                        .append(System.lineSeparator());
                    }
                    break;
            }
        }

        System.out.println(sb.toString());
    }

    private static long hasBankAccount(List<BankAccount> list, String lineArg) {
        return list.stream()
                .filter(b -> b.getId() == Integer.parseInt(lineArg))
                .count();
    }

    private static BankAccount getBankAccountById(List<BankAccount> list, String id) {
        return list.stream()
                .filter(b -> b.getId() == Integer.parseInt(id))
                .findFirst()
                .get();
    }
}
