package command;

import core.Main;

import static core.Main.player;

public class MoveUp implements Command {

    @Override
    public void execute() {
        player.increaseRow();
    }
}
