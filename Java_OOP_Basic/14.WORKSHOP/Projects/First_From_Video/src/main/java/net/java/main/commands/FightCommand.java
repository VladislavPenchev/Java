package net.java.main.commands;

import net.java.main.exceptions.GameException;
import net.java.main.interfaces.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FightCommand implements Command {

    private Battleground battleground;
    private Repository<Unit> unitRepository;

    public FightCommand(Battleground battleground, Repository<Unit> unitRepository) {
        this.battleground = battleground;
        this.unitRepository = unitRepository;
    }

    @Override
    public String execute(String[] args) throws GameException {
        List<Unit> killedUnit = new ArrayList<>();
        List<Unit> allLiveUnits = this.unitRepository.findAll()
                .stream()
                .filter(unit -> unit.getHealthPoints() > 0)
                .collect(Collectors.toList());

        if (allLiveUnits.size() < 2) {
            return "Not enough spawns for fight!";
        }

        StringBuilder result = new StringBuilder();

        for (Unit unit : allLiveUnits) {
            Position currentUnitPosition = unit.getPosition();
            int range = unit.getRange();
            List<Unit> targets = this.battleground.getUnitsInRange(currentUnitPosition.getX(), currentUnitPosition.getY(), range);

            if(targets.isEmpty()){
                continue;
            }
            Unit target = unit.getCombatHandler().pickNextTarget(targets);

            Spell spell = unit.getCombatHandler().generateAttack();

            if(spell.getDamage() > target.getDefencePoints()) {
                target.setHealthPoints(target.getHealthPoints() - spell.getDamage());

                result
                        .append(String.format("%s cast %s spell and did %d damage",
                                unit.getName(),
                                spell.getClass().getSimpleName(),
                                spell.getDamage()))
                        .append(System.lineSeparator());

                if(target.getHealthPoints() <= 0){
                    target.setHealthPoints(0);

                    result
                            .append(String.format("%s killed %s", unit.getName(), target.getName()))
                            .append(System.lineSeparator());
                }
            }
        }

        String resultString = result.toString().trim();

        if (resultString.isEmpty()){
            return "Units are outside range of their enemies, move closer and try again!";
        }

        return resultString;
    }
}
