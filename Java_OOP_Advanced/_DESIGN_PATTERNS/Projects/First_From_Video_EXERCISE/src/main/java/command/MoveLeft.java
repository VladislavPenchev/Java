package command;

import core.Main;

public class MoveLeft implements Command {

    @Override
    public void execute() {
        Main.player.decreaseCol();
    }
}
