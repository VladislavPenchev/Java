import commands.CommandDispatcher;
import io.Reader;
import io.Writter;

import java.io.IOException;

public class EngineImpl implements Engine {

    private Reader consoleReader;
    private Writter consoleWritter;
    private CommandDispatcher commandDispatcher;
    private boolean isActive;

    public EngineImpl(Reader consoleReader, Writter consoleWritter, CommandDispatcher commandDispatcher) {
        this.consoleReader = consoleReader;
        this.consoleWritter = consoleWritter;
        this.commandDispatcher = commandDispatcher;
        this.isActive = true;
    }

    @Override
    public void run()  {
        String lineArgs = null;

        while (isActive) {
            try {
                lineArgs = this.consoleReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if ("cops Are Here".equals(lineArgs)) {
                break;
            }

            commandDispatcher.dispatch(lineArgs);
        }
    }
}
