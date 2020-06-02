package net.factories;

import net.commands.MoveCommand;
import net.enums.CommandType;
import net.interfaces.Battleground;
import net.interfaces.Command;
import net.interfaces.Repository;
import net.interfaces.Unit;

public final class CommandFactory {
    private CommandFactory() {}

    public static Command createCommand(CommandType type, Battleground battleground, Repository<Unit> unitRepository) {
        switch (type) {
            case MOVE:
                return null;
            case FIGHT:
                return null;
            case STATUS:
                return null;
            case SPAWN:
                return null;
            case GAME_OVER:
                return null;
            default: return null;
        }
    }
}
