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

        Vendor vendor = vendorRepository.findById(1);
        Book book=bookRepository.findById(2);
        vendor.addBook(book);
        book.setVendor(vendor);
        System.out.println(vendor);



    }
}
