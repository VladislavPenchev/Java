package engine;

import entities.*;

import java.util.*;

public class HealthManagerImpl implements HealthManager {

    List<Organism> organisms = new ArrayList<>();

    @Override
    public String checkCondition(String organismName) {
       StringBuilder sb = new StringBuilder();

       Organism organism = getOrganism(organismName);
       sb.append(organism.toString());

        organism.getClusters()
                .values()
                .stream()
                .forEach(cluster -> {
                    sb.append(cluster.toString());
                    cluster.getCells().values()
                            .stream()
                            .forEach(cell -> {
                                sb.append(cell.toString());
                            });
                });

        return sb.toString();
    }

    @Override
    public String createOrganism(String name) {
        Organism organism = getOrganism(name);

        if (organism == null) {
            organism = new Organism(name, new HashMap<>());
            organisms.add(organism);

            return String.format("Created organism %s\r\n", name);
        } else {
            return String.format("Organism %s already exists\r\n", name);
        }
    }

    @Override
    public String addCluster(String organismName, String id, int rows, int cols) {
        Cluster cluster = new Cluster(id, rows, cols, new HashMap<>());

        Organism organism = this.getOrganism(organismName);

        if (organism != null) {
            Cluster currentCluster = organism
                    .getClusters()
                    .values()
                    .stream()
                    .filter(c -> c.getId().equals(id))
                    .findFirst()
                    .orElse(null);
            if (currentCluster == null) {
                organism
                        .getClusters()
                        .put(id, cluster);
                return String.format("\r\nOrganism %s: Created cluster %s\r\n", organismName, id);
            }
        }

        return null;
    }

    @Override
    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {

        Cell cell = null;
        switch (cellType) {
            case "RedBloodCell":
                cell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "WhiteBloodCell":
                cell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Virus":
                cell = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Fungi":
                cell = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Bacteria":
                cell = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
                break;
        }

        Organism organism = getOrganism(organismName);
        if(organism != null){
            Cluster cluster = organism
                    .getClusters()
                    .values()
                    .stream()
                    .filter(c -> c.getId().equals(clusterId))
                    .findFirst()
                    .orElse(null);

            if (cluster != null) {
                cluster.getCells().put(cellId, cell);
                return String.format("Organism %s: Created cell %s in cluster %s\r\n", organismName, cellId, clusterId);
            }
        }

        return null;
    }

    @Override
    public String activateCluster(String organismName) {
        Organism organism = getOrganism(organismName);

        //TODO
        Cluster cluster = organism.getClusters().get(0);

        return String.format("Organism %s: Activated cluster %s. Cells left: %d", organismName,
                cluster.getId(), cluster.getCells().size());
    }


    private Organism getOrganism(String name) {
        return organisms.stream()
                .filter(o -> o.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
