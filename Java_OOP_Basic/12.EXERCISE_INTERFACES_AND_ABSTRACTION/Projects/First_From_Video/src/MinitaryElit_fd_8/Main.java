package MinitaryElit_fd_8;

import MinitaryElit_fd_8.contracts.Private;
import MinitaryElit_fd_8.contracts.Soldier;
import MinitaryElit_fd_8.impl.LeutenantGeneralImpl;
import MinitaryElit_fd_8.impl.PrivateImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Soldier> soldiers = new LinkedHashMap<>();
        Map<String, Private> privates = new HashMap<>();

        String line;
        while(true){
            if("End".equals(line = reader.readLine())){
                break;
            }

            String[] tokens =  line.split("\\s+");

            String soldierType = tokens[0];
            String id = tokens[1];
            String firstName = tokens[2];
            String lastName = tokens[3];
            double salary;

            Soldier soldier = null;

            switch (soldierType){
                case "Private":
                    salary = Double.parseDouble(tokens[4]);
                    Private privateSoldier = new PrivateImpl(id, firstName, lastName, salary);
                    soldiers.put(id,privateSoldier);
                    privates.put(id,privateSoldier);
                    break;
                case "LeutenantGeneral":
                    salary = Double.parseDouble(tokens[4]);
                    List<String> privatesIds = Arrays.stream(tokens).skip(5).collect(Collectors.toList());
                    Set<Private> privatesSet = getPrivates(privatesIds, privates);
                    soldier = new LeutenantGeneralImpl(id, firstName, lastName, salary, privatesSet);
                    break;
                case "Engineer":
                    break;
                case "Commando":
                    break;
                case "Spy":
                    break;
            }

            if(soldier != null){
                soldiers.put(id, soldier);
            }
        }

        soldiers.values()
                .forEach(s -> System.out.print(soldiers.toString()));
    }

    private static Set<Private> getPrivates(List<String> privatesIds, Map<String, Private> privates) {

        return  privates
                .values()
                .stream()
                .filter(p -> privatesIds.contains(p.getId()))
                .collect(Collectors.toSet());

    }

}
