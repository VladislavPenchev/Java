package entities;

import java.util.Map;

public class Cluster extends BaseEntity {
    private int rows;
    private int cols;
    private Map<String, Cell> cells;

    public Cluster(String id, int rows, int cols, Map<String, Cell> cells) {
        super(id);
        this.rows = rows;
        this.cols = cols;
        this.cells = cells;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Map<String, Cell> getCells() {
        return cells;
    }

    public void setCells(Map<String, Cell> cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res
                .append(System.lineSeparator())
                .append(String.format("----Cluster %s", this.getId()));

        return res.toString();
    }
}
