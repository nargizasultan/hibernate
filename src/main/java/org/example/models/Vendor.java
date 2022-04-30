package org.example.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REMOVE}, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Book> bookList;

    public Vendor(String name, String email) {
        this.name = name;
        this.email = email;

    }
    public void setBook(Book newBook){
        this.bookList.add(newBook);
    }
    public void removeById(long id){
        bookList.removeIf(x->x.getId()==id);

    }
}
