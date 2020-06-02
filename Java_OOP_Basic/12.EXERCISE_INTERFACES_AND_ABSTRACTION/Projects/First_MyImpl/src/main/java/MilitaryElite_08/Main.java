package MilitaryElite_08;

import MilitaryElite_08.contracts.Mission;
import MilitaryElite_08.contracts.Private;
import MilitaryElite_08.contracts.Repaire;
import MilitaryElite_08.contracts.Soldier;
import MilitaryElite_08.impl.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Soldier> soldiers = new LinkedHashMap<>();
        Map<String, Private> privates = new HashMap<>();

        String line;
        while (!"End".equals(line = bufferedReader.readLine())) {
            String[] tokens = line.split("\\s+");
            String soldierType = tokens[0];
            String id = tokens[1];
            String firstName = tokens[2];
            String lastName = tokens[3];
            double salary;

            Soldier soldier = null;
            switch (soldierType) {
                case "Private":
                    salary = Double.parseDouble(tokens[4]);
                    Private privateSoldier = new PrivateImpl(id, firstName, lastName, salary);
                    soldiers.put(id, privateSoldier);
                    privates.put(id, privateSoldier);
                    break;
                case "LeutenantGeneral":
                    salary = Double.parseDouble(tokens[4]);
                    List<String> privatesIds = Arrays.stream(tokens).skip(5).collect(Collectors.toList());
                    Set<Private> privatesSet = getPrivates(privatesIds, privates);
                    soldier = new LeutenantGeneralImpl(id, firstName, lastName, salary, privatesSet);
                    break;
                case "Engineer":
                    try {
                        salary = Double.parseDouble(tokens[4]);
                        String corps = tokens[5];
                        String[] repairsTokens = Arrays.stream(tokens).skip(6).toArray(String[]::new);
                        Set<Repaire> repaires = createRepairs(repairsTokens);
                        soldier = new EngineerImpl(id, firstName, lastName, salary, corps, repaires);
                    } catch (IllegalArgumentException ignored) {
                        ;
                    }
                    break;
                case "Commando":
                    salary = Double.parseDouble(tokens[4]);
                    String corps = tokens[5];
                    String[] missionsTokens = Arrays.stream(tokens).skip(6).toArray(String[]::new);
                    Set<Mission> missions = createMissions(missionsTokens);
                    soldier = new CommandoImpl(id, firstName, lastName, salary, corps, missions);

                    break;
                case "Spy":
                    String codeNumber = tokens[4];
                    soldier = new SpyImpl(id, firstName, lastName, codeNumber);
                    break;
            }

            if (soldier != null) {
                soldiers.put(id, soldier);
            }
        }

        soldiers.values().forEach(System.out::println);
    }

    private static Set<Mission> createMissions(String[] missionsTokens) {
        Set<Mission> missions = new LinkedHashSet<>();

        Mission mission;
        for (int i = 0; i < missionsTokens.length; i += 2) {
            String codeName = missionsTokens[i];
            String state = missionsTokens[i + 1];

            try {
                mission = new MissionImpl(codeName, state);
                missions.add(mission);
            } catch (IllegalArgumentException ignored) {
                ;
            }
        }
        return missions;
    }

    private static Set<Repaire> createRepairs(String[] repairsTokens) {
        Set<Repaire> repaires = new LinkedHashSet<>();

        for (int i = 0; i < repairsTokens.length; i += 2) {
            String partName = repairsTokens[i];
            int hoursWork = Integer.parseInt(repairsTokens[i + 1]);

            Repaire repaire = new RepaireImpl(partName, hoursWork);

            repaires.add(repaire);
        }
        return repaires;
    }

    private static Set<Private> getPrivates(List<String> privatesIds, Map<String, Private> privates) {
        return privates.values()
                .stream()
                .filter(p -> privatesIds.contains(p.getId()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

    }
}
