package chapter06.section001;

import java.util.ArrayList;

public class Accounts_Payable_003_StreamAPIVer {

    private String _name = "山田太郎";

    public static void main(String[] args){
        Accounts_Payable_003_StreamAPIVer a = new Accounts_Payable_003_StreamAPIVer();
        a.pringOwing();
    }

    void pringOwing(){

        double outstanding;

        //バナーの印刷
        printBanner();

        //未払金の計算
        outstanding = getOutstanding();

        //明細の印刷
        printDetails(outstanding);

    }

    void printBanner(){

        System.out.println("**************************");
        System.out.println("*********未払金請求書*******");
        System.out.println("**************************");

    }

    void printDetails(double outstanding){

        System.out.println("お名前:" + _name);
        System.out.println("合計金額:" + outstanding);

    }

    double getOutstanding(){

        ArrayList<Double> aoutStandings = new ArrayList<>();

        aoutStandings.add(1200.0);
        aoutStandings.add(2400.0);
        aoutStandings.add(1350.0);
        aoutStandings.add(4600.0);

        double amount;
        amount = aoutStandings.stream().mapToDouble(Double::doubleValue).sum();

        return  amount;
    }

}
