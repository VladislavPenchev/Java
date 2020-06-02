package command;

import java.util.Map;

public class CommandInterpreter implements CommandListener {
    private Map<String, Command> commands = Map.of(
            "W", new MoveUp(),
            "S", new MoveDown(),
            "A", new MoveLeft(),
            "D", new MoveRight());

    @Override
    public void handleCommand(String type) {
        Command command = commands.get(type.toUpperCase());
        if (command == null) {
            throw new IllegalArgumentException("Invalid command type");
        }
        command.execute();
    }
}
