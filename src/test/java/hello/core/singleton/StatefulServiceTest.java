package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

//        //ThreadA : 사용자A 10000원 주문
//        statefulService1.order("UserA", 10000);
//        //ThreadB : 사용자B 20000원 주문
//        statefulService2.order("UserB", 20000);
//
//        //ThreadA : 사용자A 주문 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println("UserA price = " + price);
//
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

        /**
         * local variable
         * singleton pattern warning point solving
         */

        int userAPrice =  statefulService1.order("UserA", 10000);
        int userBPrice =  statefulService2.order("UserB", 20000);

         System.out.println("UserA Price = " + userAPrice);
         Assertions.assertThat(userAPrice).isEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
