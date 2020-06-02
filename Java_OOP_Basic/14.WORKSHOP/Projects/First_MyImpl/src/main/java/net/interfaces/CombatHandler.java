package net.interfaces;


import net.models.spells.BaseSpell;

import java.util.List;

public interface CombatHandler {

    void setUnit(Unit baseUnit);

    Unit pickNextTarget(List<Unit> targetCandidates);

    Spell generateAttack();
}
