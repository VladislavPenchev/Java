package app.engines;

        import app.io.ConsoleInputReader;
        import app.io.ConsoleOutputWriter;
        import app.utilities.InputParser;


public class Engine {

    private ConsoleInputReader reader;
    private ConsoleOutputWriter writer;
    private InputParser parser;

    public Engine(){
        this.reader = new ConsoleInputReader();
        this.writer = new ConsoleOutputWriter();
        this.parser = new InputParser();
    }

    public void run() {
        String inputLine;

        while(true){
            inputLine = this.reader.readLine();

            String[] commandParams = this.parser.splitter(inputLine);

            this.dispatchCommand(commandParams);
        }
    }

    private void dispatchCommand(String[] commandParams) {
        String command = commandParams[0];

        switch(command){
            case "":
                break;
        }

    }


}
