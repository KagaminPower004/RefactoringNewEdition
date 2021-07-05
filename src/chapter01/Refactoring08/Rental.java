package chapter01.Refactoring08;

public class Rental {
    
    private Movie _movie;
    private int _daysRented;
    
    public Rental(Movie movie, int daysRented) {
        this._movie = movie;
        this._daysRented = daysRented;
    }
    public int getDaysRented() {
        return this._daysRented;
    }
    public Movie getMovie() {
        return this._movie;
    }
    
    double getCharge() {
        double result = 0;

        //1行ごとに金額を計算
        switch(getMovie().getPriceCode()) {
            case Movie.REGULAR:
            result +=2;
            if(getDaysRented() > 2)
            result += (getDaysRented() - 2) * 1.5;
            break;
            case Movie.NEW_RELEASE:
            result += getDaysRented() * 3;
            break;
            case Movie.CHILDRENS:
            result += 1.5;
            if(getDaysRented() > 3)
            result += (getDaysRented() - 3) * 1.5;
            break;
        }
        return result;
    }
    
    int getfrequentRenterPoints() {
        if((getMovie().getPriceCode() == Movie.NEW_RELEASE)    && getDaysRented() > 1)
            return 2;
        else
            return 1;
    }

}
