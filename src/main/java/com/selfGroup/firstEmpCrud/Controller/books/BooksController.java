package com.selfGroup.firstEmpCrud.Controller.books;

import com.selfGroup.firstEmpCrud.model.books.Book;
import com.selfGroup.firstEmpCrud.service.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return booksService.addBook(book);
    }

}
