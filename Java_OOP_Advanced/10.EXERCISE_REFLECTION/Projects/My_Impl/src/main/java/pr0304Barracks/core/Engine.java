package pr0304Barracks.core;

import pr0304Barracks.contracts.Executable;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Runnable;
import pr0304Barracks.contracts.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
	private static final String COMMAND_PATH = "pr0304Barracks.core.commands.";
	private static final String COMMAND_SUFFIX_NAME =  "Command";

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpredCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}
        }
    }

    // TODO: refactor for problem 4
    private String interpredCommand(String[] data, String commandName) {

		try {
			String commandClassName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
			Class<?> commandClass = Class.forName(COMMAND_PATH + commandClassName + COMMAND_SUFFIX_NAME);
			Constructor<?> declaredConstructor = commandClass.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
			Executable command = (Executable) declaredConstructor.newInstance(data, this.repository, this.unitFactory);

			return command.execute();
		} catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//			return new RuntimeException("Invalid command!");
			return null;
		}

    }
}
