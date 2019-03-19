package net.java.main.enums;

public enum CommandType {
    SPAWN,
    STATUS,
    MOVE,
    FIGHT,
    GAVE_OVER;

    @Override
    public String toString() {
        return this.name()
                .replace("_", "-")
                .toLowerCase();
    }
}
