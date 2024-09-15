package com.sergisalv.AppLibrary.controller;

import com.sergisalv.AppLibrary.entity.Book;
import com.sergisalv.AppLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String listAllBooks(Model model) {

        model.addAttribute("books", bookService.findAllBooks());
        return "/bookList";
    }
    @GetMapping("/newBook")
    public String registerNewBook(){
        return "registerBook";
    }

    @PostMapping("/saveBook")
    public String saveBook(Book book){
        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable Long id, Model model){
        Book book = bookService.findBookById(id).get();
        //Envía a la vista el libro que hemos capturado
        model.addAttribute("book", book);
        return "/editBook";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
        return"redirect:/";
    }

}
