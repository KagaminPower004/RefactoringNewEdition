package chapter06.section001;

import java.util.ArrayList;

public class Accounts_Payable_003_ArrayLoopVer {

    private String _name = "山田太郎";

    public static void main(String[] args){
        Accounts_Payable_003_ArrayLoopVer a = new Accounts_Payable_003_ArrayLoopVer();
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

        ArrayList<Double> outStandings = new ArrayList<>();

        outStandings.add(1200.0);
        outStandings.add(2400.0);
        outStandings.add(1350.0);
        outStandings.add(4600.0);

        double amount = 0.0;
        for(double eachOutStanding : outStandings){
            amount += eachOutStanding;
        }

        return  amount;
    }

}
