package p01_system_resources;

import java.time.LocalTime;

public class GreetingClock implements GreetingDevice{
    private TimeProvider time;
    private Writer writer;

    public GreetingClock(TimeProvider time, Writer writer) {
        this.time = time;
        this.writer = writer;
    }

    public void greeting() {
        if (time.getCurrentHour() < 12) {
            writer.writeLine("Good morning...");
        } else if (time.getCurrentHour() < 18) {
            writer.writeLine("Good afternoon...");
        } else {
            writer.writeLine("Good evening...");
        }
    }
}
