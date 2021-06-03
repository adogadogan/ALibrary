package com.example.library;

import com.example.library.model.*;
import com.example.library.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner libraryDemo(BookRepository bookRepository, GenreRepository genreRepository,
										 AuthorRepository authorRepository, PublisherRepository publisherRepository,
										 BorrowRepository borrowRepository, UserRepository userRepository){

		return args -> {
			Book b1 = new Book(123,"titlito11", 14);
			Genre g1 = new Genre("horror","a prety scary book");
			Publisher p1 = new Publisher("Can yayinevi");
			Author a1 = new Author("George","Orwell");

			//bookRepository.save(b1);
			//publisherRepository.save(p1);
			//authorRepository.save(a1);
			//genreRepository.save(g1);

			b1.setGenre(g1);
			b1.setPublisher(p1);
			b1.getAuthors().add(a1);

			a1.getBooks().add(b1);
			g1.setBook(b1);
			p1.getBooks().add(b1);

			bookRepository.save(b1);

			Book b2 = new Book(1623,"qwe",1);
			//b2.getAuthors().add(a1);
			bookRepository.save(b2);


			User u1 = new User("Ali","Dogan","alido@gmail.com");

			Borrow borrow1 = new Borrow();

			borrow1.setBook(b2);
			borrow1.setUser(u1);

			borrowRepository.save(borrow1);


			//bookRepository.delete(b1);

		};

	}


}
