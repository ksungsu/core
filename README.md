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

# TIL(2021.11.17)(27th day)✔

</br>

## Spring Container 🎯 
* BeanDefinition (= interface)이 아래 데이터들(metadata)의 추상화 역할을 해서 읽어드린다. 
	* AppConfig.class (= 구현체)
    * appConfig.xml
    * appConfig.xxx
    
</br>
    
## Singleton Pattern🎯
* pure java는 웹(클라이언트)에서 요청이 올때마다 새로운 객체를 생성한다. 이는 Memory waste를 초래한다 
	* 해결방안 : Singleton pattern을 사용한다. 
    	* Singleton은 하나의 객체만 생성하고 공유하도록 설계가 가능하다.
    
### Problems of Singleton Pattern 
* DIP 위반
* 테스트의 어려움
* 복수의 생성자 생성의 어려움(다형성을 크게 떨어트림)

</br>

## SpringContainer(SingletonContainer) 🎯
* object들을 모두 singleton화 시켜줌.(전부터 궁금했던 순수 자바코드보다 spring이 더 좋은 이유를 알게됨.)
* singleton pattern의 단점을 해결

### Singleton 방식의 주의점
* 같은 객체를 공유하기 때문에 값이 유지(stateful)하게 설계하면 안된다.(무상태로 설계해야한다.)
	* 지역변수, 파라미터, ThreadLocal 등을 사용해야한다.
    * 필드 공유 값을 설정하면 큰 장애가 발생할 수 있다.

</br>

## @Configuration🎯
* 바이트코드 조작 라이브러리로 AppConfig를 AppConfig@CGLIB 클래스(AppConfig의 자식파일)로 치환(?)해준다.
	* 싱글톤 성질을 보장시켜준다.
    * 스프링 컨테이너 적재 유무에 따라 자동으로 적재해주고 반환해준다.
    * Annotation Configuration을 선언해주지 않으면 싱글톤 성질이 깨지고, AppConfig 내에 따로 객체를 생성해서 의존성 주입을 해줘야한다
		* memberRepository와 같은..

</br>

## 궁금한점 📌
* logic 사용의 이유
* singleton이 DIP를 위반하는 이유
	* singleton에서 선언한 getInstance()를 AppConfig에 적용시켜야하는데 이로 인해, interface에 변경을 이르킨다. 
    * 즉, DIP를 위반한다.
* 다형성이란? 
	* 오버라이딩을 통한 설정 바꾸기, 
    * ex) 오버워치라는 인터페이스와 캐릭터라는 구현체로 분리, 캐릭터마다 가진 스킬들이 다름 이를 오버라이딩으로 변경함.


</br>

### MyBlog😊😊
https://hardkeepgoing.tistory.com/
