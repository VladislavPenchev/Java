package core;

import command.CommandInterpreter;
import command.CommandListener;
import model.Enemy;
import model.GameObject;
import model.Initializer;
import model.Player;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<GameObject> gameObjects;
    public static Player player;
    public static Enemy enemy;

    public static void main(String[] args) throws InterruptedException {
        gameObjects = Initializer.init();

        Scanner scanner = new Scanner(System.in);

        for (GameObject gameObject : gameObjects) {
            if(gameObject instanceof Player) {
                player = (Player) gameObject;
            } else if( gameObject instanceof Enemy) {
                enemy = (Enemy) gameObject;
            }
        }

        CommandListener handler = new CommandInterpreter();

//        gameObjects.add(new Player(dataStorage.load(Player.class)[0],dataStorage.load(Player.class)[1]));
//        gameObjects.add(new Enemy(dataStorage.load(Enemy.class)[0],dataStorage.load(Enemy.class)[1]));

        boolean gameOver = false;

        String input = "";

        while (!gameOver) {
            ArrayList<GameObject> copy = new ArrayList<>(Main.gameObjects);

            for (GameObject gameObject : copy) {
                gameObject.update();
                gameObject.rendered();
            }

            Thread.sleep(500);

            System.out.println();
            System.out.println();
            System.out.println("============================");
            System.out.println("Enter nrw command: ");

            input = scanner.nextLine();

            try{
                handler.handleCommand(input);
            }catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println();
            System.out.println();
        }

    }
}
