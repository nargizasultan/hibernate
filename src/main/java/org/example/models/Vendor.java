package org.example.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.SessionFactory;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vendors")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   

    private long id;
    private String name;
    private String email;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "vendor", fetch = FetchType.EAGER)
    private List<Book> books=new ArrayList<>();

    public Vendor(String name, String email) {
        this.name = name;
        this.email = email;

    }
    public void addBook(Book book){
        this.books.add(book);
    }
    public void removeBook(long id){
        books.removeIf(x->x.getId()==id);
    }

}
