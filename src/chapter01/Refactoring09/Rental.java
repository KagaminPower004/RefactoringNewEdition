package chapter01.Refactoring09;

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
        return _movie.getCharge(_daysRented);
    }
    
    int getfrequentRenterPoints() {
        if((getMovie().getPriceCode() == Movie.NEW_RELEASE)    && getDaysRented() > 1)
            return 2;
        else
            return 1;
    }

}
