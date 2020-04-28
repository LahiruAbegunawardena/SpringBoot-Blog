package com.springboot.blog.Books;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookModel, Integer> {}
