package app.factories;

import app.entities.ClusterImpl;

public class ClusterFactory {

    private ClusterFactory(){

    }

    public static ClusterImpl createCluster(String clusterId, int rows, int cols){
        return new ClusterImpl(clusterId, rows, cols);
    }
}
