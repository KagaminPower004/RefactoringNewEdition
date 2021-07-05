package chapter06.section002;

public class Amazon_Rating_001 {

    private int _numberOfLateDeliveries = 0;

    public static void main(String[] args){

        Amazon_Rating_001 amazon_rating = new Amazon_Rating_001();

        amazon_rating._numberOfLateDeliveries = 10;

        int Rating = amazon_rating.getRating();

        if(Rating >= 2){
            System.out.println("わろし");
        }
        else{
            System.out.println("よろし");
        }

    }

    int getRating(){
        return (_numberOfLateDeliveries > 5) ? 2 : 1;
    }
}
