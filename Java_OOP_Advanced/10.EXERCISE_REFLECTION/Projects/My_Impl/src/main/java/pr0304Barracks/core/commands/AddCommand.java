package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.data.UnitRepository;

public class AddCommand extends BaseCommand {

    public AddCommand(String[] data, UnitRepository unitRepositories, UnitFactory unitFactories) {
        super(data, unitRepositories, unitFactories);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);

        super.getUnitRepository().addUnit(unitToAdd);

        return unitType + " added!";
    }
}
