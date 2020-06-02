package BorderControl_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<BaseEntity> baseEntities = new ArrayList<>();

        String line;
        while (!"End".equals(line = bufferedReader.readLine())) {
            String[] lineArgs = line.split("\\s+");

            if(lineArgs.length == 2){
                BaseEntity robot = new Robot(lineArgs[1], lineArgs[0]);
                baseEntities.add(robot);
            }else {
                BaseEntity human = new Human(lineArgs[2], lineArgs[0], Integer.parseInt(lineArgs[1]));
                baseEntities.add(human);
            }
        }

        String fakeId = bufferedReader.readLine();

        baseEntities.stream()
                .filter(e -> {
                    int fakeIdLength = fakeId.length();
                    String lastNumbersFromId = e.getId().substring(e.getId().length() - fakeIdLength);
                    if(fakeId.equals(lastNumbersFromId)){
                        return true;
                    }
                    return false;
                })
                .map(BaseEntity::getId)
                .forEach(e -> System.out.println(e));
    }
}
