package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.data.UnitRepository;

public class FightCommand extends BaseCommand{

    public FightCommand(String[] data, UnitRepository unitRepository, UnitFactory unitFactory) {
        super(data, unitRepository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
