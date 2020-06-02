package DefiningClasses;

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
        while(!"End".equals(line = reader.readLine())){
            String[] lineArgs = line.split("\\s+");

            switch (lineArgs[0]) {
                case "Create":
                    if(hasBankAccount(list, lineArgs[1]) <= 0){
                        bankAccount = new BankAccount(Integer.parseInt(lineArgs[1]));
                        list.add(bankAccount);
                    }else {
                     sb.append("Account already exists")
                             .append(System.lineSeparator());
                    }
                    break;
                case "Deposit":
                    if(hasBankAccount(list, lineArgs[1]) == 0) {
                        sb.append("Account does not exist")
                                .append(System.lineSeparator());
                    }else{
                        bankAccount = getBankAccountById(list, lineArgs[1]);
                        bankAccount.deposit(Integer.parseInt(lineArgs[2]));
                    }

                    break;
                case "Withdraw":
                    if(hasBankAccount(list, lineArgs[1]) == 0) {
                        sb.append("Account does not exist")
                                .append(System.lineSeparator());
                    }else{
                        bankAccount = getBankAccountById(list, lineArgs[1]);

                        if(bankAccount.getBalance() < Integer.parseInt(lineArgs[2])) {
                            sb.append("Insufficient balance")
                                    .append(System.lineSeparator());
                        }else{
                            bankAccount.withdraw(Integer.parseInt(lineArgs[2]));
                        }
                    }

                    break;
                case "Print":
                    if(hasBankAccount(list, lineArgs[1]) <= 0){
                        sb.append("Account does not exist")
                                .append(System.lineSeparator());
                    }else {
                        sb.append(bankAccount.toString());
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

    private static BankAccount getBankAccountById(List<BankAccount> list, String id){
        return  list.stream()
                .filter(b -> b.getId() == Integer.parseInt(id))
                .findFirst()
                .get();
    }
}
