package com.selfGroup.firstEmpCrud.serviceImpl.books;

import com.selfGroup.firstEmpCrud.model.books.Book;
import com.selfGroup.firstEmpCrud.repository.books.BookRepository;
import com.selfGroup.firstEmpCrud.service.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public ResponseEntity<Book> addBook(Book book) {

        Book returnedBook = bookRepository.save(book);

        return ResponseEntity.ok().body(returnedBook);
    }
}
