package warningLevels_02;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Message> messages;
    private Importance importanceLevel;

    public Logger(String importanceLevel) {
        this.messages = new ArrayList<>();
        this.importanceLevel = Enum.valueOf(Importance.class, importanceLevel.toUpperCase());
    }

    public void addMessage(String importance, String message) {
        Importance imp = Enum.valueOf(Importance.class, importance.toUpperCase());

        if(imp.compareTo(this.importanceLevel) >= 0){
            this.messages.add(new Message(importance, message));
        }
    }

    public Iterable<Message> getMessages() {
        return this.messages;
    }
}
