package com.unicobib.spring5webapp.bootstrap;

import com.unicobib.spring5webapp.domain.Author;
import com.unicobib.spring5webapp.domain.Book;
import com.unicobib.spring5webapp.domain.Publisher;
import com.unicobib.spring5webapp.repositories.AuthorRepository;
import com.unicobib.spring5webapp.repositories.BookRepository;
import com.unicobib.spring5webapp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher("sfg publication", "New York, USA", "new York");
        publisherRepository.save(publisher);
        System.out.println("Publisher count:  "+publisherRepository.count());

        Author eric = new Author("Eric", "simson");
        Book ddd = new Book("Domain Driven Design", "1234567");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rob = new Author("Rob", "Jonshon");
        Book noEjb = new Book("JEE without EJB", "98076");
        rob.getBooks().add(noEjb);
        noEjb.getAuthors().add(rob);

        noEjb.setPublisher(publisher);
        //publisher.getBooks().add(noEjb);

        authorRepository.save(rob);
        bookRepository.save(noEjb);
        publisherRepository.save(publisher);

        System.out.println("number of books: "+bookRepository.count());
        System.out.println("number of publisher: "+publisherRepository.count());
    }
}
