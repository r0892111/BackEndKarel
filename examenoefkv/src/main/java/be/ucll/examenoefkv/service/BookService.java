package be.ucll.examenoefkv.service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

import be.ucll.examenoefkv.model.Book;
@Service
public class BookService {


    private List<Book> books = new ArrayList<>();
    public BookService(){

        Book aBookDonQuichot = new Book("Don Quichotte", 3, 20.7, true);
        Book aBookHarryPotter = new Book("Harry Potter", 5, 20.07, false);
        Book aBookJaneEyre = new Book("Jane Eyre", 4, 33.02, true);
        Book aBookTheHobbit = new Book("The Hobbit", 1, 50.5, true);
        Book aBookToKillAMockingbird = new Book("To kill a Mockingbird", 1, 35.03, false);
        Book aBookTheSilentPatient = new Book("The Silent Patient", 7, 60, true);
        // Book anExtraBook = new Book("The Extra", 3, 22.00, false);

        addBook(aBookDonQuichot);
        addBook(aBookHarryPotter);
        addBook(aBookJaneEyre);
        addBook(aBookToKillAMockingbird);
        addBook(aBookTheHobbit);
        addBook(aBookTheSilentPatient);
    }


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
            if (book.getTitle().equals(title) ){
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
