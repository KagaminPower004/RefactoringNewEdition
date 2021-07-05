package chapter01.Refactoring14;

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

    private int getFrequentRenterPoints() {
        int result = 0;    
        Enumeration<Rental> rentals = this._rentals.elements();
        
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getfrequentRenterPoints();
        }
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
    
    public String statement() {

        Enumeration<Rental> rentals = this._rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            
            //この貸し出しに関する数値の表示
            result += "\t" + each.getMovie().getTitle() + "\t" +
            String.valueOf(each.getCharge()) + " ドル\n";			
        }
        //フッター部分の追加
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + " ドル\n";
        result += "you earned " + String.valueOf(getFrequentRenterPoints()) +
            "frequent renter points";
        
        return result;
    }
    public String htmlStatement() {

        Enumeration<Rental> rentals = this._rentals.elements();
        String result = "<H1>Rental Record for <EM>" + getName() + "</EM></H1><P>\n";
        
        while(rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            
            //この貸し出しに関する数値の表示
            result += "<Pre> &#009;" + each.getMovie().getTitle() + " &#009;" +
            String.valueOf(each.getCharge()) + " ドル</Pre>\n";			
        }
        //フッター部分の追加
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + " ドル</EM><P>\n";
        result += "you earned " + String.valueOf(getFrequentRenterPoints()) +
            "frequent renter points<P>";
        
        return result;
    }
}
