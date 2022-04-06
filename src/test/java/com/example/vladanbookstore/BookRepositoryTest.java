package com.example.vladanbookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.vladanbookstore.model.Book;
import com.example.vladanbookstore.model.BookRepository;
import com.example.vladanbookstore.model.Category;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Ulysses");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("James Joyce");
		
	}
	@Test
	public void createNewBook() {
		Book book = new Book("Three Comrades", "Erich Maria Remarque", 1937, "978-26373-57332", 20.00, new Category("Novel"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	@Test
	public void deleteNewBook() {
		List<Book> books = repository.findByTitle("Ulysses");
		Book book = books.get(0);
		repository.delete(book);
		List<Book> newBooks = repository.findByTitle("Ulysses");
		assertThat(newBooks).hasSize(0);
	}
	

}
