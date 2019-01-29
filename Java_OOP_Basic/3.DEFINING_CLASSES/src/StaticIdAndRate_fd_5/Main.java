package StaticIdAndRate_fd_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, BankAccount> accounts = new HashMap<>();

        String line;
        while (!"End".equals(line = reader.readLine())) {
            String[] commandArgs = line.split("\\s+");

            switch(commandArgs[0]){
                case "Create":
                    BankAccount acc = new BankAccount();
                    accounts.put(acc.getId(),acc);
                    System.out.printf("Account ID%d created%n",acc.getId());
                    break;
                case "Deposit":
                    int id = Integer.parseInt(commandArgs[1]);
                    double amount = Double.valueOf(commandArgs[2]);

                    try{
                        accounts.get(id).deposit(amount);
                        System.out.printf("Deposited %.0f to ID%d%n",amount,id);
                    }catch(Exception ex){
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(commandArgs[1]));
                    break;
                case "GetInterest":
                    try {
                        System.out.printf("%.2f%n",accounts.get(Integer.parseInt(commandArgs[1]))
                                .getInterestRate(Integer.parseInt(commandArgs[2])));
                    }catch(Exception ex){
                        System.out.println("Account does not exist");
                    }


                    break;
            }

        }
    }
}
