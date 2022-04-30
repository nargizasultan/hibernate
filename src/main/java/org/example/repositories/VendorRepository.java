package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.configuraton.DataBaseConnection;
import org.example.models.Vendor;

import java.util.List;

public class VendorRepository implements AutoCloseable {
    private final EntityManagerFactory entityManagerFactory = DataBaseConnection.createEntityManagerFactory();
    public void save(Vendor vendor){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(vendor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void update(Vendor vendor){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(vendor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public Vendor findById(long id){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Vendor vendor = entityManager.find(Vendor.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return vendor;
    }
    public List<Vendor>findAll(){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Vendor> vendors = entityManager.createQuery("select v from Vendor  v ", Vendor.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return vendors;
    }





    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }


}
