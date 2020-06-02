package p00_test;

import java.io.IOException;
import java.io.Writer;

public class Engine {
    private Writer writer;

    public Engine(Writer writer) {
        this.writer = writer;
    }

    public void result() throws IOException {
        writer.write("dada");
    }
}
