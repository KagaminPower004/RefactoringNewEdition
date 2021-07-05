package chapter01.Refactoring13;

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
    
    public String getTitle() {
        return this._title;
    }

    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    int getfrequentRenterPoints(int daysRented) {
        return _price.getfrequentRenterPoints(daysRented);
    }
    
    public void setPriceCode(int arg) {

        switch(arg) {
            case REGULAR:
            _price = new RegularPrice();
            break;
            case NEW_RELEASE:
            _price = new NewReleasePrice();			
            break;
            case CHILDRENS:
            _price = new ChildrensPrice();
            break;
            default:
            throw new IllegalArgumentException("不正な料金コード");
        }
    }
}
