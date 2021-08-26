package com.example.library;

import com.example.library.model.*;
import com.example.library.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.time.Instant;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner libraryDemo(BookService bookService,
										 AuthorService authorService, PublisherService publisherService,
										 BorrowService borrowService, UserService userService){

		return args -> {
//			Book b1 = new Book(789,"titlito11", 5);
//			Book b2 = new Book(456,"titlito22", 2);
//
//
//			Publisher p1 = new Publisher("Can yayinevi");
//			Author a1 = new Author("George","Orwell");
//			a1.setName("llovani");
//			a1.setSurname("georgio");
//			Author a2 = new Author("engic","ertan");
//			User u1 = new User("Ali","Dogan","alido@gmal.com");
//			User u2 = new User("Userella","sureuser2","user2@gmal.com");
//
//			b1.setPublisher(p1);
//			b1.setGenre("fun");
//			b1.getAuthors().add(a1);
//			b1.getAuthors().add(a2);
//			b2.setPublisher(p1);
//			b2.setGenre("and all");
//			b2.getAuthors().add(a1);
//
//			authorService.save(a1);
//			authorService.save(a2);
//			publisherService.save(p1);
//			bookService.save(b1);
//			bookService.save(b2);
//			userService.save(u1);
//			userService.save(u2);
//
//			borrowService.borrowBook(u1,b1);
//			borrowService.borrowBook(u1,b2);
//			borrowService.borrowBook(u2,b1);
//
//			//User sU = userService.findById(8L);
//			System.out.println("UP AND RUNNING..");
//			borrowService.printBorrow(1L);
//			System.out.println(b2.toString());
//			System.out.println(b1.toString());
			System.out.println(bookService.findAll().size());

			long instant = Instant.now().toEpochMilli();
			Book bookCacheMiss = bookService.findById(27L);
			long afterMiss = Instant.now().toEpochMilli();
			Book bookCacheHit = bookService.findById(27L);
			long afterHit = Instant.now().toEpochMilli();

			long miss = afterMiss-instant ;
			long hit = afterHit-afterMiss;
			System.out.println("Miss: "+(miss));
			System.out.println("Hit : "+(hit));

			instant = Instant.now().toEpochMilli();
			Book bookCacheMiss2 = bookService.findById(29L);
			afterMiss = Instant.now().toEpochMilli();
			Book bookCacheHit2 = bookService.findById(29L);
			afterHit = Instant.now().toEpochMilli();

			miss = afterMiss-instant ;
			hit = afterHit-afterMiss;
			System.out.println("2.Miss: "+(miss));
			System.out.println("2.Hit : "+(hit));


			System.out.println(bookCacheHit.getTitle());
		};

	}

}
