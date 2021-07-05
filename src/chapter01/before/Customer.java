package chapter01.before;

import java.util.*;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<Rental>();
    
    public Customer(String name) {
        this._name = name;
    }
    public void addRental(Rental arg) {
        this._rentals.addElement(arg);
    }
    public String getName() {
        return this._name;
    }
    
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this._rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        
        while(rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();
            
            //1行ごとに金額を計算
            switch(each.getMovie().getPriceCode()) {
            case Movie.REGULAR:
            thisAmount +=2;
            if(each.getDaysRented() > 2)
            thisAmount += (each.getDaysRented() - 2) * 1.5;
            break;
            case Movie.NEW_RELEASE:
            thisAmount += each.getDaysRented() * 3;
            break;
            case Movie.CHILDRENS:
            thisAmount += 1.5;
            if(each.getDaysRented() > 3)
            thisAmount += (each.getDaysRented() - 3) * 1.5;
            break;
            }
            
            //レンタルポイントを加算
            frequentRenterPoints ++;
            //新作を二日以上借りた場合はボーナスポイント
            if((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
            && each.getDaysRented() > 1) frequentRenterPoints ++;
            
            //この貸し出しに関する数値の表示
            result += "\t" + each.getMovie().getTitle() + "\t" +
            String.valueOf(thisAmount) + " ドル\n";
            
            totalAmount += thisAmount;
        }
        //フッター部分の追加
        result += "Amount owed is " + String.valueOf(totalAmount) + " ドル\n";
        result += "you earned " + String.valueOf(frequentRenterPoints) +
            "frequent renter points";
        
        return result;
    }
}