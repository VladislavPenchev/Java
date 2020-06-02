package db;

import entities.Cluster;

import java.util.List;

public interface OrganismRepository {

    List<Cluster> findAllOrganisms();

    Cluster findByOrganismName(String name);
}
