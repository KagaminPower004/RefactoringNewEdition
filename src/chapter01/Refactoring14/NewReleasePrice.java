package chapter01.Refactoring14;

public class NewReleasePrice extends Price{

    int getfrequentRenterPoints(int daysRented) {
        if(daysRented > 1)
            return 2;
        else
            return 1;
    }

    double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
