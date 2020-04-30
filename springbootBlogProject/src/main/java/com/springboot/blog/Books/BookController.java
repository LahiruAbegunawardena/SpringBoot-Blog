package com.springboot.blog.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/store")
    public Object storeBooks(@RequestBody BookModel newBook){
        return bookService.storeBooks(newBook);
    }

    @GetMapping("")
    public Object getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Object getBookById(@PathVariable Integer bookId){
        return bookService.getBookById(bookId);
    }

    @PutMapping("/update/{bookId}")
    public Object updateBook(@PathVariable Integer bookId, @RequestBody BookModel updtBkDta){
        return bookService.updateBook(bookId, updtBkDta);
    }
}
