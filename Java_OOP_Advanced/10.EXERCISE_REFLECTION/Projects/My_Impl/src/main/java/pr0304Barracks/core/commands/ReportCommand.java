package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.data.UnitRepository;

public class ReportCommand extends BaseCommand {


    public ReportCommand(String[] data, UnitRepository unitRepository, UnitFactory unitFactory) {
        super(data, unitRepository, unitFactory);
    }

    @Override
    public String execute() {
        String output = super.getUnitRepository().getStatistics();
        return output;
    }
}
