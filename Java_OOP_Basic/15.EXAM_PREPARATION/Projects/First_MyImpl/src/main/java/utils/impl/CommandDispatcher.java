package utils.impl;

import engine.HealthManager;
import engine.HealthManagerImpl;
import utils.Reader;

import java.io.IOException;

public class CommandDispatcher {

    private Reader consoleReader;
    private StringBuilder stringBuilder;
    private HealthManager healthManager;

    public CommandDispatcher() {
        this.stringBuilder = new StringBuilder();
        this.consoleReader = new ConsoleReader();
        this.healthManager = new HealthManagerImpl();
    }

    public String start() throws IOException {
        String line;
        while (!"BEER IS COMING".equals(line = consoleReader.readLine())) {
            String[] lineArgs = line.split("\\s+");
            String command = lineArgs[0];
            String organismName;
            String id;
            int rows;
            int cols;

            switch (command) {
                case "checkCondition":
                    organismName = lineArgs[1];
                    stringBuilder.append(healthManager.checkCondition(organismName));
                    break;
                case "createOrganism":
                    organismName = lineArgs[1];
                    stringBuilder.append(healthManager.createOrganism(organismName));
                    break;
                case "addCluster":
                    organismName = lineArgs[1];
                    id = lineArgs[2];
                    rows = Integer.parseInt(lineArgs[3]);
                    cols = Integer.parseInt(lineArgs[4]);
                    stringBuilder.append(healthManager.addCluster(organismName, id, rows, cols));
                    break;
                case "addCell":
                    organismName = lineArgs[1];
                    id = lineArgs[2];
                    String cellType = lineArgs[3];
                    String cellId = lineArgs[4];
                    int health = Integer.parseInt(lineArgs[5]);
                    rows = Integer.parseInt(lineArgs[6]);
                    cols = Integer.parseInt(lineArgs[7]);
                    int additionalPropery = Integer.parseInt(lineArgs[8]);
                    stringBuilder.append(healthManager.addCell(organismName, id, cellType, cellId, health, rows, cols, additionalPropery));
                    break;
                case "activateCluster":
                    organismName = lineArgs[1];
                    stringBuilder.append(healthManager.activateCluster(organismName));
                    break;
            }
        }

        return stringBuilder.toString();
    }
}
