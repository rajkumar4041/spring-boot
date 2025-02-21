package com.selfGroup.firstEmpCrud.service.books;

import com.selfGroup.firstEmpCrud.model.books.Book;
import org.springframework.http.ResponseEntity;

public interface BooksService {

    public ResponseEntity<Book> addBook(Book book);
}
