package be.ucll.examenoefkv.controller;
import be.ucll.examenoefkv.model.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import be.ucll.examenoefkv.service.BookService;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
// @RequestMapping("/books")

public class BookRestController {
    @Autowired 
    private BookService bookService;

    @GetMapping("/api/book/all")
    public List<Book> fetchBooks(){
        return bookService.getAllBooks();
    }
}
