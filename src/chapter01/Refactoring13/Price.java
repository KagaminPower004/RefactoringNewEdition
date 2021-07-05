package chapter01.Refactoring13;

abstract class Price {
    abstract double getCharge(int daysRented);

    int getfrequentRenterPoints(int daysRented) {
        return 1;
    }
}
