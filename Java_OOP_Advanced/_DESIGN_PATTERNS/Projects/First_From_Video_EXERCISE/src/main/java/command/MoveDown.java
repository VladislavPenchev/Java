package command;

import core.Main;

import static core.Main.player;

public class MoveDown implements Command {
    @Override
    public void execute() {
        player.decreaseRow();
    }
}
