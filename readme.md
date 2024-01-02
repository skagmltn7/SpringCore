# 스프링 핵심원리 -기본편 코드


<br/>

![img](https://velog.velcdn.com/images/yu-jin-song/post/fbed9147-c8dc-4b09-8dfd-1ef4df046ab1/7264214.png)

김영한 님의 스프링 핵심 원리 - 기본편(https://url.kr/5bhain) 을 수강하며 학습한 내용의 코드입니다. 모든 출처는 해당 강의에 있습니다.

# 좋은 객체 지향 프로그래밍

## 객체지향특징

- `추상화(Abstraction)`
    - 공통의 속성이나 기능을 묶어 이름을 붙이는 것
- `캡슐화(Encapsulation)`
    - 하나의 목적에 따라 데이터의 구조와 데이터를 다루는 방법들을 결합시켜 묶는 것
    - 변수와 함수를 하나로 묶어 **외부에서는 오로지 함수에서만 접근 가능하도록 함**
- `상속(Inheritance)`
    - 하위 개념이 상위 개념의 특징을 물려받는 것
- `다형성(Polymorphism)`
    - 하나의 객체가 여러 가지 형태를 가지는 것

## 다형성

`역할과 구현을 세계로 구분하는 예제`

### 운전자 - 자동차

![자동차](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/1f0f175f-405a-4c34-9dcd-4235b680c6f0)

- 자동차를 운전하는 역할의 운전자
- 자동차의 기종은 k3, 아반떼 테슬라 모델3
- 운전자는 자동차의 기종과 상관없이 자동차를 운전할 수 있음
- **운전자는 자동차 인터페이스만 알고 기종은 몰라도 됨**

### 공연 무대

![공연](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/296e3664-20b6-4211-881a-9980ac5767cc)

- 로미오와 줄리엣이라는 역할
- 로미오와 줄리엣을 맡을 수 있는 배우
- 로미오를 맡는 배우가 달라진다해도 공연에는 아무런 영향X

### 역할과 구현을 분리

- 클라이언트는 역할(인터페이스)만 알면 됨
- 클라이언트는 구현 대상의 내부 구조를 몰라도 됨
- 클라이언트는 구현 대상의 내부 구조가 변경되어도 영향 받지 않음
- 클라이언트는 구현 대상 자체를 변경해도 영향 받지 않음

#### 자바

- 자바 언어의 다형성 활용
    - 역할 = 인터페이스
    - 구현 = 인터페이스를 구현한 클래스, 구현 객체
- 객체 설계 시 역할과 구현을 명확히 분리
- 객체 설계시 역할을 먼저 부여하고 그 역할을 수행하는 구현 객체를 생성

#### 스프링

- 스프링은 다형성을 용이하게 사용할 수 있게 함
- 스프링의 제어 역전(IoC), 의존 관계 주입(DI)은 다형성을 통해 역할과 구현을 용이하게 해줌
- 구현을 편리하게 변경

# 좋은 객체 지향 설계의 5가지 원칙(SOLID)

- **SRP** : 단일 책임 원칙 (Single Responsibility Principle)
- **OCP** : 개방-폐쇄 원칙 (Open-Closed Principle)
- **LSP** : 리스코프 치환 원칙 (Liskov Substitution Principle)
- **ISP** : 인터페이스 분리 원칙 (Interface Segregation Principle)
- **DIP** : 의존관계 역전 원칙 (Dependency Inversion Principle)

## SRP : 단일 책임 원칙

`하나의 클래스는 하나의 책임만 가져야함`

- 책임을 구분하는 기준이 모호함
    - 문맥과 상황에 따라 다름
- 판단기준은 **변경**
    - 변경이 발생할 때 파급효과가 적을 수록 SRP GOOD

## OCP :개방-폐쇄 원칙

`소프트웨어 요소는 확장에는 열려있으나 변경에는 닫혀있어야 함`

- 코드 변경 없이 확장 가능 -> 다형성
- 인터페이스를 구현한 새로운 클래스를 만들어 새로운 기능 구현
- 역할과 구현의 분리

## LSP : 리스코프 치환 원칙

`객체는 프로그램의 정확성을 깨뜨리지 않으면서 하위 타입의 인스턴스로 바꿀 수 있어야 함`

- 다형성에서 하위 클래스는 인터페이스 규약을 모두 지켜야함
- 리스코프 치환 원칙을 통해 인터페이스를 구현한 구현체를 믿고 사용할 수 있음
    - 자동차 인터페이스의 엑셀은 자동차를 앞으로 가게하는 기능
    - 그러나 뒤로 간다면 LSP원칙 위배!

## ISP : 인터페이스 분리 원칙

`특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 나음`

- 자동차 인터페이스 -> 운전, 정비 인터페이스로 분리
- 사용자 클라이언트 -> 운전자, 정비사 클라이언트로 분리
- 분리할 경우 인터페이스가 변경되어도 운전자 클라이언트에 영향을 주지 않음
- 인터페이스가 명확해지고 대체 가능성이 높아짐

## DIP : 의존관계 역전 원칙

`추상화에 의존O, 구체화 의존X`

- 클라이언트 코드는 구현 클래스가 아닌 인터페이스에 의존
    - 운전자는 자동차를 운전하는 것, k3나 테슬라와 같은 기종에 의존x
    - 로미오를 연기하는 배우는 줄리엣에 의존하여 연기, 줄리엣의 배우가 달라진다해서 로미오 연기가 달리지면 X
- 구현이 아닌 역할에 의존
- 클라이언트가 인터페이스에 의존해야 유연하게 구현체 변경 가능
- 구현체에 의존하게 되면 변경이 어려워짐

# IoC, DI, 그리고 컨테이너

## IoC(Inversion of Control) : 제어의 역전

- 직접 호출하는 것이 아닌 프레임워크 등과 같은 외부에서 대신 호출하여 제어가 외부에서 관리되는 것

> :exclamation: 프레임워크와 라이브러리<br/>
> 기준 : 흐름에 대한 제어 권한이 어디 있는지?<br/>
> 프레임워크 : 프레임워크가 흐름 제어, 사용자는 개발에만 집중할 수 있음<br/>
> 라이브러리 : 사용자가 흐름 제어, 사용자가 필요한 상황에따라 가져다 씀<br/>

## DI(Dependency Injection) : 의존관계 주입

- 의존관계
  - 컴파일 시점에 알 수 있는 정적인 클래스 의존 관계
  - 런타임 시점에 결정되는 동적인 객체 의존 관계
  
### 정적인 클래스 의존 관계

![img](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/beb6ac52-7254-43c4-af3e-cf0498a91f04)

- 컴파일 시점에 의존 관계를 분석할 수 있음
- `OrderServiceImpl`은 `MemberRepository`와 `DiscountPolicy`에 대해 의존
  - DiscountPolicy가 `FixDiscountPolicy`인지 `RateDiscountPolicy`인지는 중요하지 않음
  - MemberRepository가 `MemoryMemberRepository`인지 `DbMemberRepository`인지는 중요하지 않음

### 동적인 객체 의존 관계

![img](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/a9162815-ff16-4552-a07b-729ffc5815e0)

- 어플리케이션 실행 시점에 생성된 객체 인스턴스의 참조가 연결된 의존관계
- 외부에서 호출하는 대상의 구현 객체를 생성하여 호출하는 대상에 참조값을 전달하여 연결
- DI를 통해 코드를 변경하지 않고 호출 인스턴스를 변경할 수 있음
- 정적인 클래스 의존관계를 변경하지 않고 동적인 객체 의존관계를 변경할 수 있음

## 스프링 컨테이너 : ApplicationContext

![img](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/92aa536e-d803-4b92-b686-94192de5e3ca)

- 순수 자바 코드로는 `AppConfig`를 통해 직접 객체 생성, 의존관계를 연결
- 이러한 설정은 스프링 컨테이너를 통해 자동으로 실행
- `@Configuration` : 설정 기능을 실행하는 정보로 사용
- `@Bean` : 반환된 객체를 스프링 컨텍스트에 등록(스프링 빈)
- 생명주기 
  1. 스프링 컨테이너 생성
  2. 스프링 빈 등록
  3. 빈 의존관계 주입
  4. 초기화 콜백
  5. 사용
  6. 소멸전 콜백
  7. 종료
  
### 스프링 컨테이너 생성

![img](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/1b3a0812-d5ca-4528-8c70-ed74cf877c3c)

- `new AnnotationConfigApplicationContext(설정정보.class)`를 통해 스프링 컨테이너에 스프링 빈 등록

### 스프링 빈 등록

![img](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/5b51c567-aefc-451e-93dd-d2a5ff2320d0)

- `@Bean`이 붙은 메소드에 반환되는 객체를 스프링 빈으로 등록
- 메서드이름을 빈 이름으로 등록
- 같은 이름의 빈은 등록할 경우, 예외 발생

### 스프링 빈 의존 관계 등록

![img](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/a76feb8f-a9d3-4d30-97a1-e321eaa78c43)
![img](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/55a45f8d-2c02-4ac0-9c0b-f17f435710c5)

- 스프링 컨테이너는 등록된 설정 정보를 통해 의존관계 주입

# 싱글톤 컨테이너

![img](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/a149c349-e974-4844-a586-141b1cb7c84e)

- 순수 자바 DI 컨테이너는 클라이언트가 서비스 요청을 할 때마다 계속 객체 생성
    - 심한 메모리 낭비
  
<hr/>

- 해결책
  ![img](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/0f487333-59d9-49a1-aced-021788f22eee)
- 객체가 하나만 생성하여 공유하도록 설계하는 `싱글톤 패턴`사용
- 스프링 컨테이너는 싱글톤 패턴의 단점을 보완한 싱글톤 컨테이너를 채택

> :exclamation: 싱글톤 패턴의 단점<br/>
> - 싱글톤 패턴을 구현하기 위한 많은 코드가 필요하기 때문에 비용이 늘어남
> - 인스턴스를 미리 지정하기 때문에 구체 클래스에 의존함
>   - DIP, OCP 위반
>   - 테스트하기 어려움
> - private 생성자로 인해 자식 클래스 확장 어려움
> - 유연성이 떨어짐

## 싱글톤 방식의 주의점

- 싱글톤 패턴 : 하나의 인스턴스를 생성하여 여러 클라이언트에서 공유하는 방식
- 클라이언트의 상태를 유지하는 `stateful`한 객체일 경우 문제 발생
- 싱글톤 컨테이너는 `stateless`해야함
  - 특정 클라이언트에 의존적인 필드 X
  - 특정 클라이언트가 값을 변경 X
  - Read Only
  - JAVA에서 공유되지 않는 지역변수, 파라미터, ThreadLocal 등을 통해 특정 클라이언트의 값 유지

## @Configuration와 바이트 조작 라이브러리

![img](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/99e579c3-1fd9-4268-b701-96e7a1a58b57)
![img](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/1cf91b64-f285-48da-9480-db31a4fb90a7)

- 스프링 컨테이너의 빈을 싱글톤으로 조작하기 위해서 바이트로 조작한 라이브러리 사용
- `@Configuration` 어노테이션을 붙인 클래스는 `CGLIB`라는 바이트 조작 라이브러리를 통해 임의의 다른 클래스를 생성하여 조작한 클래스를 스프링 빈 등록 
- 스프링 컨테이너에 등록된 스프링 빈인지 확인하고 없으면 동적으로 빈을 등록하는 방식
- @Configuration을 뺄 경우 싱글톤 패턴 보장X

# 컴포넌트 스캔


- 수많은 빈을 @Bean을 통해 의존관계를 수동으로 등록하기 어려움
- `@ComponentScan`을 통해 자동으로 빈 등록하고 `@Autowired`를 통해 의존관계 주입

## @ComponentScan

![img](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/89ab9164-2bbd-4467-a2ac-fcba99743cd5)

- 자동으로 `@Component` 어노테이션이 붙은 객체를 스프링 빈으로 등록
- 탐색 위치
    - @ComponentScan 어노테이션이 붙은 클래스부터 하위클래스
      - `@SpingBootApplication`은 @ComponentScan을 포함한 어노테이션
      - `설정 정보 클래스를 시작루트에 두는 것을 권장`
    - `basePackages` 속성을 통한 탐색위치 지정 
      - @ComponentScan(basePackages=" ")

> :exclamation: 중복 이름 빈 처리<br/>
> 1. 자동 등록 vs 자동 등록<br/>
> 컴포넌트 스캔으로 인해 자동 스프링 빈 등록<br/>
> `ConflictingBeanDefinitionException`예외 발생
<br/>
> 2. 자동 등록 vs 수동 등록<br/>
> @Bean(name=" ")으로 직접 빈이름을 지정한 것을 수동 등록이라 함<br/>
> 수동 등록 빈이 우선권을 가져 자동 빈을 오버라이딩<br/>
> 애매한 버그를 피하는 것이 좋기 때문에 최근 스프링 부트는 오류를 발생시킴

# 다양한 의존관계 주입 방법

## @Autowired

![img](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/51ebd694-1286-4648-aaee-85a14b5c288b)

- 스프링 빈에 등록된 객체 중 타입에 맞는 객체를 찾아 의존관계 주입

### 생성자 주입

`권장`

```java
@Component
public class OrderServiceImpl implements OrderService{
    
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

}
```

- 생성자를 통해 자동으로 의존 관계 주입
- 생성자 호출시점에 딱 1번 주입
- 생성자가 하나일 경우 @Autowired 생략가능
- 생성자 주입시 컴파일 시점에 파라미터를 통해 필요한 의존관계를 알 수 있음
- **불편, 필수** 의존 관계에 사용

> :exclamation: final 키워드 <br/>
> 생성자 호출 시점에 의존관계 주입<br/>
> 주입되지 않았을 경우, 컴파일 오류<br/>
> 필드 초기화를 강제하여 컴파일에 주입 상태를 확인 가능

### Setter 주입

```java
@Component
public class OrderServiceImpl implements OrderService {

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
```

- setter를 통해 필드값을 수정할 수 있는데 이를 통해 의존관계를 주입
- **선택, 변경** 가능성이 있는 의존 관계에 사용
- @Autowired를 부여하지 않을 경우 NULL

### 필드 주입

```java
@Component
public class OrderServiceImpl implements OrderService{
	
    @Autowired private MemberRepository memberRepository;
    @Autowired private DiscountPolicy discountPolicy;
	
}
```

- 필드값에 직접 의존관계 주입
- DI가 고정되어 있기 때문에 외부에서 변경이나 테스트하기 어렵다는 단점

## 자동 주입 대상이 없을 경우 옵션 처리

- 자동 주입은 스프링 빈일 경우에만 발생 -> 없으면 예외 발생
- 이를 해결하기 위한 방법이 옵션처리

```java
// 1
@Autowired(required = false)
public void setNoBean1(Member noBean1){
    System.out.println("noBean1 = " + noBean1);
}

// 2
@Autowired
public void setNoBean2(@Nullable Member noBean2){
    System.out.println("noBean2 = " + noBean2);
}

// 3
@Autowired
public void setNoBean3(Optional<Member> noBean3){
    System.out.println("noBean3 = " + noBean3);
}
```

1. `@Autowired(required = false)`
   - 스프링 빈이 없을 경우 **해당 메소드 실행X**
2. `@Nullable`
   - 스프링 빈이 없을 경우 **null 반환**
3. `Optional<>`
   - 스프링 빈이 없을 경우 **Optional.empty 반환**

## 조회 대상이 많을 경우 처리

- 주입 대상에 해당하는 스프링 빈이 많을 경우 오류 발생

```java
// 1
public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = rateDiscountPolicy;
}

// 2
@Qualifier("rateDiscountPolicy")
class RateDiscountPolicy{}


public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("rateDiscountPolicy")DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
}


// 3
@Primary
class RateDiscountPolicy{}

public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
    this.memberRepository = memberRepository;
    this.discountPolicy = discountPolicy;
}
```
1. `@Autowired` 필드명을 주입받고자하는 스프링 이름으로 변경
    - 순서: 빈 타입 매칭 -> 빈 이름 매칭
2. 클래스에 `@Qualifier` 별도 지정 -> 파라미터에 주입 받을 스프링 빈 `@Qualifier` 지정 -> 빈 이름 매칭
    - 추가적인 구별 방법, 빈이름 변경X
    - 순서 : @Qualifier로 지정한 빈 -> 빈 이름 매칭 -> 없을 경우 `NoSuchBeanDefinitionException` 발생
3. `@Primary`설정 스프링빈 주입

> :exclamation: 우선 순위는 @Qualifier가 @Primary보다 높음

# 빈 생명주기 콜백 시작

- 빈 생명주기
  - `스프링 컨테이너 생성 -> 스프링 빈 등록 -> 의존 관계 주입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료`
- 빈 생명주기 콜백 지원 방법
  - 인터페이스(`InitializingBean`, `DisposableBean`)
  - @Bean 속성에 초기화, 종료 메소드 지정
  - 메소드에 `@PostConstruct`, `@PreDestory` 어노테이션 지정

## 인터페이스(InitializingBean, DisposableBean)

```java
public class NetworkClient implements InitializingBean, DisposableBean {

	...
	
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }
}
```

- 인터페이스를 implements하여 메소드 오버라이드하여 사용
- 스프링 전용 인터페이스
  - 외부 라이브러리에서 적용 불가
  - 메소드명 변경 불가

## @Bean 속성에 초기화, 종료 메소드 지정

```java
public class NetworkClient {
	
	...

    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }


    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }
}

// 설정 정보 클래스
@Configuration
static class LifeCyclceConfig{

    @Bean(initMethod = "init", destroyMethod = "close")
    public NetworkClient networkClient(){
        NetworkClient networkClient  = new NetworkClient();
        networkClient.setUrl("http://hello-spring.dev");
        return networkClient;
    }
}
```

- `@Bean(initMethod = " ", destroyMethod = " ")`
- 메소드명 수정 가능
- 스프링 코드 의존 X
- 외부 라이브러리에서도 사용 가능
- `destroyMethod = "(inferred)`
  - 대부분의 메소드는 close, shutdown 같은 메소드를 통해 종료메소드를 실행
  - 이를 기본값으로 추론하여 만약 사용자의 종료메소드가 둘중에 하나라면 지정해 주지 않아도 됨
  - 추론기능을 끄고 싶으면 `destroyMethod = ""`로 설정

## 어노테이션 @PostConstruct, @PreDestory

`권장`

```java
public class NetworkClient {

    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
```

- `@PostConstruct` : 스프링 빈등록시 초기화 메서드로 수행
- `@PreDestroy` : 소멸 메서드로 지정
- JSR-250 자바 표준
  - 스프링이 아닌 다른 컨테이너에서도 동작
- 외부 라이브러리에 적용X -> 이때는 @Bean사용

# 빈 스코프

- 스프링 빈이 존재할 수 있는 범위
- **싱글톤** : default, 스프링 컨테이너 생성에서 종료까지 유지되는 가장 넓은 범위
- **프로토타입** : 스프링 컨테이너가 빈의 생성과 의존관계 주입까지 책임, 종료는 클라이언트 몫
- **웹관련**
  - **request** : 웹 요청이 들어오고 나갈때 까지 유지
  - **session** : 웹 세션이 생성되고 종료까지 유지
  - **application** : 웹 서블릿 컨텍스트와 같은 범위
- `@Scope("스코프범위")`로 빈 스코프 지정

## 프로토타입

- 호출할 때마다 객체 생성
- 싱글톤 빈과 함께 사용하면 의도대로(호출마다 생성) 작동하지 않음
![img](https://github.com/cotes2020/jekyll-theme-chirpy/assets/133394749/88785dd6-0205-48f4-be25-0c95c36b0b55)
- Why?
  - 싱글톤 안에 있는 프로토타입 빈은 스프링 컨테이너 생성시 싱글톤 생성 후 의존관계 주입시 만들어진 것
- 해결책 : 지연 처리 가능
    - `Provider<>`
    - `ObjectProvider`

> :exclamation: 프로토타입 사용 의도

### ObjectFactory, ObjectProvider

```java
static class ClientBean{
    @Autowired
    private ObjectProvider<PrototypeBean> prototypeBeanProvider;

    public int logic() {
        PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
        prototypeBean.addCount();
        int count = prototypeBean.getCount();
        return count;
    }
}
```

- 지정한 빈을 컨테이너 내부에서 찾아주는 DL(Dependency Lookup)
- 스프링에 의존 O
- 별도의 라이브러리 필요X
- `getObject(찾고자하는 빈.class)`를 통해 프로토타입 빈을 얻을 수 있음

### Provider

```java
static class ClientBean {

    @Autowired
    private Provider<PrototypeBean> prototypeBeanProvider;

    public int logic() {
        PrototypeBean prototypeBean = prototypeBeanProvider.get();
        prototypeBean.addCount();
        int count = prototypeBean.getCount();
        return count;
    }
}
```

- 지정한 빈을 컨테이너 내부에서 찾아주는 DL(Definition Lookup)
- 스프링에 의존 X
- javax.inject.Provider 패키지의 JSR-330 자바 표준
  - 외부 컨테이너에서도 사용 가능
- 별도의 라이브러리 필요 O
- `get(찾고자하는 빈.class)`를 통해 프로토타입 빈을 얻을 수 있음
