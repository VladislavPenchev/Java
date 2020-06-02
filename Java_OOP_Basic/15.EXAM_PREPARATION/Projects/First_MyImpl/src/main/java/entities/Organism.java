package entities;

import java.util.Collection;
import java.util.Map;

public class Organism {
    private String name;
    private Map<String, Cluster> clusters;

    public Organism(String name, Map<String, Cluster> clusters) {
        this.name = name;
        this.clusters = clusters;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Cluster> getClusters() {
        return clusters;
    }

    public void setClusters(Map<String, Cluster> clusters) {
        this.clusters = clusters;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Organism - %s", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("--Clusters: %d", this.getClusters().size()));

        int cellsCount = 0;
        Collection<Cluster> clusters = this.getClusters().values();
        for (Cluster cluster : clusters) {
            cellsCount += cluster.getCells().values().size();
        }

        res
                .append(System.lineSeparator())
                .append(String.format("--Cells: %d", cellsCount));

        return res.toString();
    }
}
