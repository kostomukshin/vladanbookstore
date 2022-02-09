package com.example.vladanbookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.vladanbookstore.model.Book;
import com.example.vladanbookstore.model.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value = {"/", "/booklist"})
	public String listbooks(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model) {
		repository.deleteById(id);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		return "editbook";
	}
	
	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		repository.save(book);
		
		
		return "redirect:/booklist";
	}
}





	

	