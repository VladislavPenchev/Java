package net.io;

import net.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
