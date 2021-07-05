package chapter01.Refactoring12;

public class Movie {
    
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;
    
    private String _title;
    private Price _price;
    
    public Movie(String title,int priceCode) {
        this._title = title;
        setPriceCode(priceCode);
    }
    
    public int getPriceCode() {
        return _price.getPriceCode();
    }
    
    public void setPriceCode(int arg) {

        switch(arg) {
            case REGULAR:
            _price = new RegularPrice();
            break;
            case NEW_RELEASE:
            _price = new ChildrensPrice();			
            break;
            case CHILDRENS:
            _price = new NewReleasePrice();
            break;
            default:
            throw new IllegalArgumentException("不正な料金コード");
        }
    }
    
    public String getTitle() {
        return this._title;
    }

    double getCharge(int daysRented) {
        double result = 0;

        //1行ごとに金額を計算
        switch(getPriceCode()) {
            case REGULAR:
            _price = new RegularPrice();
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
