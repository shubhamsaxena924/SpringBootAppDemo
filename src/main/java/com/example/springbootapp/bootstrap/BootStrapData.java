package com.example.springbootapp.bootstrap;

import com.example.springbootapp.domain.Author;
import com.example.springbootapp.domain.Book;
import com.example.springbootapp.domain.Publisher;
import com.example.springbootapp.repositories.AuthorRepository;
import com.example.springbootapp.repositories.BookRepository;
import com.example.springbootapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Shubham", "Saxena");
        Book ddd = new Book("This is the stress of my life", "1DA00LT017024");
        Publisher pub = new Publisher("Dinesh Books", "GLA University, Mathura", "Mathura", "UP", 203466);
        publisherRepository.save(pub);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(pub);
        pub.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(pub);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE", "A41254S451S");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(pub);
        pub.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(pub);

        System.out.println("No. of authors saved " + authorRepository.count());
        System.out.println("No of books saved " + bookRepository.count());
        System.out.println("No. of publishers saved " + publisherRepository.count());
    }
}
