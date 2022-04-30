package org.example.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.example.configuraton.DataBaseConnection;
import org.example.models.Book;
import org.example.models.Vendor;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class BookRepository implements AutoCloseable {
    private final EntityManagerFactory entityManagerFactory = DataBaseConnection.createEntityManagerFactory();

    public void save(Book book) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public Book findById(long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return book;
    }
    public void deleteById(long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Book  b where b.id=?1", Book.class).setParameter(1, id).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();


    }
    public List<Book>findAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Book> resultList = entityManager.createQuery("delete from Book b", Book.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return  resultList;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
