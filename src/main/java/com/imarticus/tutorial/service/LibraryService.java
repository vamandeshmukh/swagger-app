package com.imarticus.tutorial.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.imarticus.tutorial.dao.LibraryDao;
import com.imarticus.tutorial.dtos.Book;

@Service
public class LibraryService {

	@Autowired
	private LibraryDao library;

	
	private static Logger logger = LoggerFactory.getLogger(LibraryService.class);

	static void sleepFor(int seconds) {
		
		 try
	        {
			 logger.info("Going to sleep for "+seconds+" Secs.. to slow down application.");
	            Thread.sleep(1000*seconds);
	        }
	        catch (InterruptedException e)
	        {
	            e.printStackTrace();
	        }
		 
	}
	
	@Cacheable("books")
	public List<Book> getAllbooks() {
		sleepFor(5);
		return library.findAll();
	}


	
	public Book getBookById(Long id) {
		sleepFor(2);
		return library.findById(id).get();
	}
	

	@CacheEvict("books")
	public Book addBook(Book book) {
		return library.save(book);

	}
	@CacheEvict("books")
	public Book updateBook(Long id, Book book) {

		Optional<Book> repBook = library.findById(id);

		if (repBook.isPresent()) {

			Book bookToBeUpdated = repBook.get();
			bookToBeUpdated.setAvailableCopies(book.getAvailableCopies());
			bookToBeUpdated.setTotalCopies(book.getTotalCopies());
			bookToBeUpdated.setAuthor(book.getAuthor());
			bookToBeUpdated.setCategory(book.getCategory());
			bookToBeUpdated.setPrice(book.getPrice());
			bookToBeUpdated.setPublishYear(book.getPublishYear());

			return library.save(bookToBeUpdated);

		}

		return null;
	}

	@CacheEvict("books")
	public String removeBook(Long bookId) {

		library.deleteById(bookId);
		return "Book deleted Sucessfully";
	}

}
