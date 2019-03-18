package net.java.main.dispachers;

import net.java.main.commands.Command;
import net.java.main.commands.GameOverCommand;
import net.java.main.enums.CommandType;
import net.java.main.exceptions.GameException;

import java.util.HashMap;
import java.util.Map;

public class CommandDispatcher {

    private Map<String, Command> commands;
    //TODO: add battleField;

    public CommandDispatcher(Map<String, Command> commands) {
        this.commands = new HashMap<>();
        this.seedCommands();
    }


    public String dispatchCommand(String[] args) throws GameException {
        //TODO:
    }

    private void seedCommands() {
        commands.put(CommandType.SPAWN.toString(), new SpawnCommand);
    }
}
