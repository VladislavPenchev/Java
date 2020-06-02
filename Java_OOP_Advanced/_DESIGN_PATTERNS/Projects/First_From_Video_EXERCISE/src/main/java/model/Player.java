package model;

import core.Main;
import shared.Factory;
import shared.Movable;
import shared.StoneFactory;

import java.util.concurrent.ThreadLocalRandom;

public class Player implements GameObject, Movable {

    private int healthPoints;
    private int damage;
    private int row;
    private int col;

    private Factory factory;

    public Player(int healthPoints, int damage) {
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.factory = new StoneFactory();
        this.row = 15;
        this.col = 7;
    }

    public void update() {
        int nextInt = ThreadLocalRandom.current().nextInt(1000);

        if(nextInt % 3 == 0) {
            Main.gameObjects.add(factory.produce());
        } else if(nextInt % 5 == 0) {
            Main.gameObjects.removeIf(g -> g.getClass().getSimpleName().equals("stone"));
        }

        System.out.println("Player updated");
    }

    public void rendered() {
        System.out.println("Player rendered");
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getCol() {
        return this.col;
    }

    @Override
    public void decreaseRow() {
        this.row = this.row != 0 ? this.row - 1 : 0;
    }

    @Override
    public void increaseRow() {
        this.row = this.row != 15 ? this.row + 1 : 15;
    }

    @Override
    public void decreaseCol() {
        this.col = this.col != 0 ? this.col - 1 : 0;
    }

    @Override
    public void increaseCol() {
        this.col = this.col != 15 ? this.col + 1 : 15;
    }
}
