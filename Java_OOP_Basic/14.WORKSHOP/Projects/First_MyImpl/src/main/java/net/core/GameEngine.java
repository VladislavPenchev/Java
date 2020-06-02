package net.core;


import net.dispachers.CommandDispatcher;
import net.exceptions.GameException;
import net.interfaces.Engine;
import net.interfaces.InputReader;
import net.interfaces.OutputWriter;
import net.io.ConsoleReader;
import net.io.ConsoleWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameEngine implements Engine {

    private InputReader reader;
    private OutputWriter writer;
    private CommandDispatcher commandDispatcher;
    private boolean isStarted;

    public GameEngine(InputReader reader, OutputWriter writer , CommandDispatcher commandDispatcher) {
        this.writer = writer;
        this.reader = reader;
        this.commandDispatcher = commandDispatcher;
        isStarted = true;
    }

    @Override
    public void start() {

        while (isStarted) {
            try {
                String userInput = this.reader.readLine();
                String[] args = userInput.split("\\s+");

                String result = this.commandDispatcher.dispatchCommand(args);

                this.writer.writeLine(result);

                if (result.equals("Game over!")) {
                    this.isStarted = false;
                }
            } catch (IOException | GameException e) {
                this.writer.writeLine(e.getMessage());
            }
        }
    }
}
