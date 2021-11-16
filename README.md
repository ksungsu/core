# core

## TIL(2021.11.14)(24th day)📌

* Object-Oriented Design
* On Pure Java
* create Interface and 구현체 분리
* OCP, DIP
* SOLID
* Create Junit Test 

</br>

## TIL(2021.11.15)(25th day) ✔

* 변화에 대응하는 객체지향 설계(애자일 실행 관례)
  * interface와 구현체의 분리 
 
 </br>
 
* AppConfig 구현 (생성자 주입을 통한 관심사 분리)
  * 구현체가 구현체에 의존하지 않도록 설정.
  * 실제 동작에 필요한 "구현 객체를 생성"
  * 생성한 객체 인스턴스의 참조를 "생성자를 통해 주입(연결)" 해준다.
  * DI(Dependency Injection), 의존관계 주입
  * "사용 영역"과 "구성 영역"의 분리
  
* SRP(한 클래스는 하나의 책임)
  * 클라이언트는 실행만, AppConfig를 통해 연결과 구성요소를 생성 ]
   
* OCP(sw 확장에는 열려있으나 변경에는 닫혀있어야 한다.)
  * 전제조건 : 다형성 + DIP
  * 사용 영역과 구성 영역을 분리
  * 그로 인해 구성 영역만 변경, 사용 영역은 변경하지 않으므로
  * 확장에는 열려있고 변경에는 닫혀있음을 만족   

* DIP(의존관계 역전 원칙) 적용
  * AppConfig에서 클라이언트 대신 객체 인스턴스를 생성해서 의존관계를 주입  

</br>

* IOC
  * Inversion Of Control
  * 제어의 역전
  * AppConfig가 등장한 이후 객체는 실행하는 역할만 담당
  * AppConfig에서 생성과 연결을 모두 결정
  * 프로그램 제어 흐름은 AppConfig가 가져간다.
  * 이렇듯 프로그램 제어 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 제어의 역전(IoC)라고 한다.

</br>

* 프레임워크 vs 라이브러리
  * 프레임워크 : 내가 작성한 코드를 제어하고, 대신 실행함.(ex) Junit test)
  * 라이브러리 : 내가 작성한 코드(호출)가 직접 제어의 흐름을 담당.(ex) xml, JSQL)

</br>

* 의존관계 주입(DI)
  * 정적인 클래스 의존관계 or 동적인 객체(인스턴스) 의존 관계
    * 정적인 클래스 의존관계 : 인터페이스와의 의존관계(ex) MemberRepository, DiscountPolicy), 실행하지 않아도 분석가능
    * 동적인 클래스 의존관계 : 인터페이스 안에 변경 가능한 구현체와의 관계(ex) FixDiscountPolicy, RateDiscountPolicy ), 실행해야 분석 가능 
  * 정적인 클래스 의존관계는 변경하지 않고, 동적인 객체 의존 관계만을 변경할 수 있다.

* IoC container, DI container
  * AppConfig 처럼 객체를 생성하고 관리하면서 의존관계를 연결해주는것을 의미
  * 주로 DI 컨테이너라고함
  * 또는 어샘블러, 오브젝트 팩토리 등으로 불림 

</br>

* springContainer 📌
  * `ApplicationContext` = 스프링 컨테이너
    * spring DI
    * @Bean, @Configuration

</br>

## TIL(2021.11.16)(26th day) ✔
* spring container
 * find spring container all of bean
 * Find bean using role and definition.
 * Find same type bean(getBeansOfType)
 * 부모 타입 조회 = 자식 타입도 함께 조회.

</br>

* BeanFactory or SpringContainer
 * ApplicationContext
* Using XML ApplicationContext  and Tested

</br>

### MyBlog😊😊
https://hardkeepgoing.tistory.com/
