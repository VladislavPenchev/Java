package io;

public class ConsoleOutputWriter implements interfaces.Writer {

    @Override
    public void writeLine(String output){
        System.out.println(output);
    }
}
