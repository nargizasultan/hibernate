package org.example;

import lombok.SneakyThrows;
import org.example.models.Book;
import org.example.models.Vendor;
import org.example.repositories.BookRepository;
import org.example.repositories.VendorRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    @SneakyThrows
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        VendorRepository vendorRepository = new VendorRepository();

        bookRepository.deleteById(1);
        vendorRepository.deleteVendorById(10);
//        Book book = bookRepository.findById(5);
//        Vendor vendor = vendorRepository.findById(2);
//        vendor.setBook(book);
//        vendorRepository.update(vendor);
//        System.out.println(vendor);



//        Book book = new Book("Унесённые ветром", "Маргарет Митчелл", BigDecimal.valueOf(1200));
//        Book book1 = new Book("Над пропастью во ржи", "Джером Д. Сэлинджер", BigDecimal.valueOf(1200));
//        Book book2 = new Book("Сто лет одиночества", "Габриэль Гарсия Маркес", BigDecimal.valueOf(1200));
//        Book book3 = new Book("Война и мир", "Лев Толстой", BigDecimal.valueOf(1200));
//        Book book4 = new Book("Гордость и предубеждение", "Джейн Остин", BigDecimal.valueOf(1200));
//        bookRepository.save(book1);
//        bookRepository.save(book2);
//        bookRepository.save(book3);
//        bookRepository.save(book4);
//        vendor.setBookList(List.of(book1, book2, book3));
//        vendorRepository.save(vendor);
//        bookRepository.close();
    }
}
