package be.ucll.examenoefkv.controller;
import be.ucll.examenoefkv.model.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


import be.ucll.examenoefkv.service.BookService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/book")

public class BookRestController {
    @Autowired 
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> fetchBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/totalValue")
    public double getTotalValue(){
        return bookService.getTotalValueOfCollection();
    }

    @GetMapping("/mostExpensive")
    public Book getMostExpensive(){
        return bookService.getMostExpensiveBook();
    }

    @GetMapping("/search/priceMoreThen")
    public List<Book> getBooksWithPriceMoreThen(@RequestParam("price") int price){
        return bookService.getBooksWithPriceMoreThen(price);
    }

    @GetMapping("/search/title/{title}")
    public Book getBookByTitle(@PathVariable("title") String title){
        return bookService.getBookWithTitle(title);
    }

    @GetMapping("/search/inColor")
    public List<Book> getBookByColor(){
        return bookService.getBooksInColor();
    }
}
