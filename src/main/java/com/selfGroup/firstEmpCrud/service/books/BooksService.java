package com.selfGroup.firstEmpCrud.service.books;

import com.selfGroup.firstEmpCrud.model.books.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BooksService {

    public ResponseEntity<Book> addBook(Book book);

    public ResponseEntity<List<Book>> getAllBooks();

    public ResponseEntity<Book> getBook(int id);
}
