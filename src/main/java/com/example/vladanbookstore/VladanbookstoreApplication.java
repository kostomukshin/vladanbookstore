package com.example.vladanbookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.vladanbookstore.model.Book;
import com.example.vladanbookstore.model.BookRepository;

@SpringBootApplication
public class VladanbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(VladanbookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			System.out.println("Save a couple of books");
			repository.save(new Book("The Man Who Laughs", "Victor Hugo", 1869, "978-14954-41936", 14.90));
			repository.save(new Book("Ulysses", "James Joyce", 1922, "978-95249-52262", 30.00));

			System.out.println("Fetch all books");
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}
		};

	}

}
