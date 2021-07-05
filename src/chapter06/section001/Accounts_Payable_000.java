package chapter06.section001;

import java.util.ArrayList;

public class Accounts_Payable_000 {

    private String _name = "山田太郎";

    void pringOwing(){

        ArrayList<Double> a = new ArrayList<>();

        a.add(1200.0);
        a.add(2400.0);
        a.add(1350.0);
        a.add(4600.0);

        double outstanding;

        //バナーの印刷
        System.out.println("**************************");
        System.out.println("*********未払金請求書*******");
        System.out.println("**************************");

        //未払金の計算
        outstanding = a.stream().mapToDouble(Double::doubleValue).sum();

        //明細の印刷
        System.out.println("お名前:" + _name);
        System.out.println("合計金額:" + outstanding);

    }
}
