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

    public void save(Book newBook) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newBook);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
    public List<Book>findAll(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Book> bookList = entityManager.createQuery("select b from Book b", Book.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return bookList;

    }
    public Book findById(long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Book book = entityManager.find(Book.class, id);
        entityManager.close();
        return book;
    }
    public void deleteById(long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Vendor vendor = entityManager.createQuery("select v from Vendor  v join v.bookList b where b.id=?1", Vendor.class).setParameter(1, id).getSingleResult();
        vendor.removeById(id);
        entityManager.persist(vendor);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
