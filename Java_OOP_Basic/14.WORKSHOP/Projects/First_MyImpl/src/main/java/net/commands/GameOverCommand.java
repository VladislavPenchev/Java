package net.commands;

import net.interfaces.Command;

public class GameOverCommand implements Command {

    @Override
    public String execute(String[] args) {
        return "Game over!";
    }
}
