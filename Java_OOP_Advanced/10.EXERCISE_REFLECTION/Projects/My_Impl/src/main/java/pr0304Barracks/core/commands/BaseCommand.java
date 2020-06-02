package pr0304Barracks.core.commands;

import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.data.UnitRepository;

public abstract class BaseCommand implements Executable {
    private String[] data;
    private UnitRepository unitRepository;
    private UnitFactory unitFactory;

    public BaseCommand(String[] data, UnitRepository unitRepository, UnitFactory unitFactory) {
        this.data = data;
        this.unitRepository = unitRepository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return data;
    }

    protected UnitRepository getUnitRepository() {
        return unitRepository;
    }

    protected UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
