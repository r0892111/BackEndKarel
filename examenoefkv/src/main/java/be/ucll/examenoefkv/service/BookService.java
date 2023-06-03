package be.ucll.examenoefkv.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

import be.ucll.examenoefkv.model.Book;
@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    public BookService(){}


    public List<Book> getBooks(){
        return books;
    }
    public boolean addBook(Book book){
        if (book == null) return false;
        if (isTitleUnique(book.getTitle())==true){
            books.add(book);
            return true;
        }return false;
    }
    public boolean isTitleUnique(String title){
        // if (title.equals(null)) return false;
        for (Book book : books){
            if (book.getTitle().equals(title)==true){
                return false;
            }
        }
        return true;
    }

    public double getTotalValueOfCollection(){
        double result = 0.0;
        for (Book book : books){
            result += book.getPrice()*book.getNumberInStock();
        }
        return result;
    }

    public Book getMostExpensiveBook() {
        Book mostExpensiveBook = null;
        double maxPrice = 0.0;
        
        for (Book book : books) {
            if (book.getPrice() > maxPrice) {
                maxPrice = book.getPrice();
                mostExpensiveBook = book;
            }
        }
        
        return mostExpensiveBook;
    }

    public List<Book> getBooksWithPriceMoreThen(int price){
        List<Book> result = new ArrayList<Book>();
        for (Book book : books){
            if(book.getPrice()>price){
                result.add(book);
            }
        }
        return result;
    }

    public Book getBookWithTitle(String title){
        for (Book book : books){
            if (book.getTitle() == title){
                return book;
            }
        } 
        return null;  
    }

    public List<Book> getBooksInColor(){
        List<Book> result = new ArrayList<Book>();
        for (Book book : books){
            if (book.isInColor() == true){
                result.add(book);
            }
        } 
        return result;  
    }

    public Book removeBookWithTitle(String title){
        for(Book book: books){
            if (book.getTitle().equals(title) ){
                books.remove(book);
                return book;
            }
        }
        return null;

    }

    public Book removeBook (Book book){
        if (books.contains(book) == true){
            books.remove(book);
            return book;
        }
        
        return null;
    }

}
