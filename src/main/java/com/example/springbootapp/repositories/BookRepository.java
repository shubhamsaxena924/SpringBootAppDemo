package com.example.springbootapp.repositories;

import com.example.springbootapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
