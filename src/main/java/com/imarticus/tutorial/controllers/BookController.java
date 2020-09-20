package com.imarticus.tutorial.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imarticus.tutorial.dtos.Book;
import com.imarticus.tutorial.service.LibraryService;


//connect from postman as http://localhost:8080/books/
@Controller
@RequestMapping("/books")
class BookController{

	Logger log = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private LibraryService libraryService;
	


@GetMapping(value = {"/" })
public @ResponseBody List<Book> getLibraryBooks() 
{ 
	
	List<Book> books = libraryService.getAllbooks();
	

	
	return books;
}

@GetMapping("/{id}")
public @ResponseBody  Book getBookById(@PathVariable Long id) 
{
	
	return libraryService.getBookById(id);
}



@PostMapping("/")
public @ResponseBody Book addBook(@RequestBody Book book) 
{
	return libraryService.addBook(book);
}

@PutMapping("/{id}")
public @ResponseBody Book updateBook(@PathVariable Long id,@RequestBody Book book) 
{
	
	return libraryService.updateBook(id,book);
}

@DeleteMapping("/{id}")
public @ResponseBody String removeBook(@PathVariable Long id) 
{
	return libraryService.removeBook(id);
}


}
