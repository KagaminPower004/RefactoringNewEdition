package chapter01.Refactoring04;

public class Movie {
    
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;
    
    private String _title;
    private int _priceCode;
    
    public Movie(String title,int priceCode) {
        this._title = title;
        this._priceCode = priceCode;    
    }
    
    public int getPriceCode() {
        return this._priceCode;
    }
    
    public void setPriceCode(int arg) {
        this._priceCode = arg;
    }
    
    public String getTitle() {
        return this._title;
    }

}
