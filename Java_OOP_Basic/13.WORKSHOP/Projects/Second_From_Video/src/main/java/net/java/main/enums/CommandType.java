package net.java.main.enums;

public enum CommandType {
    SPAWN,
    STATUS,
    MOVE,
    FIGHT,
    GAME_OVER;


    public String getName() {
        return this.name().replace("_", "-");
    }
}
