package net.dispachers;


import net.commands.GameOverCommand;
import net.enums.CommandType;
import net.exceptions.GameException;
import net.factories.CommandFactory;
import net.interfaces.Battleground;
import net.interfaces.Command;
import net.interfaces.Repository;
import net.interfaces.Unit;

import java.util.HashMap;
import java.util.Map;

public class CommandDispatcher {

    private Map<String, Command> commands;

    public CommandDispatcher(Battleground battleground, Repository<Unit> unitRepository) {
        this.commands = new HashMap<>();
        this.seedCommands(battleground, unitRepository);
    }

    public String dispatchCommand(String[] args) throws GameException {
        switch (args[0]) {
            case "game-over":
                return new GameOverCommand().execute(args);
            default:
                return new Command().execute(args);
        }
    }

    private void seedCommands(Battleground battleground, Repository<Unit> unitRepository) {
        commands.put(CommandType.SPAWN.toString(), CommandFactory.createCommand(CommandType.SPAWN, battleground, unitRepository));
    }
}
