package net.java.main.commands;

import net.java.main.exceptions.GameException;
import net.java.main.interfaces.Command;

public class CommandImpl implements Command {

    public String execute(String[] args) throws GameException {
        throw new GameException("Invalid command");
    }
}
