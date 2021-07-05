package chapter01.Refactoring07;

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
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = this._rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            
            //レンタルポイントを加算
            frequentRenterPoints += each.getfrequentRenterPoints();
            
            //この貸し出しに関する数値の表示
            result += "\t" + each.getMovie().getTitle() + "\t" +
            String.valueOf(each.getCharge()) + " ドル\n";			
        }
        //フッター部分の追加
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + " ドル\n";
        result += "you earned " + String.valueOf(frequentRenterPoints) +
            "frequent renter points";
        
        return result;
    }
    
    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = this._rentals.elements();
        
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();			
            result += each.getCharge();
        }    
        return result;    
    }

}
