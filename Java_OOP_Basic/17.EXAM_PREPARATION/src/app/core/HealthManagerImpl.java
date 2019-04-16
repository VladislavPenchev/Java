package app.core;

import app.contracts.Cell;
import app.contracts.HealthManager;
import app.contracts.Organism;
import app.entities.ClusterImpl;
import app.entities.OrganismImpl;
import app.entities.cells.BaseCell;
import app.factories.CellFactory;
import app.factories.ClusterFactory;
import app.factories.OrganismFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class HealthManagerImpl implements HealthManager {

    private Map<String, OrganismImpl> organisms;

    public HealthManagerImpl(){
        this.organisms = new LinkedHashMap<>();
    }


    @Override
    public String checkCondition(String organismName) {

        if (this.organisms.containsKey(organismName)){
            return this.organisms.get(organismName).toString();
        }
        return "";
    }

    @Override
    public String createOrganism(String name) {

        if(this.organisms.containsKey(name)){
            return  String.format("Organism %s already exists%n", name);
        }

        this.organisms.put(name, OrganismFactory.createOrganism(name));

        return String.format("Created organism %s%n", name);
    }

    @Override
    public String addCluster(String organismName, String id, int rows, int cols) {
        if(this.organisms.containsKey(organismName)){

            ClusterImpl cluster = ClusterFactory.createCluster(id, rows, cols);

            boolean isAdded = this.organisms.get(organismName).addCluster(cluster);

            if(isAdded){
                return String.format("Organism %s: Created cluster %s%n", organismName, id);
            }
        }

        return "";
    }

    @Override
    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {

        BaseCell cell = CellFactory.createCell(cellType, cellId, health, positionRow, positionCol, additionalProperty);

        if(this.organisms.containsKey(organismName)){
            ClusterImpl cluster = this.organisms.get(organismName).getClusterById(clusterId);
            if(cluster != null){
                cluster.addCell(cell);
                return String.format("Organism %s: Activated cluster %s. Cells left: %s%n", organismName, cellId, clusterId);
            }
        }

        return "";
    }

    @Override
    public String activateCluster(String organismName) {

        if(this.organisms.containsKey(organismName)){

            if(this.organisms.get(organismName).getClusters().size() > 0){
                ClusterImpl cluster = this.organisms.get(organismName).getClusters().get(0);

                cluster.activate();

                this.organisms.get(organismName).moveClusterToTheEnd();


                return String.format(" Organism %d: Activated cluster %s. Cells left: %d%n", organismName, cluster.getId(), cluster.getCellsCount());
            }
        }

        return "";
    }

}
