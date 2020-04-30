package com.springboot.blog.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Object storeBooks(BookModel newBook){
        Map<String, Object> responseData = new HashMap<>();
        try {
            BookModel newBookDta = bookRepository.save(newBook);
            responseData.put("msg", "New Book stored successfully..");
            responseData.put("status", true);
            responseData.put("data", newBookDta);
            return responseData;
        } catch (Exception e){
            responseData.clear();
            responseData.put("msg", "New Book store failed..");
            responseData.put("status", false);
            responseData.put("data", null);
            return  responseData;
        }
    }

    public Object getAllBooks(){
        Map<String, Object> responseData = new HashMap<>();
        try {
            Iterable<BookModel> allBooks = bookRepository.findAll();
            responseData.put("msg", "All books retrieved..");
            responseData.put("status", true);
            responseData.put("data", allBooks);
            return responseData;
        } catch (Exception e){
            responseData.put("msg", "All books retrieve failed..");
            responseData.put("status", false);
            responseData.put("data", null);
            return responseData;
        }
    }

    public Object getBookById(Integer bookId){
        Map<String, Object> responseData = new HashMap<>();
        try {
            if(bookRepository.existsById(bookId)){
                Optional<BookModel> existDta = bookRepository.findById(bookId);
                responseData.put("msg", "Book found by bookId");
                responseData.put("status", true);
                responseData.put("data", existDta);
            } else {
                responseData.clear();
                responseData.put("msg", "There is no book exists by this id..");
                responseData.put("status", false);
                responseData.put("data", null);
            }
            return responseData;
        } catch (Exception e){
            responseData.clear();
            responseData.put("msg", e.getMessage());
            responseData.put("status", false);
            responseData.put("data", null);
            return  responseData;
        }
    }

    public Object updateBook(Integer bookId, BookModel updtBkDta){
        try {
            Map<String, Object> responseData = new HashMap<>();

            if(bookRepository.existsById(bookId)){
                BookModel updatedDta = bookRepository.save(updtBkDta);
                responseData.put("msg", "Book updated successfully");
                responseData.put("status", true);
                responseData.put("data", updatedDta);
                return responseData;
            } else {
                responseData.put("msg", "There is no book exists by this id..");
                responseData.put("status", false);
                responseData.put("data", null);
                return responseData;
            }
        } catch (Exception e){
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("msg", e.getMessage());
            responseData.put("status", false);
            responseData.put("data", null);
            return  responseData;
        }
    }
}
