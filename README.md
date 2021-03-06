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

## TIL(2021.11.18)(28th day)
## ComponentScan 📌
-   @Bean을 일일히 생성하지 않고, 자동으로 스프링빈 생성해주는 기능.(@Component를 클래스마다 추가해야함.)
-   @AutoWire를 이용해 의존관계주입
-   AppConfig(메인 설정 파일) 하위가 모두 컴포넌트 스캔 대상이되고, AppConfig가 있는 루트에 coreApplication(시작 정보)를 두는것이 관례이다.  
-   ComponentScan filter기능(보통 잘 사용하지 않음, 스프링 기본 설정을 최대한 맞춰 사용하는것이 좋다.)
-   수동빈 vs 자동빈(애매한 버그가 일어날 수 있기 때문에 오류가 발생한다.)(단, 설정을 통해 가능하게 할수도 있다.)
​
</br>
​
## 궁금한점 📌
- beanA, beanB 메서드는 선언해주지 않았는데 어떻게 사용가능한가?(get.Bean()에서)
    - 스프링 빈으로 자동 등록된 클래스는 불러(호출)올 때?, 앞글자가 '소문자'가 되는 특성이 있기때문이다.

</br>

# TIL(2021.11.19)(29th day)

## 다양한 의존관계 주입 방법
-	생성자 주입(가장 선호하는 방식)
	- 한번만 호출하는 방식, '불변', '필수' 의존관계에 사용
    - 의존 클래스를 구분할 수 있다.
    - final 사용 가능
    - 필수 주입 데이터 '누락'을 "컴파일 오류"로 구분 가능하다.
    
-	수정자 주입(setter 주입)
	- '선택', '변경' 가능성이 있는 의존관계에 사용

-	필드 주입(참고, 필드 자체를 변경하지 않고 getXxx(), setXxx() 메서드를 통해 변경하는 java bean properties rules)
	- 안티 패턴(높은 결합도(OCP 위반), 단위테스트가 어렵다.)

-	일반 메서드 주입
	- 한번에 여러 필드를 주입 받을 수 있다.(잘 쓰이지 않음)

### 정리
-	생성자 방식은 순수 자바 언어의 특징을 잘 살려준다.(프레임워크에 의존하지 않아도 된다.)
-	기본으로 생성자 주입을 사용하고, 필수 값이 아닌 경우 수정자 주입을 사용한다.

</br>

## 옵션 처리
-	스프링 빈 등록이 안되어있어도 호출하고 싶을 때 사용.

</br>

## 롬복
-	 getter and setter, constructor 등을 Annotation으로 자동 생성
-	중복 타입이 존재할 시 해결방법(3가지)
	- @AutoWired 필드 또는 파라미터명 매칭
	- @Qulifier 추가 구분자를 붙여주는 방법(귀찮아서 잘 안씀)(Primary는 자동설정이기 때문에 수동 설정인 Qulifier가 우선순위가 놓다)
    - @Primary는 우선권을 정하는 방법(간편해서 많이 씀)
    
</br>
    
## 궁금한점 📌
- implements와 extends의 차이점
	- extends는 상속 또는 abstract에 사용
    - implements는 "interface 구현체에" 사용
    
- ToString의 역할
	- 객체의 정보를 반환해줌.

</br>

## TIL(30th day)(2021.11.20)✔

## 조회한 빈이 모두 필요한 경우 📌
- 	List, Map
	-	ex) 할인의 종류 rate or fixDiscountPolicy 둘다 필요한경우
    
</br>

## 실무에서의 자동 그리고 수동 📌
-	스프링빈은 많은 기능을 자동으로 지원한다. 이를 적극적으로 활용하는것이 좋다.
	-	업무 로직 빈과 기술 지원 빈이 있다.
    	-	업무 로직 빈에는 '자동'이, 기술 지원 빈에는 '수동'이 유지보수에 유리하다.
        -	그 이유는, 기술 지원은 광범위하게 적용되고 그 수가 적어서 오류가 일어나는 부분을 확실하게 찾을 수 있도록 수동으로 등록해주는것이 유리하기 때문이다.
        -	반면에, 업무 로직 빈(비즈니스 로직)에서도 '수동' 선언이 좋을 때가 있다.
		-	ex) '다형성'을 사용할 때,(List, Map) 또는 여러 빈을 사용해야할때
		-	왜? ) 다른 사람이 내 코드를 봤을 때 한눈에 이해할 수 있도록하기 위해

</br>

## 궁금한점 📌
-   스프링빈에서 얘기하는 타입의 정확한 의미는?
	- java 에서는 primitive type(기본 타입)과 reference type(참조 타입)을 지원한다.
    	- primitive type은 정수, 실수, 문자, 논리 리터럴을 저장하는 타입
        - reference type은 객체의 번지를 참조하는 타입으로, 배열, 열거, 클래스, 인터페이스 타입
        
-	Map<k,v>에서 key 값에 String이 들어가는 이유는?
	-	 springbean에서 호출할 때 타입을 앞글자가 소문자인 String으로 받아오기 때문에 (ex) discountPolicy)
    
-	isInstanceOf의 정확한 의미는?
	-	ex) assertThat(discountService).isInstanceOf(DiscountService);
    	-	discountService는 DiscountService 타입으로 받을 수 있는지를 묻는것.
        -	즉, DiscountService라는 interface안에 discountService 구현체가 있는지 물어보는것.

-	rateDiscountPolicy.class에 @Primary annotation을 추가해서 중복 빈 조회 에러를 방지했다. 
	-	fixDiscountPolicy를 선언해줘서 할인가가 1000원으로 고정되게 설정했다. 
    -	RateDiscountPolicy가 @Primary여서 우선원을 갖게되는데, 이때 내가 원하는 결과가 나오지 않을까했다.
    	-	 하지만, 결과는 1000원의 고정된 할인가를 반영했다. 하지만 한번이라도 정률 할인 방식이 적용되면 그건 문제가 되기에
        	의문이다. 내가 설정한 정액할인가가 모든 케이스에 적용이될까?  
		
</br>

# TIL 31th day(2021.11.21)

## 초기화 및 소멸자 콜백📌

-   외부라이브러리 수정이 불가피할때는
    -   @Bean의 initMethod와 destroyMethod를 사용
-   외부라이브러리 수정이 불필요할때는
    -   PostConstruct, PreDestroy Annotation 사용
    
## 빈 스코프📌

* 싱글톤 스코프(항상 같은 객체 스프링 빈을 반환한다.) : 기본 스코프

* 프로토타입 빈
    * 스프링 컨테이너에서 조회할 때마다 새로운 스프링 빈 생성하고, 자동으로 의존관계 주입 및 반환
    * 스프링 컨테이너에서 관리 x, 클라이언트에서 관리 o, 직접 destroy를 선언
    
## 싱글톤 빈과 프로토타입 빈을 같이 사용했을 시 문제점
* 싱글톤 빈에 포함되어있는 프로토타입 빈은 이미 의존관계 주입이 완료된 상태이므로 새로 생성되지 않는다!

## 싱글톤 빈과 프로토타입 빈을 같이 사용했을 시 문제점 해결방법📌
* 자바표준에서 제공하는 provider 또는 스프링에서 제공하는 provider를 사용한다.(DL:Dependency Lookup)

## 웹 스코프📌
* request scope
	* 서로다른 HTTPrequest 요청이 들어오면 서로다른 빈 스코프를 생성 및 반환 및 소멸
    * UUID로 HTTPrequest 구별.
    * 실질적인 요청이 없을땐 Provider를 사용(Provider가 빈의 생성을 지연시켜주기 때문.)
    	* 스프링 컨테이너에 의존관계 주입이 HTTP요청보다 먼저 실행되기 때문에 요청자체를 받지 못한다. 
       	* 그렇기 때문에 스프링 컨테이너 의존관계 주입 순서를 뒤로 늦춰주어야하고, Provider를 통해 의존관계 주입을 늦춰주는것이다.
        * 어떻게 주입을 늦춰주는가?
        	* Provider는 요청이 왔을 때 스프링 컨테이너에 빈을 생성하는 성질을 갖고있다. 따라서, HttpRequest와 동시에 빈에 생성된다.
	* Provider의 대체 방식) Proxy
    	* 대리 객체로 지정되어있다가 Http요청이 오면 진짜 객체(클래스 또는 인터페이스)로 변환된다.
        * CGLIB에서 제공하는 proxy를 이용해 request scope를 싱글톤과 유사하게 사용할 수 있다.
	* Provider와 Proxy의 핵심
    	* 진짜 객체를 조회를 꼭 필요한 시점까지 지연처리한다는점.🎯(다형성과 DI가 가진 큰 장점)
    * Provider와 Proxy의 주의점
    	* 싱글톤과 비슷하지만 다르다.
        * 무분별한 사용 x(유지보수가 어려워짐)

## 궁금한점 📌
* @Controller란?
	* 요청을 받고, 결정
    * 요청 수행은 @Service에서, 
    * @Service 클래스는 수정을 최소화하는 것이 유지보수에 유리
    * View를 결정해서 보여주는 역할
    
* @RequestMapping이란?
	* 요청에 대한 어떤 Controller 또는 어떤 메소드가 처리할지 결정.
    
* @ResponseBody란?
	* 리턴을 view를 통해서가 아닌 HTTP Response Body 에 직접 쓰여지게된다.
    
* HttpServletRequest란?
	* 사용자의 요청정보를 가져올 수 있다.
    * 예로) 사용자 아이디, 비밀번호를 요청하면 그 데이터를 HttpServletRequest에 넣어준다.
   

* getRequestURL()이란?
	* 사용자가 어떤 URL로 요청했는지 알 수 있다.




</br>

### MyBlog😊😊
https://hardkeepgoing.tistory.com/
