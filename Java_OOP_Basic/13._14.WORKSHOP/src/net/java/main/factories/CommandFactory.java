package net.java.main.factories;

import net.java.main.commands.GameOverBaseCommand;
import net.java.main.enums.CommandType;
import net.java.main.interfaces.Command;

public final class CommandFactory {

    private CommandFactory(){

    }

    //TODO:

    public static Command createCommand(CommandType type){

        switch (type){
            case MOVE:
                //return new MoveCommand();
            case FIGHT:
                //return new FightCommand();
            case STATUS:
                //return new StatusCommand();
            case SPAWN:
                //return new SpawnCommand();
            case GAVE_OVER:
               return new GameOverBaseCommand();
            default: return null;
        }

    }
}
