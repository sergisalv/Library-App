package com.sergisalv.AppLibrary.service;

import com.sergisalv.AppLibrary.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAllBooks();

    Optional<Book> findBookById(Long id);

    Book saveBook(Book book);

    void updateBook(Long id, Book book);

    void deleteBookById(Long id);
}
