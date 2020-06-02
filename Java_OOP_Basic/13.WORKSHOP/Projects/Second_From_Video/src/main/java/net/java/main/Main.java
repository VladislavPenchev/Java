package net.java.main;

import net.java.main.core.GameEngine;
import net.java.main.dispachers.CommandDispatcher;
import net.java.main.interfaces.Engine;
import net.java.main.interfaces.InputReader;
import net.java.main.interfaces.OutputWriter;
import net.java.main.io.ConsoleReader;
import net.java.main.io.ConsoleWriter;

public class Main {

    public static void main(String[] args) {
        InputReader reader = new ConsoleReader();
        OutputWriter writer = new ConsoleWriter();
        CommandDispatcher commandDispatcher = new CommandDispatcher();

        Engine gameEngine = new GameEngine(writer, commandDispatcher, reader);
        gameEngine.start();
    }
}
