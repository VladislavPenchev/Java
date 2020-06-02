package app.engines;

        import app.core.NationsManager;
        import app.io.ConsoleInputReader;
        import app.io.ConsoleOutputWriter;
        import app.utilities.InputParser;


public class Engine {

    private ConsoleInputReader reader;
    private ConsoleOutputWriter writer;
    private InputParser parser;
    private NationsManager manager;

    public Engine(){
        this.reader = new ConsoleInputReader();
        this.writer = new ConsoleOutputWriter();
        this.parser = new InputParser();
        this.manager = new NationsManager();
    }

    public void run() {
        String inputLine;

        while(true){
            inputLine = this.reader.readLine();

            if("Quit".equals(inputLine)){
                return;
            }

            String[] commandParams = this.parser.splitter(inputLine);

            this.dispatchCommand(commandParams);

        }
    }

    private void dispatchCommand(String[] commandParams) {
        String command = commandParams[0];

        String result = null;
        String type = null;

        switch(command){
            case "Bender":
                type = commandParams[1];
                String benderName = commandParams[2];
                int power = Integer.parseInt(commandParams[3]);
                double secondoryProperty = Double.parseDouble(commandParams[4]);

                this.manager.benderCommands(type,benderName,power,secondoryProperty);

                break;
            case "Monument":
                break;
            case "Status":

                type = commandParams[1];

                result = this.manager.statusCommand(type);

                this.writer.print(result);

                break;
            case "War":
                break;
        }

    }


}
