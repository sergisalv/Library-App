package com.sergisalv.AppLibrary.service;

import com.sergisalv.AppLibrary.entity.Book;
import com.sergisalv.AppLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void updateBook(Long id, Book book) {
        Book bookBd = findBookById(id).get();
        bookBd.setTitle(book.getTitle());
        bookBd.setAuthor(book.getAuthor());
        bookBd.setIsbn(book.getIsbn());
        bookBd.setDescription(book.getDescription());

        bookRepository.save(bookBd);


    }

    @Override
    public void deleteBookById(Long id) {

        bookRepository.deleteById(id);

    }
}
