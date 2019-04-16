package app.engines;

import app.contracts.HealthManager;
import app.core.HealthManagerImpl;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.utilities.Constants;
import app.utilities.InputParser;

import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private HealthManager healthManager;

    public Engine(){
        this.inputReader = new ConsoleInputReader();
        this.outputWriter = new ConsoleOutputWriter();
        this.inputParser = new InputParser();
        this.healthManager = new HealthManagerImpl();
    }

    public void run(){
        String inputLine = null;

        while(true){
            inputLine = this.inputReader.readLine();

            List<String> commandParams = null;

            if(Constants.TERMINAL_COMMAND.equals(inputLine)){
                return;
            }else{
                commandParams = this.inputParser.parseInput(inputLine);
            }

            this.dispatchCommand(commandParams);
        }
    }

    public void dispatchCommand(List<String> commandParams){
        String command = commandParams.get(0);

        String organismName = null;
        String clusterId = null;
        int rows = -1;
        int cols = -1;

        String commandResult = Constants.EMPTY_STRING;

        switch(command){
            case "checkCondition":

                organismName = commandParams.get(1);

                commandResult = this.healthManager.checkCondition(organismName);

                if(!Constants.EMPTY_STRING.equals(commandResult)){
                    this.outputWriter.writeLine(commandResult);
                }
            break;
            case "createOrganism":
                organismName = commandParams.get(1);

                this.outputWriter
                        .writeLine(this.healthManager.createOrganism(organismName));
            break;
            case "addCluster":
                organismName = commandParams.get(1);
                clusterId = commandParams.get(2);
                rows = Integer.parseInt(commandParams.get(3));
                cols = Integer.parseInt(commandParams.get(4));

                commandResult = this.healthManager.addCluster(organismName,clusterId,rows,cols);

                if(Constants.EMPTY_STRING.equals(commandResult)){
                    this.outputWriter.writeLine(commandResult);
                }

            break;
            case "addCell":

                organismName = commandParams.get(1);
                clusterId = commandParams.get(2);
                String cellType = commandParams.get(3);
                String cellId = commandParams.get(4);
                int health = Integer.parseInt(commandParams.get(5));
                rows = Integer.parseInt(commandParams.get(6));
                cols = Integer.parseInt(commandParams.get(7));
                int addProperty = Integer.parseInt(commandParams.get(8));

                commandResult = this.healthManager
                        .addCell(organismName, clusterId, cellType, cellId, health, rows, cols, addProperty);

                if(!Constants.EMPTY_STRING.equals(commandResult)){
                     this.outputWriter.writeLine(commandResult);
                }
            break;
            case "activateCluster":
                    organismName = commandParams.get(1);
                    commandResult = this.healthManager.activateCluster(organismName);

                if(!Constants.EMPTY_STRING.equals(commandResult)){
                    this.outputWriter.writeLine(commandResult);
                }
            break;
        }


    }

}
