package com.unicobib.spring5webapp.bootstrap;

import com.unicobib.spring5webapp.domain.Author;
import com.unicobib.spring5webapp.domain.Book;
import com.unicobib.spring5webapp.repositories.AuthorRepository;
import com.unicobib.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "simson");
        Book ddd = new Book("Domain Driven Design", "1234567");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rob = new Author("Rob", "Jonshon");
        Book noEjb = new Book("JEE without EJB", "98076");
        rob.getBooks().add(noEjb);
        noEjb.getAuthors().add(rob);
        authorRepository.save(rob);
        bookRepository.save(noEjb);

        System.out.println("number of books: "+bookRepository.count());
    }
}
