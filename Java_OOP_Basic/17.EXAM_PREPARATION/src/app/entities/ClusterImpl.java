package app.entities;

import app.contracts.Cell;
import app.contracts.Cluster;
import app.entities.cells.BaseCell;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ClusterImpl implements Cluster {

    private String id;
    private int rows;
    private int cols;
    private BaseCell[][] cells;

    public ClusterImpl(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new BaseCell[rows][cols];
    }

    public String getId() {
        return this.id;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    public void addCell(BaseCell cell){
        this.cells[cell.getPositionRow()][cell.getPositionCow()] = cell;
    }

    public int getCellsCount() {

        int count = 0;


            for (Cell[] cells : this.getCells()) {
                for (Cell cell : cells) {
                    if(cell != null){
                        count++;
                    }
                }
            }


        return count;
    }

    public void activate() {
        List<BaseCell> cellList = new LinkedList<>();

        for (BaseCell[] cells : cells) {
            for (BaseCell cell : cells){
                if (cell != null) {
                    cellList.add(cell);

                }
            }
        }

        while (cellList.size() > 0){
            if(cellList.size() == 1){
                break;
            }
            BaseCell startCell = cellList.get(0);
            cellList.remove(0);

            int row = cellList.get(0).getPositionRow();
            int col = cellList.get(0).getPositionCow();


            BaseCell secondCell = cellList.get(0);
            cellList.remove(0);
            BaseCell winner = fight(startCell,secondCell);
            cellList.add(0, winner);
        }

        this.cells = new BaseCell[rows][cols];
        for (BaseCell cell : cellList) {
            this.cells[cell.getPositionRow()][cell.getPositionCow()] = cell;
        }
    }

    private BaseCell fight(BaseCell startCell, BaseCell baseCell) {
        String cellType = startCell.getClass().getSimpleName();

        switch(cellType){
            case "RedBloodCell":
            case "WhiteBloodCell":
                startCell.setHealth(startCell.getHealth() + baseCell.getHealth());
                startCell.setPositionRow(baseCell.getPositionRow());
                startCell.setPositionCow(baseCell.getPositionCow());
                return startCell;
            default:
                while(true){
                    int startCellHealth = startCell.getHealth();
                    int secondCellHealth = baseCell.getHealth();

                    baseCell.setHealth(baseCell.getHealth() - startCell.getEnergy());

                    if(baseCell.getHealth() <= 0){
                        startCell.setPositionRow(baseCell.getPositionRow());
                        startCell.setPositionCow(baseCell.getPositionCow());

                        return startCell;
                    }
                    startCell.setHealth(startCell.getHealth() - baseCell.getEnergy());
                    if(baseCell.getHealth() <= 0){
                        baseCell.setPositionRow(startCell.getPositionRow());
                        baseCell.setPositionCow(startCell.getPositionCow());

                        return baseCell;
                    }

                }
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("----Cluster %s%n", this.id));

        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[0].length; j++){
                BaseCell cell = cells[i][j];
                if(cell != null){
                    sb.append(cell.toString());
                }
            }
        }

        return  sb.toString();
    }

}
