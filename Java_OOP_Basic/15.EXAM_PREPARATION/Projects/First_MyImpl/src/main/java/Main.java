import utils.Reader;
import utils.Writer;
import utils.impl.CommandDispatcher;
import utils.impl.ConsoleReader;
import utils.impl.ConsoleWriterImpl;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CommandDispatcher dispatcher = new CommandDispatcher();

        String output = dispatcher.start();

        Writer writer = new ConsoleWriterImpl();
        writer.write(output);
    }
}
