package chapter01.Refactoring11;

public class Movie {
    
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;
    
    private String _title;
    private int _priceCode;
    
    public Movie(String title,int priceCode) {
        this._title = title;
        setPriceCode(priceCode);
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

    double getCharge(int daysRented) {
        double result = 0;

        //1行ごとに金額を計算
        switch(getPriceCode()) {
            case REGULAR:
            result +=2;
            if(daysRented > 2)
            result += (daysRented - 2) * 1.5;
            break;
            case NEW_RELEASE:
            result += daysRented * 3;
            break;
            case CHILDRENS:
            result += 1.5;
            if(daysRented > 3)
            result += (daysRented - 3) * 1.5;
            break;
        }
        return result;
    }
    int getfrequentRenterPoints(int daysRented) {
        if((getPriceCode() == NEW_RELEASE)    && daysRented > 1)
            return 2;
        else
            return 1;
    }

}
