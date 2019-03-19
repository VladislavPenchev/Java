package net.java.main.dispachers;

import net.java.main.enums.CommandType;
import net.java.main.exceptions.GameException;
import net.java.main.factories.CommandFactory;
import net.java.main.interfaces.Command;

import java.util.HashMap;
import java.util.Map;

public class CommandDispatcher {

    private Map<String, Command> commands;
    //TODO: add battleField;

    public CommandDispatcher() {
        this.commands = new HashMap<>();
        this.seedCommands();
    }



    public String dispatchCommand(String[] args) throws GameException {
        if(this.commands.containsKey(args[0])) {
            return this.commands.get(args[0]).execute(args);
        }

        throw new GameException("Invalid command");
    }

    private void seedCommands() {
        commands.put(CommandType.SPAWN.toString(),
                CommandFactory.createCommand(CommandType.SPAWN));

        commands.put(CommandType.FIGHT.toString(),
                CommandFactory.createCommand(CommandType.FIGHT));

        commands.put(CommandType.MOVE.toString(),
                CommandFactory.createCommand(CommandType.MOVE));

        commands.put(CommandType.STATUS.toString(),
                CommandFactory.createCommand(CommandType.STATUS));

        commands.put(CommandType.GAVE_OVER.toString(),
                CommandFactory.createCommand(CommandType.GAVE_OVER));
    }
}
