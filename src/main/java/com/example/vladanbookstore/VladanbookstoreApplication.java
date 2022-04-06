package com.example.vladanbookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.vladanbookstore.model.Book;
import com.example.vladanbookstore.model.BookRepository;
import com.example.vladanbookstore.model.Category;
import com.example.vladanbookstore.model.CategoryRepository;
import com.example.vladanbookstore.model.User;
import com.example.vladanbookstore.model.UserRepository;


@SpringBootApplication
public class VladanbookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(VladanbookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			
			System.out.println("Save a couple of categories");
			crepository.save(new Category("Novel"));
			crepository.save(new Category("Science Fiction"));
			crepository.save(new Category("Detective"));
			crepository.save(new Category("Thriller"));
			crepository.save(new Category("Adventure"));
			
		
			System.out.println("Save a couple of books");
			repository.save(new Book("The Man Who Laughs", "Victor Hugo", 1869, "978-14954-41936", 17.00, crepository.findByName("Novel").get(0)));
			repository.save(new Book("Ulysses", "James Joyce", 1922, "978-95249-52262", 25.00, crepository.findByName("Novel").get(0)));
			repository.save(new Book("Hard To Be A God", "Arkady & Boris Strugatsky", 1964, "978-14523-52612", 15.00, crepository.findByName("Science Fiction").get(0)));
			
			System.out.println("Save users");
			User user1 = new User("user", "$2a$10$T9IxNoU4Jomn5Jstiw1wQunbFXHGF2THC59.x65lz3uM0OUqw0wE.", "polo@mail.com", "USER");
			User user2 = new User("admin", "$2a$10$j58sIUb0pJpQseshxnfPsu2B13/RYEzVzGZb5K0W6xP8g9cfOfBmq", "kosto@mail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			System.out.println("Fetch all books");
			for (Book book : repository.findAll()) {
				System.out.println(book.toString());
			}
		};

	}

}
