package panda.repository;

import panda.domain.entities.Package;
import panda.domain.entities.Status;
import panda.domain.models.service.PackageServiceModel;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class PackageRepositoryImpl implements PackageRepository {

    private final EntityManager entityManager;

    @Inject
    public PackageRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Package save(Package entity) {
        this.entityManager.getTransaction().begin();

        this.entityManager.persist(entity);

        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Package> findAll() {
        this.entityManager.getTransaction().begin();

        List<Package> allPackages = this.entityManager.createQuery("SELECT p FROM Package p", Package.class)
                .getResultList();

        this.entityManager.getTransaction().commit();

        return allPackages;
    }

    @Override
    public Package findById(String id) {
        this.entityManager.getTransaction().begin();

        Package aPackage= this.entityManager.createQuery("SELECT p FROM Package p WHERE p.id = :id", Package.class)
                .setParameter("id", id)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return aPackage;
    }

    @Override
    public Long size() {
        this.entityManager.getTransaction().begin();

        long size = this.entityManager.createQuery("SELECT count(p) FROM Package p", Long.class)
                .getSingleResult();

        this.entityManager.getTransaction().commit();

        return size;
    }

    @Override
    public List<Package> findAllPackagesByStatus(Status status) {
        this.entityManager.getTransaction().begin();

        List<Package> allPackages = this.entityManager.createQuery("SELECT p FROM Package p WHERE p.status = :status", Package.class)
                .setParameter("status", status)
                .getResultList();

        this.entityManager.getTransaction().commit();

        return allPackages;
    }

    @Override
    public Package updatePackage(Package aPackage) {
        this.entityManager.getTransaction().begin();

        Package update = this.entityManager.merge(aPackage);

        this.entityManager.getTransaction().commit();

        return update;
    }
}
