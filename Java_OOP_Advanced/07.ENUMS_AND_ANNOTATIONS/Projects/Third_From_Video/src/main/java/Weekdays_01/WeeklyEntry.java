package Weekdays_01;

import java.util.Comparator;

public class WeeklyEntry {
    public static final Comparator<WeeklyEntry> WEEKLY_ENTRY_COMPARATOR = getComparator();

    private Weekday day;
    private String notes;

    public WeeklyEntry(String day, String notes) {
        this.day = Enum.valueOf(Weekday.class, day.toUpperCase());
        this.notes = notes;
    }

    private static Comparator<WeeklyEntry> getComparator() {
        return Comparator.comparingInt(e -> e.day.ordinal());
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.day, this.notes);
    }
}
