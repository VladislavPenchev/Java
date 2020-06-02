package model;

import shared.Movable;

public class Enemy implements GameObject, Movable {

    private int healthPoints;
    private int damage;
    private int row;
    private int col;

    public Enemy(int healthPoints, int damage) {
        this.healthPoints = healthPoints;
        this.damage = damage;
        this.row = 0;
        this.col = 7;
    }

    public void update() {
    }

    public void rendered() {
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
    public void increaseRow() {

    }

    @Override
    public void increaseCol() {

    }

    @Override
    public void decreaseRow() {

    }

    @Override
    public void decreaseCol() {

    }
}
