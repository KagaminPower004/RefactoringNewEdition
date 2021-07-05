package chapter01.Refactoring14;

public class Boy {
    
    public static void main(String args[]) {
        
        //ビデオを選択
        Movie favo = new Movie("死霊のはらわた2021",1);
        Movie homework = new Movie("愛は霧のかなたに",2);
        Movie study = new Movie("検証!!新説タイタニック",2);
        
        //ビデオをレンタル
        Rental first = new Rental(favo,5);
        Rental second = new Rental(homework,1);
        Rental third = new Rental(study,2);
        
        //顧客登録
        Customer me = new Customer("山田 太郎14");
        
        //会計
        me.addRental(first);
        me.addRental(second);
        me.addRental(third);
        
        //計算書生成
        String statement = me.statement();
        
        //計算書の出力ww
        System.out.print(statement);
        
    }

}
