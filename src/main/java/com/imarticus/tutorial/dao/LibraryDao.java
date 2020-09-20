package com.imarticus.tutorial.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imarticus.tutorial.dtos.Book;

@Repository
public interface LibraryDao extends CrudRepository<Book,Long> {
	

	List<Book> findAll();
	void deleteById(Long id);
	
	
	

}
