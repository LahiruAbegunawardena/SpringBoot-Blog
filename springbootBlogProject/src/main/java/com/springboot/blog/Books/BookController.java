package com.springboot.blog.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/store")
    public BookModel storeBooks(@RequestBody BookModel newBook){
        return bookService.storeBooks(newBook);
    }

    @GetMapping("")
    public Iterable<BookModel> getAllBooks(){
        return bookService.getAllBooks();
    }
}
