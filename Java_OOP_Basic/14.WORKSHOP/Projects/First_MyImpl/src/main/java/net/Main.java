package net;


import net.core.GameEngine;
import net.dispachers.CommandDispatcher;
import net.io.ConsoleWriter;

public class Main {

    public static void main(String[] args) {
        ConsoleWriter writer = new ConsoleWriter();
        CommandDispatcher commandDispatcher = new CommandDispatcher();

        GameEngine gameEngine = new GameEngine(writer, commandDispatcher);
        gameEngine.start();
    }
}
