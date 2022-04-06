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
import com.example.vladanbookstore.model.CategoryRepository;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findbyName() {
		List<Category> categories = repository.findByName("Science Fiction");
		
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Science Fiction");
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Romance");
		repository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
		}

	@Test
	public void deleteNewCategory() {
		List<Category> categories = repository.findByName("Novel");
		Category category = categories.get(0);
		repository.delete(category);
		List<Category> newCategories = repository.findByName("Novel");
		assertThat(newCategories).hasSize(0);
	}
	
}
