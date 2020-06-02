package io;

import java.io.Writer;

public class ConsoleWriter implements Writter {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }
}
