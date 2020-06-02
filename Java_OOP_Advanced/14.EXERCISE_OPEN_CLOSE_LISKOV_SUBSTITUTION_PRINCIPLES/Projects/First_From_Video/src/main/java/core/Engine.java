package core;

import annotations.Inject;
import interfaces.Executable;
import interfaces.Reader;
import interfaces.Writer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND = "drop";
    private static final String COMMAND_PATH = "core.commands.";
    private static final String COMMAND_SUFFIX_NAME = "Command";

    private String[] data;
    private Reader reader;
    private Writer writer;

    public Engine(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() {
        while (true) {
            String userInput = this.reader.readLine();

            if (TERMINATE_COMMAND.equals(userInput)) {
                break;
            }

            String[] args = userInput.split("\\s+");
            this.interpredCommand(args, args[0]);

        }
    }

    private String parseCommandName(String commandName) {
        return String.valueOf(commandName.charAt(0)).toUpperCase() + commandName.substring(1);
    }

    private void interpredCommand(String[] data, String commandName) {
        this.data = Arrays.stream(data).skip(1).toArray(String[]::new);

        try {
            String commandClassName = parseCommandName(commandName);
            Class<?> commandClass = Class.forName(COMMAND_PATH + commandClassName + COMMAND_SUFFIX_NAME);
            Constructor<?> declaredConstructor = commandClass.getDeclaredConstructor();
            Executable command = (Executable) declaredConstructor.newInstance();

            this.injectDependencies(command);

            command.execute();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Invalid command!");
        }

    }

    private <T> void injectDependencies(T command) throws IllegalAccessException {
        Field[] commandFields = command.getClass().getDeclaredFields();

        Field[] engineFields = this.getClass().getDeclaredFields();

        for (Field commandField : commandFields) {
            commandField.setAccessible(true);
            if (commandField.isAnnotationPresent(Inject.class)) {
                for (Field engineField : engineFields) {
                    if (commandField.getType().getSimpleName().equals(engineField.getType().getSimpleName())
                            && commandField.getType().equals(engineField.getType())) {
                        commandField.set(command, engineField.get(this));
                    }
                }
            }
        }
    }

}
