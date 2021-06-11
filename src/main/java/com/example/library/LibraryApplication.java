package com.example.library;

import com.example.library.model.*;
import com.example.library.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner libraryDemo(BookService bookService,
										 AuthorService authorService, PublisherService publisherService,
										 BorrowService borrowService, UserService userService){

		return args -> {
			Book b1 = new Book(123,"titlito11", 5);
			Book b2 = new Book(456,"titlito22", 1);

			Genre g1 = new Genre("horror","a prety scary book");
			Genre g2 = new Genre("comdeia","a funny book");

			Publisher p1 = new Publisher("Can yayinevi");
			Author a1 = new Author("George","Orwell");
			Author a2 = new Author("engic","ertan");
			User u1 = new User("Ali","Dogan","alido@gmal.com");
			User u2 = new User("Userella","sureuser2","user2@gmal.com");
			b1.setPublisher(p1);
			b1.setGenre(g1);
			b1.getAuthors().add(a1);
			b1.getAuthors().add(a2);
			b2.setPublisher(p1);
			b2.setGenre(g2);
			b2.getAuthors().add(a1);

			authorService.save(a1);
			authorService.save(a2);
			publisherService.save(p1);
			bookService.save(b1);
			bookService.save(b2);
			userService.save(u1);
			userService.save(u2);

			borrowService.borrowBook(u1,b1);
			borrowService.borrowBook(u1,b2);
			borrowService.borrowBook(u2,b1);

			//User sU = userService.findById(8L);
			System.out.println("UP AND RUNNING..");


		};

	}

}
