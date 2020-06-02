package net.io;

import net.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements InputReader {

    private BufferedReader bufferedReader;

    public ConsoleReader() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }
}
