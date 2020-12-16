package com.example.demo.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Book;
import com.example.demo.Repository.BookRepository;

@RestController
public class BookController
{
	@Autowired
	BookRepository repo;
	
	@PostMapping("/bookInsert")
	public String insertBook(@RequestBody Book book)
	{
		System.out.println("before inserting message");
		repo.save(book);
		System.out.println("after successfull data");
		return "your data is saved...";
	}
	
	@PostMapping("/multiplebookInsert")
	public String insertAllBook(@RequestBody List<Book> book)
	{
		
		repo.saveAll(book);
		
		return "your all data is saved...";
	}
	@GetMapping("/getAllBooks")
	public List<Book> getBook()
	{
			return (List<Book>) repo.findAll() ;
	}
	@GetMapping("/getByBookName/{name}")
	public List<Book> getBookbyName(@PathVariable("name") String bookName)
	{
		return repo.findBybookName(bookName);
		
	}
	@GetMapping("/getByBookId/{bookId}")
	public Optional<Book> getBookbyId(@PathVariable("bookId") Long bookId)
	{
		return repo.findById(bookId);
		
	}
	 @PutMapping("/updateByBookId/{id}")
	    Book updateBook(@RequestBody Book newBook, @PathVariable Long id) {
	 
	        return repo.findById(id).map(book -> {
	            book.setBookName(newBook.getBookName());
	            book.setBookAuther(newBook.getBookAuther());
	            System.out.println("your record is successfully updated...");

	            return repo.save(book);
	        }).orElseGet(() -> {
	            newBook.setId(id);
	            return repo.save(newBook);
	        });
	        
	        
	        
	    }
	
	
	
	
	@DeleteMapping("/deleteById/{id}")
	    void deleteBook(@PathVariable Long id) 
	{
		System.out.println("deleted successfully......");
	      repo.deleteById(id);
	     
	     
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
