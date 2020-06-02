package net.java.main.factories;

import net.java.main.commands.*;
import net.java.main.enums.CommandType;
import net.java.main.interfaces.Battleground;
import net.java.main.interfaces.Command;
import net.java.main.interfaces.Repository;
import net.java.main.interfaces.Unit;

public final class CommandFactory {

    private CommandFactory() {}

    //TODO:
    public static Command createCommand(CommandType type, Battleground battleground, Repository<Unit> unitRepository){
        switch (type) {
            case MOVE:
                return new MoveCommand(battleground, unitRepository);
            case FIGHT:
                return new FightCommand(battleground, unitRepository);
            case STATUS:
                return new StatusCommand(unitRepository);
            case SPAWN:
                return new SpawnCommand(battleground, unitRepository);
            case GAME_OVER:
                return new GameOverCommand();
            default: return null;
        }
    }
}
