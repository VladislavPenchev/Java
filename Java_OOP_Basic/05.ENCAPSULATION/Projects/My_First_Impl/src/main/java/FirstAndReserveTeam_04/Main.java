package FirstAndReserveTeam_04;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Team team = new Team("Minior");
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            team.addPlayer(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
        }

        System.out.println("First team have " + team.getFirstTeam().size() + " players");
        System.out.println("Reverse team have " + team.getReverseTeam().size() + " players");

    }

}
