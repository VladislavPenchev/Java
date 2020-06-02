package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.data.UnitRepository;

public class RetireCommand extends BaseCommand {

    public RetireCommand(String[] data, UnitRepository unitRepository, UnitFactory unitFactory) {
        super(data, unitRepository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];

        super.getUnitRepository().removeUnit(unitType);

        return unitType + " added!";
    }
}
