package app.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader {
    private BufferedReader bufferedReader;

    public ConsoleInputReader(){
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine(){
        String result = null;

        try {
            result = this.bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
