package com.example.demo.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Book;



public interface BookRepository extends JpaRepository<Book, Long>{
	
public List<Book> findBybookName(String name);

}
