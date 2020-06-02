package core;

import model.GameObject;

import static core.Main.enemy;
import static core.Main.player;

public class Field implements GameObject {
    private char[][] field;

    public Field() {
        this.field = new char[16][16];
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                this.field[i][j] = '-';
            }
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void rendered() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if(checkCellMatch(i, j, player.getRow(), player.getCol())) {
                    this.field[i][j] = 'P';
                } else if(checkCellMatch(i, j, enemy.getRow(), enemy.getCol())) {
                    this.field[i][j] = 'E';
                } else {
                    this.field[i][j] = '-';
                }
                System.out.print(this.field[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean checkCellMatch(int r, int c, int outsideRow, int outsideCol) {
        return r == outsideRow && c == outsideCol;
    }

}
