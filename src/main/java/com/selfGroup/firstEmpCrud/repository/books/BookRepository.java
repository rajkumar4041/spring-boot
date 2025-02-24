package com.selfGroup.firstEmpCrud.repository.books;

import com.selfGroup.firstEmpCrud.model.books.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
