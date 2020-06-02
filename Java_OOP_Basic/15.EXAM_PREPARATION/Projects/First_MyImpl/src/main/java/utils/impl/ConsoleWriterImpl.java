package utils.impl;

import utils.Writer;

public class ConsoleWriterImpl implements Writer {

    @Override
    public void write(String output) {
        System.out.println(output);
    }
}
