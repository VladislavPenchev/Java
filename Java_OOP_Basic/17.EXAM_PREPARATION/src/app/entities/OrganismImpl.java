package app.entities;

        import app.contracts.Cell;
        import app.contracts.Cluster;
        import app.contracts.Organism;
        import app.entities.cells.BaseCell;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;

public class OrganismImpl implements Organism {
    private String name;
    private List<ClusterImpl> clusters;

    public OrganismImpl(String name) {
        this.name = name;
        this.clusters = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<ClusterImpl> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }

    public boolean addCluster(ClusterImpl cluster){
        for (ClusterImpl currCluster : clusters){
            if(currCluster.getId().equals(cluster.getId())){
                return false;
            }
        }

        this.clusters.add(cluster);

        return true;
    }

    private int getCellsCount() {

        int count = 0;

        for (Cluster cluster : this.clusters) {
            for (Cell[] cells : cluster.getCells()) {
                for (Cell cell : cells) {
                    if(cell != null){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public ClusterImpl getClusterById(String clusterId){
        for (ClusterImpl cluster : clusters) {
            if(cluster.getId().equals(clusterId)){
                return cluster;
            }
        }

        return null;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Organism - %s%n--Clusters: %d%n--Cells: %d%n", this.name, this.clusters.size(), this.getCellsCount()));

        for (Cluster cluster : clusters) {
            sb.append(cluster.toString());
        }

        return sb.toString();


    }

    public void moveClusterToTheEnd() {
        ClusterImpl cluster = this.getClusters().get(0);
        this.clusters.remove(0);
        this.clusters.add(cluster);
    }
}
