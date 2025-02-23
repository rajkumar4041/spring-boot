package com.selfGroup.firstEmpCrud.serviceImpl.books;

import com.selfGroup.firstEmpCrud.model.books.Book;
import com.selfGroup.firstEmpCrud.repository.books.BookRepository;
import com.selfGroup.firstEmpCrud.service.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public ResponseEntity<Book> addBook(Book book) {

        Book returnedBook = bookRepository.save(book);

        return ResponseEntity.ok().body(returnedBook);
    }

    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        if (!allBooks.isEmpty()) {
            return ResponseEntity.ok().body(allBooks);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public ResponseEntity<Book> getBook(int id) {
        Optional<Book> byId = bookRepository.findById(id);
        return byId.map(book -> ResponseEntity.ok().body(book))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }
}
