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
			Book b2 = new Book(456,"titlito22", 141);

			Genre g1 = new Genre("horror","a prety scary book");
			Genre g2 = new Genre("comdeia","a funny book");

			Publisher p1 = new Publisher("Can yayinevi");
			Author a1 = new Author("George","Orwell");
			User u1 = new User("Ali","Dogan","alido@gmal.com");
			User u2 = new User("Userella","sureuser2","user2@gmal.com");

			b1.setPublisher(p1);
			b1.setGenre(g1);
			b1.getAuthors().add(a1);

			b2.setPublisher(p1);
			b2.setGenre(g2);

			authorRepository.save(a1);
			publisherRepository.save(p1);
			bookRepository.save(b1);
			bookRepository.save(b2);
		};

	}


}
