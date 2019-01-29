package DefineBankAccountClass_fd_1;

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

            int id = Integer.parseInt(commandArgs[1]);

            switch(commandArgs[0]){
                case "Create":
                    executeCreateCommand(accounts, id);

                    break;
                case "Deposit":
                    double depositAmount = Double.parseDouble(commandArgs[2]);
                    if(accounts.get(id) == null){
                        System.out.println("Account does not exist");
                        break;
                    }
                    accounts.get(id).deposit(depositAmount);
                    break;
                case "Withdraw":
                    double withdrawAmount= Double.parseDouble(commandArgs[2]);
                    BankAccount acc = accounts.get(id);
                    if(acc != null){
                        try{
                            acc.withdraw(withdrawAmount);
                        }catch(IllegalArgumentException ex){
                            System.out.println(ex.getMessage());
                        }
                    }else{
                        System.out.println("Account does not exist");
                    }
                    break;
                case "Print":
                    if(accounts.get(id) == null){
                        System.out.println("Account does not exist");
                        break;
                    }
                    System.out.println(accounts.get(id));
                    break;
            }

        }

    }

    private static void executeCreateCommand(Map<Integer, BankAccount> accounts, int id) {
        if(accounts.containsKey(id)){
            System.out.println("Account already exists");
        }else{
            BankAccount ba = new BankAccount();
            ba.setId(id);
            accounts.put(id,ba);
        }
    }
}
