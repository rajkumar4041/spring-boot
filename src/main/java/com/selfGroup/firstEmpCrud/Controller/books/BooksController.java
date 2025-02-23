package com.selfGroup.firstEmpCrud.Controller.books;

import com.selfGroup.firstEmpCrud.dto.BookDto;
import com.selfGroup.firstEmpCrud.model.books.Book;
import com.selfGroup.firstEmpCrud.service.books.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return booksService.addBook(book);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks() {
        return this.booksService.getAllBooks();
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        return this.booksService.getBook(id);
    }

}
