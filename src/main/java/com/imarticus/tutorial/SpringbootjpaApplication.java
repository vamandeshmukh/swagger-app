package com.imarticus.tutorial;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.imarticus.tutorial.dao.LibraryDao;
import com.imarticus.tutorial.dtos.Book;
import com.imarticus.tutorial.dtos.User;
import com.imarticus.tutorial.service.LibraryService;
import com.imarticus.tutorial.service.UserService;


@SpringBootApplication
@ComponentScan(basePackages = "com.imarticus.tutorial")
@EnableCaching
public class SpringbootjpaApplication {

	
	@Autowired
	private LibraryService libraryService;
	

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaApplication.class, args);
	}


	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new com.imarticus.tutorial.security.JwtFilter());
		registrationBean.addUrlPatterns("/books/*");

		return registrationBean;
	}


	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	libraryService.addBook(new Book("The Power of your Subconscious Mind",296,"Joseph Murphy","self-help",2015,50,"http://localhost:3006/assets/books/SELF-HELP-0001.jpg" ));
	    	libraryService.addBook(new Book("Great Gatsby",240,"F. Scott Fitzgerald","literature",1939,8,"http://localhost:3006/assets/books/LITERATURE-0002.jpg" ));
	    	libraryService.addBook(new Book("The Alchemist",50,"Paulo Coelho","novel",1990,9,"http://localhost:3006/assets/books/NOVEL-0003.jpg" ));
	    	libraryService.addBook(new Book("Data Smart",624,"Foreman, John","data-science",2012,12,"http://localhost:3006/assets/books/DATA-SCIENCE-0005.jpg" ));
	    	libraryService.addBook(new Book("God Created the Integers",114,"Hawking, Stephen","mathematics",2006,50,"http://localhost:3006/assets/books/MATHEMATICS-0006.jpg" ));

	    	userService.addUser(new User("admin@imarticus.com","admin"));
	    	userService.addUser(new User("test@imarticus.com","test"));
	    
	      };
	   }
	

}
