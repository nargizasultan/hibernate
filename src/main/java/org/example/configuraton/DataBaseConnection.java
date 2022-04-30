package org.example.configuraton;

import jakarta.persistence.EntityManagerFactory;
import org.example.models.Book;
import org.example.models.Vendor;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class DataBaseConnection {
    public static EntityManagerFactory createEntityManagerFactory() {
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");
        properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.setProperty(Environment.USER, "postgres");
        properties.setProperty(Environment.PASS, "root");

        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Vendor.class);


        return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
    }
}
