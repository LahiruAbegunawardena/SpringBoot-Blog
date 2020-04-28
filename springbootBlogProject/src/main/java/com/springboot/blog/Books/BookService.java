package com.springboot.blog.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookModel storeBooks(BookModel newBook){
        return bookRepository.save(newBook);
    }

    public Iterable<BookModel> getAllBooks(){
        return bookRepository.findAll();
    }
}
