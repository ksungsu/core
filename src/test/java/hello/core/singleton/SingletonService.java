package hello.core.singleton;

/**
 * Create one Object and share
 * Using singleton pattern
 */

public class SingletonService {
    //클래스 내부에서 객체를 생성하고 instance에 객체를 저장
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //외부에서 SingletonService 객체 생성 막기(실무에서 중요)
    private SingletonService() {};

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
