package net.java.main.comparators;

import net.java.main.models.units.BaseUnit;

import java.util.Comparator;

public class UnitComparatorByName implements Comparator<BaseUnit> {
    @Override
    public int compare(BaseUnit unit1, BaseUnit unit2) {
        return unit1.getName().compareTo(unit2.getName());
    }
}
