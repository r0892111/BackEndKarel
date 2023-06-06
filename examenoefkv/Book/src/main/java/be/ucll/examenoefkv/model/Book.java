

package be.ucll.examenoefkv.model;



public class Book {
    public String title;
    public int numberInStock;
    public double price; 
    public boolean inColor;

    public Book(String title, int numberInStock, double price, boolean inColor){
        this.title = title;
        this.numberInStock = numberInStock;
        this.price = price;
        this.inColor = inColor;
    }
    public Book(){ }
    

    public String getTitle(){
        return title;
    }
    public int getNumberInStock(){
        return numberInStock;
    }
    public double getPrice(){
        return price;
    }
    public boolean getinColor(){
        return inColor;
    }
    public double getPriceInDollar(){
        return price*1.06;
    }
    public boolean isInColor(){
        if (inColor==true){
            return true;
        }
        return false;
    }

    public void setTitle(String newtitle){
        title = newtitle;
    }
    public void setPrice(double newprice){
        price = newprice;
    }

    public void setNumberInStock(int newnumberInStock){
        numberInStock = newnumberInStock;
    }
    public void setInColor(boolean newinColor){
        inColor = newinColor;
    }
    public Book addBook(String title, int numberInStock, double price, boolean inColor){
        return new Book(title, numberInStock, price, inColor);
    }

    @Override
    public String toString(){
        if(inColor == true){
            return title+" costs €"+price+". There are "+numberInStock+" items present. The book is in color.";
        }
        return title+" costs €"+price+". There are "+numberInStock+" items present. The book is not in color.";

    }
}
