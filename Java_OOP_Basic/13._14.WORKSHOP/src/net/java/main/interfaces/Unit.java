package net.java.main.interfaces;

public interface Unit {

    String getName();
    int getRange();
    Position getPosition();
    void setPosition(Position position);
    int getHealthPoints();
    void setHealthPoints(int points);
    int getEnergyPoints();
    void setEnergyPoints(int points);
    int getAttackPoints();
    int getDefencePoints();
    CombatHandler getCombatHandler();
}
