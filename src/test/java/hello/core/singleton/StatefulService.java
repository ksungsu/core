package hello.core.singleton;

/**
 * Caution while Using Singleton container
 * Example
 */

public class StatefulService {

//    private int price; 전역변수로 선언 x

    public int order(String name, int price){
        System.out.println("name = " + name);
        System.out.println("price = " + price);
        //        this.price = price; //여기가 문제!
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
