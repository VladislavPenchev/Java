package net.java.main.dispachers;

import net.java.main.enums.CommandType;
import net.java.main.exceptions.GameException;
import net.java.main.factories.CommandFactory;
import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Command;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;

import java.util.HashMap;
import java.util.Map;

public class CommandDispatcher {

    private Map<String, Command> commands;

    public CommandDispatcher(Battleground battleground, Repository<Unit> unitRepository) {
        this.commands = new HashMap<>();
        this.seedCommands(battleground,unitRepository);
    }



    public String dispatchCommand(String[] args) throws GameException {
        if(this.commands.containsKey(args[0])) {
            return this.commands.get(args[0]).execute(args);
        }

        throw new GameException("Invalid command");
    }

    private void seedCommands(Battleground battleground, Repository<Unit> unitRepository) {
        commands.put(CommandType.SPAWN.toString(),
                CommandFactory.createCommand(CommandType.SPAWN, battleground, unitRepository));

        commands.put(CommandType.FIGHT.toString(),
                CommandFactory.createCommand(CommandType.FIGHT, battleground, unitRepository));

        commands.put(CommandType.MOVE.toString(),
                CommandFactory.createCommand(CommandType.MOVE, battleground, unitRepository));

        commands.put(CommandType.STATUS.toString(),
                CommandFactory.createCommand(CommandType.STATUS, battleground, unitRepository));

        commands.put(CommandType.GAVE_OVER.toString(),
                CommandFactory.createCommand(CommandType.GAVE_OVER, battleground, unitRepository));
    }
}
