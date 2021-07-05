package chapter01.Refactoring14;

public class ChildrensPrice extends Price{

    double getCharge(int daysRented) {
        double result =1.5;
        if(daysRented > 3)
            result += (daysRented - 3) * 1.5;	
        return result;
    }
}
