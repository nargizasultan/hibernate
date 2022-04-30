package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.configuraton.DataBaseConnection;
import org.example.models.Vendor;

import java.util.List;

public class VendorRepository implements AutoCloseable {
    private final EntityManagerFactory entityManagerFactory = DataBaseConnection.createEntityManagerFactory();

    public void save(Vendor vendor) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(
                vendor);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
    public void update(Vendor vendor) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(
                vendor);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
    public void deleteVendorById(long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
       entityManager.remove(entityManager.find(Vendor.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public List<Vendor>findAllVendors(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Vendor> vendorList = entityManager.createQuery("select v from Vendor v", Vendor.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return vendorList;
    }
    public Vendor findById(long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Vendor vendor = entityManager.createQuery("select v from Vendor v where v.id= ?1", Vendor.class).setParameter(1, id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return vendor;

    }



    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }


}
