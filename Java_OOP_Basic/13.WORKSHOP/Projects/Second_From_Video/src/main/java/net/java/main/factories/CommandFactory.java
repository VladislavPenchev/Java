package net.java.main.factories;

import net.java.main.commands.GameOverCommand;
import net.java.main.enums.CommandType;
import net.java.main.interfaces.Command;

public class CommandFactory {

    //TODO:
    public Command createCommand(CommandType type){
        switch (type) {
            case MOVE:
//                return new MoveCommand();
            case FIGHT:
//                return new FightCommand();
            case STATUS:
//                return new StatusCommand();
            case SPAWN:
//                return new SpawnCommand();
            case GAME_OVER:
                return new GameOverCommand();
            default: return null;
        }
    }
}
