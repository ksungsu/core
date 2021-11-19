package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Example Using Lombok
 */

@Getter
@Setter
@ToString
public class HelloLombok {
    private  String name;
    private  int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("kimsungsu");
        helloLombok.setAge(25);
        
        String name = helloLombok.getName();
        System.out.println("name = " + name);

        System.out.println("helloLombok = " + helloLombok);
    }
}
