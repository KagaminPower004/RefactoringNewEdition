package chapter01.Refactoring13;

public class Rental {
    
    private Movie _movie;
    private int _daysRented;
    
    public Rental(Movie movie, int daysRented) {
        this._movie = movie;
        this._daysRented = daysRented;
    }
    
    public Movie getMovie() {
        return this._movie;
    }
    public int getDaysRented() {
        return this._daysRented;
    }    
    double getCharge() {
        return _movie.getCharge(_daysRented);
    }

    int getfrequentRenterPoints() {
            return _movie.getfrequentRenterPoints(_daysRented);
    }
}
