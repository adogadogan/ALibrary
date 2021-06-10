package com.example.library;

import com.example.library.model.*;
import com.example.library.service.*;
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
	public CommandLineRunner libraryDemo(BookServiceImpl bookServiceImpl,
										 AuthorServiceImpl authorServiceImpl, PublisherServiceImpl publisherService,
										 BorrowServiceImpl borrowServiceImpl, UserServiceImpl userServiceImpl){

		return args -> {
			Book b1 = new Book(123,"titlito11", 14);
			Book b2 = new Book(456,"titlito22", 141);

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

			authorServiceImpl.save(a1);
			authorServiceImpl.save(a2);
			publisherService.save(p1);
			bookServiceImpl.save(b1);
			bookServiceImpl.save(b2);
			userServiceImpl.save(u1);
			userServiceImpl.save(u2);

			Borrow userBorrows = new Borrow();
			userBorrows.setUser(u1);
			userBorrows.setBook(b1);
			Borrow anotherBorrows = new Borrow();
			anotherBorrows.setUser(u1);
			anotherBorrows.setBook(b2);
			borrowServiceImpl.save(userBorrows);
			//borrowServiceImpl.save(anotherBorrows);

			User sU = userServiceImpl.findById(8L);
			System.out.println(sU);

		};

	}


}
