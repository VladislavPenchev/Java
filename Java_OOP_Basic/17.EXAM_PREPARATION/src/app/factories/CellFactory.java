package app.factories;

import app.entities.cells.BaseCell;
import app.entities.cells.bloodcells.RedBloodCell;
import app.entities.cells.bloodcells.WhiteBloodCell;
import app.entities.cells.microbes.Bacteria;
import app.entities.cells.microbes.Fungi;
import app.entities.cells.microbes.Virus;


public final class CellFactory {

    private CellFactory(){

    }

    public static BaseCell createCell(String cellType, String cellId, int health, int rows, int cols, int addProperty){

        switch(cellType){
            case "RedBloodCell" : return new RedBloodCell(cellId, health, rows, cols, addProperty);
            case "WhiteBloodCell" : return new WhiteBloodCell(cellId, health, rows, cols, addProperty);
            case "Fungi" : return new Fungi(cellId, health, rows, cols);
            case "Virus" : return new Virus(cellId, health, rows, cols);
            case "Bacteria" : return new Bacteria(cellId, health, rows, cols);
            default: return null;
        }

    }
}
