### 개요

이상민님의 서적 '자바의신 2판'을 읽고 정리한 레포지토리입니다.

---

### 서평

백엔드 개발을 하며 가장 많이 사용하는 언어인 Java 기본서입니다. 기초부터 탄탄하게 잡아주며, 핵심을 쉽게 요약해서 전달해주는 부분이 좋았습니다. 책에 대한 설명이 너무 길 필요는 없고, 자바 기본서를 고민하신다면 남궁성님의 '자바의 정석'을 읽으시기 전에 이 책을 먼저 읽으시는 것도 좋습니다.

---

### Q&A: 객체와 클래스

- ***Q. 클래스와 객체의 차이점은 무엇일까요?***

  객체는 프로그래밍 기능의 분해 시 책임을 분배하기 위한 개념적인 요소라고 생각합니다. **클래스는 이러한 객체를 표현하기 위한 객체지향 언어의 도구**입니다. 
  
  - ***Q. 객체의 책임이란 무엇인가요?***
  
    책임이란 자신이 담당하는 프로그램의 기능입니다. 그런 의미에서 객체지향 패러다임이란 만들어야 하는 요구사항들을 객체들에게 적절하게 나누는 과정을 통해 프로그램을 설계하는 것이라고 생각합니다

- ***Q. 메서드와 메시지는 무엇이 다를까요?***

  메서드는 객체가 메시지를 수신했을 때 **자신의 책임을 수행하기 위해 선택하는 방법**입니다. 따라서 메서드는 실제 책임을 수행하기 위한 구현 방법, 코드를 의미합니다. 반면 **메시지는 객체가 소통하는 방법**을 의미합니다.
  
- ***Q. 캡슐화가 필요한 이유가 무엇일까요?***

  객체들이 서로의 세부 구현을 모르도록 만들어 **협력의 유연함을 증가시키고, 이를 통해 변경의 파급효과를 적절하게 통제**하기 위해서입니다. 객체는 퍼블릭 인터페이스를 통해 서로 커뮤니케이션합니다. 만약 캡슐화가 되어있지 않아 세부 구현에 대해 마음대로 접근할 수 있다면 객체 사이의 결합도가 늘어나게 됩니다.

  예를 들어 더하기라는 기능을 구현한다고 가정하겠습니다. 더하기에는 좌변에 수를 놓기, 우변에 수를 놓기, 더하기라는 세 개의 동작이 필요합니다. 만약 요청 객체가 좌변에 수를 놓기를 직접 가져다 쓴다면 나중에 좌변에 수를 놓는 동작이 변경되었을 때 그 객체도 변경되어야 합니다. 이것은 변경의 파급효과를 제어하지 못하는 것을 의미합니다. 따라서 캡슐화를 통해 변경이 적고 세부 구현을 감추는 퍼블릭 인터페이스만 노출시키는 것은 협력의 유연함을 늘리고 객체 간의 결합도를 줄일 수 있는 장점을 가질 수 있습니다.
  
- ***Q. Polymorphism, 다형성이란 무엇일까요?***
  
  **동일한 메시지를 수신하더라도 객체의 타입에 따라 다르게 응답할 수 있는 성질**을 말합니다. 인터페이스와 다형성을 통해서 객체지향에서는 컴파일 타임의 의존성을 제어할 수 있습니다.
  
  - ***Q. 어떻게 인터페이스와 다형성을 통해 제어하는지 설명해주세요.***
  
    컴파일 시점에서는 부모 클래스의 메서드인지, 자식 클래스의 메서드인지 구별하지 않고 동일한 메서드를 호출하지만 런타임에서 어떤 객체가 할당되어있는지에 따라 실행 결과가 달라집니다. 이를 통해 컴파일 타임의 의존성을 런타임으로 미룰 수 있습니다. **이 개념과 DI를 적절히 활용해 정책과 구현체의 의존성 방향 모두 인터페이스를 향하게 하도록 제어**할 수 있습니다.
    
- ***Q. 메서드 오버로딩이란 무엇일까요? 메서드 오버라이딩이란 무엇인가요? 그리고 둘은 무엇이 다른가요?***

  메서드 오버로딩이란 인자의 타입이나 수를 변경하여도 동일한 메서드 시그니처를 가지는 것을 허용해주는 기술입니다. 이를 통해 유사한 작업을 수행하는 메서드의 이름을 손쉽게 압축할 수 있습니다. 예를 들어 plus() 메서드를 구현할 때 단순한 숫자일수도, 돈일수도 있는데 이런 경우 사용이 가능합니다. 메서드 오버로딩은 컴파일 타임 시점에서 호출될 메서드의 종류를 선택하는 **정적 메서드 디스패칭**을 사용합니다.
  
  메서드 오버라이딩이란 부모 클래스로부터 상속받은 메서드와 동일한 시그니처의 메서드를 재정의해서 새로운 구현으로 부모 클래스의 구현을 대체하는 것을 말합니다. 이를 위해 필요한 것은 부모 클래스 타입 변수에 자식 클래스 인스턴스를 할당하는 업캐스팅과 **런타임 시점에 실행할 메서드를 탐색하는 다이나믹 메서드 디스패칭**입니다. 다이나믹 메서드 디스패칭이 수행될 때 중요한 것은 self 참조라는 임시변수입니다. 컴파일러는 self 참조라는 임시변수를 자동으로 생성하고 메시지를 수신한 객체를 가리킵니다. 여기서 부모 클래스 방향으로 올라가며 일치하는 메시지가 존재하는지를 확인합니다. 여기서 메서드 탐색은 메서드를 찾지 못한다면 자동적으로 부모 클래스에게 메서드에 대한 책임을 위임합니다.

- ***Q. 추상 클래스와 인터페이스에 대해 설명해주세요***

  추상 클래스는 상속 관계를 갖는 클래스들 사이에서 세부 구현을 공유해야할 필요가 있을 때, 즉 코드 재사용을 위해 사용됩니다. 인터페이스는 클래스들 사이에서 객체들의 책임만 정의하고 싶을 때 사용됩니다. 인터페이스는 주로 다형성을 통해 컴파일 타임 의존성을 끊어내기 위해 주로 사용됩니다.
        
---

### Q&A: 자료형

- ***Q. 기본 자료형과 참조 자료형이 메모리 상에서 저장되는 위치는 어디일까요?***

  두 데이터 모두 JVM 내부의 Runtime data area에 저장됩니다. 그 중 기본 자료형은 각 쓰레드의 고유한 스택 공간에 스택 프레임 형태로 저장됩니다. 참조 자료형은 Heap 영역에 저장됩니다. 만약 String 클래스라면 Heap 영역 중 String Constant Pool에 저장됩니다.
  
  - ***Q. 스택 프레임은 어떤 구조로 이루어져 있나요?***
  
    스택 프레임은 메서드의 지역 변수를 저장하는 **Local Variable Section**, 연산에 이용되는 데이터 및 결과를 저장하는 **Operand Stack**, **Frame Data**로 이루어져 있습니다. 최상단 스택 프레임을 current frame이라고 부릅니다. Local Variable Section는 0-Base 배열로 구성되어있고 로컬 변수와 메서드 파라미터가 저장됩니다. Operand Stack에는 연산에 사용되는 값들이 저장됩니다. Frame Data에는 다른 클래스를 참조하거나 메서드를 수행할 때 Constant Pool Resolution, Normal Method Return, Exception Dispatch가 있습니다.
    
- ***Q. 자바에서 0.1+0.2는 0.30...4가 나옵니다. 즉 컴퓨터는 소숫점 계산을 제대로 하지 못합니다. 그 이유가 무엇일까요?***

  double, long, float 계산 시 부동 소수점을 표현하기 위한 **IEEE 754를 사용**하기 때문입니다.
  
  - ***Q. 그렇다면 왜 IEEE 754 기술을 사용할까요?***
  
    소수점을 표현하는 방식에는 고정 소수점과 부동 소수점 방식이 존재합니다. 고정 소수점은 정수부와 소수부의 크기를 제한합니다. 즉 비트를 효율적으로 사용하지 못하는 것이죠. 따라서 과학적 표기법을 통해 유효한 숫자만 표시할 수 있도록 하기 위해 부동 소수점 방식을 사용합니다. 그리고 이렇게 소수점을 소수부의 가장 첫번째 자리까지 당겨오는 것을 정규화라고 합니다.
    
    하지만 부동 소수점은 가수의 자리수를 32비트에서는 23자리, 64비트에서는 52자리로 제한하기 때문에 표현하고자 하는 소수부의 **이진법 표기가 무한소수로 표기되는 경우 결국 일부분을 잘라낼 수 밖에 없게** 됩니다. 이 때문에 값의 오차가 발생합니다.
    
    - ***Q. 32비트에서 64비트로 올라가면 정밀도가 향상된다구요? 그럼 정밀도란 무엇일까요?***
    
      숫자의 오차가 얼마나 적은지 입니다. 위에서 말했듯 비트 크기의 한계 때문에 결국 일부분이 끊기는데, 비트 크기가 크다면 최대한 잘리는 비트의 수가 적어질 것이고 실제값에 더 가까워질 수 있습니다.
      
      - ***Q. 자바에서 BigDecimal은 어떻게 이런 문제를 해결할까요?***

        BigDecimal은 정수를 저장하는 `BigInt` 타입의 `intValue` 필드, 지수를 나타내는 `scale`, 정밀도를 나타내는 `precision` 세 개의 필드를 사용해 소수를 표시합니다. 예를 들어 표시하고자 하는 숫자가 123.45라면 { `intValue`: 12345, `scale`: 2, `precision`: 5 } 의 값을 가지게 됩니다.
        
- ***Q. pass by value, pass by reference에 대해서 설명해주세요***
  
  메서드의 매개변수가 전달될 때 인자의 자료형에 따라 ‘값' 혹은 ‘주소’가 전달되는 것을 말합니다. 인자가 **primitive 타입인 경우는 복사된 값**만 전달되어, 즉 원본에 영향을 끼칠 수 없습니다. 이는 메서드 호출 시 매개변수가 스택 프레임에 어떻게 쌓이는지에 대한 이해가 필요합니다. 메서드 호출 시 스택 프레임에는 Return Address가 쌓이고, 매개변수로 전달된 값 혹은 객체 역시 새롭게 쌓입니다. 이 때 인자는 매개변수로 전달된 원본에서 값만 복사한 것입니다. 즉 원본이랑은 전혀 관련이 없기 때문에, 원본에 대한 접근 자체가 불가능합니다.
  
  반면 참조형 객체는 **값이 아닌 '참조 주소 복사본(a copy of the object address)'** 이 전달됩니다. 즉 전달된 인자가 원본과 같은 곳을 보고 있다는 것이죠. 따라서 전달된 복사본의 필드에 접근, 수정이 가능합니다. 이러한 참조 주소의 복사본, 'Object Reference'를 통해서는 { 필드 접근, 메서드 호출, 현변환 연산자, String + 연산자 , instanceof, ==, =!, ?: } 연산만 가능합니다. 인수로 전달된 복사본은 원본 자체가 아닌 단순히 메모리 주소값입니다. 따라서 메서드 내부에서 재할당을 시도하더라도, 원본 주소의 복사본일 뿐이므로 메서드 스코프가 종료되면 복사본이 손실되고 원본 반영은 일어나지 않습니다.
  
 ---
 
 ### Q&A: 형 변환
 
 - ***Q. auto boxing, unboxing 이란 무엇인가요?***
 
	Wrapper 클래스와 primitive 타입 사이에서 메서드의 파라미터를 통과할 때와 변수로 할당될 때 서로간 캐스팅을 해주는 것을 말합니다. 주로 기본 타입을 담을 수 없는 컬렉션에서 많이 사용됩니다.
    
  	- ***Q. Wrapper Class란 무엇인가요?***

		**객체 형태가 되도록 한번 감싼 형태의 클래스**를 말합니다. JDK가 제공하는 래퍼 클래스들은 인스턴스 풀링을 제공합니다. 따라서 각 래퍼 클래스들은 캐시 형태로 자주, 일반적으로 사용되는 인스턴스들의 목록을 저장해놓고 필요할 때마다 사용하는 방식을 취합니다.
      
    	예를 들어 Integer class에서는 IntegerCache라는 정적 내부 클래스를 갖고 있습니다. 이 클래스는 처음 사용될 때만 초기화됩니다. 비록 캐시를 생성하는 것때문에 처음에는 시간이 조금 걸리지만, 후에는 **메모리를 재사용**한다는 장점을 갖고 있습니다. 하지만 new 연산자를 사용하는 경우 적용되지 않습니다. 이 경우는 리소스 풀이 아닌 힙 영역에 생성되며, Integer.valueOf() 혹은 기본값 타입을 할당하는 경우만 캐싱이 적용됩니다.
      
    	즉 내부 캐시를 사용하기 위해선 항상 기본 할당을 사용하여 변수를 참조하거나 `valueOf()` 메서드를 사용해야 합니다. 캐싱의 기본값은 -128~127이며 이 사이의 값이 들어온 경우 미리 생성되어 캐싱된 인스턴스를 반환합니다. 만약 런타임에 사용하는 값들이 디폴트 설정보다 크다면 runtime args 설정이나 JVM 옵션을 통해 조정이 가능합니다.
      
    	- ***Q. 인스턴스 풀링이 무엇인가요?***

      		자바에서는 대부분 new 생성자를 통해서 클래스 인스턴스를 초기화합니다. 이 인스턴스들은 heap 영역에 생성되며 대부분 무거운 작업으로 간주됩니다. 따라서 대부분의 프레임워크에서는 이를 해결하기 위해 리소스 풀링이라는 방법을 사용합니다. Persistence framework에서는 커넥션 풀을, 자바에서는 String Pool 개념을 사용합니다. 우린 이 목적을 위해 프로토타입 패턴을 사용합니다. 미리 만들어진 객체를 사용하는 것은 굉장히 큰 도움이 됩니다.
       
- ***Q. 업캐스팅과 다운캐스팅***

  	자식(하위) 클래스에서 부모(상위) 클래스로 캐스팅되는 것을 업캐스팅, 반대를 다운캐스팅이라고 합니다. 이를 사용하는 이유는 객체지향의 다형성 메커니즘과 연관되어 있습니다. 다형성이란 간단하게는 추상 인터페이스에 대해 서로 다른 구현을 연결할 수 있는 성질인데요. 업캐스팅을 통해 자식 클래스가 부모 클래스의 메서드를 사용할 수 있습니다.

---

### Q&A: Object Class

- ***Q. Object가 지원하는 hashcode(, equals() 메서드에 대해서 설명해주세요.***

	`equals()` 메서드는 객체의 동등성을 체크하기 위한 메서드입니다. 하지만 컴퓨터는 우리가 인지하는 **‘같다'라는 개념을 기본적으로 인스턴스의 메모리 주소값을 통해 비교**합니다. 이 때 인스턴스의 메모리 주소값을 16진수로 표현한 int 타입으로 리턴하는 메서드가 `hashcode()`입니다.
	
	- ***Q. 왜 필요할까요?***

		예를 들어 대한민국 국민이라는 객체를 표현한다고 가정해보겠습니다. 이 때 주민등록번호가 같다면 우린 같다고 인지합니다. 하지만 동일한 주민등록번호를 가진 인스턴스가 n개가 올라갔을 때 해당 인스턴스들은 **모두 다른 메모리 주소를 가질 것**입니다. 그렇다면 컴퓨터는 우리가 관념적으로는 같다고 인지함에도 불구하고 다르다는 결과를 뱉을 것입니다. 따라서 같다라는 개념을 정의하는 것은 굉장히 중요합니다.
		- ***Q. 만약 컴퓨터에게 '같다'라는 개념을 제대로 인식시키지 못한다면 어떤 문제가 발생할까요?***

			만약 같다라는 개념을 제대로 정의하지 못한다면 Map 자료구조의 자료 입출력 혹은 데이터베이스에서 자료를 조회할 때 혹은 메모리 캐시를 제대로 사용할 수 없습니다. 이런 문제점들은 Hibernate에서는 `@Entity`의 `@Id`를 통해서, Java 14부터는 `record` 키워드를 통해 혹은 직접 구현해 해결할 수 있습니다.
			
---

### Q&A: Enum Class

- ***Q. Enum 클래스가 무엇인가요?***

	클래스의 모양을 띤 상수입니다. JDK 1.5부터 추가됐습니다. 이전에는 public static final 형태 혹은 인터페이스의 변수로 많이 지정이 되었었습니다. 현재 근무하는 곳에서도 이런 형태를 띄고 있어 Enum 클래스로 마이그레이션하는 작업을 진행하는 경우가 많습니다. 
	
	- ***Q. 혹시 상속이 가능할까요?***

		enum클래스는 내부적으로 Enum<T>를 상속받습니다. 따라서 **다른 클래스를 extend 할 수 없습니다**. 이펙티브 자바에서는 이런 enum의 기능을 계승해서 사용하고 싶다면 interface를 생성 + 구현하여 사용하는 방식을 권장합니다. Java 17에서는 이런 문제를 `sealed class, interface`를 통해 해결할 수 있습니다.

	
---
	
### Q&A: final keyword
	
- ***Q. 자바에서 final 키워드는 어떤 역할을 하나요?***

	데이터를 재할당하는 것을 막아주는 키워드입니다. 기본형의 경우 해당 키워드를 통해 불변 객체가 될 수 있지만 참조형 객체의 경우 그렇지 않습니다. 만약 참조형 객체를 불변 클래스로 만들고 싶다면 아래와 같은 방법을 따르면 됩니다. 클래스, 내부 인스턴스 필드를 모두 final로 선언해줍니다. 생성자는 private으로 유지하고 정적 팩토리 메서드를 제공합니다. 만약 컬렉션 프레임워크의 List처럼 메모리 참조값이 유출되는 변수가 있다면 `Collections.unmodifiableList()` 메서드와 같은 방어적 복사를 사용해서 전달하면 됩니다.
	
	- ***Q. 단순히 값을 재할당하지 못하게 하는 것은 어떤 장점이 있을까요? 왜 필요한 걸까요?***
	
		값의 변경으로 인한 사이드 이펙트를 원천 차단할 수 있습니다. 좀더 자세히는 멀티쓰레드 환경에서 공유 자원에 대한 걱정을 없앨 수 있습니다. 또한 보안 관점에서도 유용합니다. 시스템 내부에서 값의 변경될 걱정없이 민감한 정보를 읽기 전용으로 만들 수 있습니다. String 클래스가 이에 해당됩니다. 또한 단일 인스턴스를 지정하여 중복 항목을 공유할 수도 있습니다. 자바에서는 java 14부터 record 키워드를 통해 불변 객체를 지원합니다.
	
- ***Q. Java에서는 `String` 클래스가 불변 클래스라고 알고 있는데요. 왜 final 일까요? 어떤 장점이 있는 걸까요?***
	
	***1. String pool***
	
	자바 개발자들은 자바를 디자인할 때부터 String 클래스 프로그램에서 굉장히 많이 쓰여질 것이라고 예측했습니다. 따라서 설계 단계부터 최적화를 시키고자 노력했습니다. 그리고 최적화의 핵심으로 떠오른 방법이 바로 String Constant Pool이었습니다. 이를 통해 String 객체를 생성하여 공유하여 매번 객체가 생성되고 소멸되는 자원을 줄였습니다. 하지만 우리가 도서관에서 책을 대여해서 보고있는데 누군가가 책을 찢어간 경우 역시 심심찮게 있을 겁니다. 즉 공유는 자원을 효율적으로 사용한다는 장점과 변경에 예민하다는 단점을 동시에 갖습니다.
	
	따라서 String은 이런 책의 훼손같은 단점을 극복하기 위해 책이 변하지 않도록 코팅해버린 것입니다. String Literal은 매번 인스턴스가 생성되지 않고 한번 생성된 후 상수 풀에 저장되어 참조됩니다. 만약 String이 변경 가능하다면 어떤 일이 벌어질까요? 
	
	```java
	String a = "Test";
	String b = "Test";
	b = b.toUppderCase();
	```
	
	이렇게 데이터를 변경된다면 어떤 일이 일어날까요? a뿐만 아니라 동일한 애플리케이션 내에 Test를 참조하는 모든 변수가 TEST로 변경됩니다. 이는 프로그램 내에서 치명적인 오류를 발생시킬 것이 틀림없습니다. String 클래스가 불변인 것과 상수 풀을 사용하는 것은 이렇듯 상호 보완적인 관계에 있습니다. 불변이지 않으면 상수 풀을 사용할 수 없고, 상수 풀을 사용하더라도 불변이지 않으면 문제가 발생하죠.
	
	***2. Security***
	
	String이 불변 객체인 이유 중 핵심은 바로 **보안**입니다. 자바는 모든 서비스 수준에서 안전한 환경을 제공하겠다는 분명한 목표를 갖습니다. 이 목표를 지키기 위한 보안 영역에서 String 클래스는 굉장히 중요한 역할을 합니다. 많은 자바 클래스 내에서 String 타입의 파라미터가 사용됩니다. 네트워크 커넥션을 맺을 때 호스트 이름이나 포트 번호 등과 같은 정보, 데이터베이스 커넥션을 맺을 때 데이터베이스 URL, 호스트, 비밀번호 정보도 String 인자로 넘깁니다. File I/O에서 디렉토리의 패스와 파일명 역시 String 인자로 넘깁니다. 만약 String이 불변 객체가 아니라면 위 케이스들에서 치명적인 보안 문제가 발생합니다.
	
	예를 들어 사용자가 시스템의 특정 파일에 접근할 수 있는 권한을 받았다고 가정하겠습니다. 이 때 String이 변경 가능하다면 권한을 가진 채로 경로를 변경해 접근해버릴지도 모릅니다. 이는 중대한 보안 문제를 일으킵니다. 네트워크, 데이터베이스와 같은 시스템 연결에서도 문자열 값의 변경은 이러한 보안 위협을 발생시킵니다. 변경 가능한 String 클래스는 String 타입의 매개인자를 사용하는 Reflection에서도 보안의 영향을 끼칠 수 있습니다.
	
	***3. Use of String in Class Loading Mechanism***
	
	String 클래스는 클래스 로딩 메커니즘 안에서도 많이 사용됩니다. 만약 String이 변경 가능하다면 클래스 로딩 시점에 악의적으로 로드되는 클래스명을 변경할 수 있습니다. 예를 들면 `java.io.Reader를` `com.unknown.DataStolenReader`처럼 말이죠. String 클래스를 불변으로 만드는 것을 통해 우린 JVM이 올바른 클래스를 로드하는지에 대해 걱정하지 않아도 됩니다.
	
	***4. Multithreading Benefits***
	
	자바에서 동시성 및 멀티스레딩은 핵심 중에 핵심입니다. 따라서 String 객체를 멀티스레딩 환경에서 어떻게 보호할 수 있는지 꼭 필요한 연구과제였습니다. String 클래스는 앞서 말했듯 설계 단계부터 사용빈도가 아주 높을 것으로 예상되었습니다. 따라서 차라리 애초에 불변으로 만들어 동기화에 대한 이슈를 걱정하지 않고 사용하도록 만들었습니다. 불변이라는 간단한 특징 하나로 자연스럽게 읽기만 가능하다는 특징을 가지기 때문에 복잡하고 오류가 발생하기 쉬운 동시성 코드들이 훨씬 쉬워집니다.
	
	***5. Optimization and Performance(Caching)***
	
	String 클래스는 불변임을 보장하기 때문에 hashcode() 메서드가 호출될 경우 해당 값을 캐싱해놓았다가 반환합니다. 이는 String이 Hashtable, HashMap과 같은 해시 기반 컬렉션에서 키로 사용될 때 성능의 향상을 가능케 합니다. HashMap의 키가 무조건 불변해야한다는 제약사항은 없지만 키가 변경 가능한 객체인 것보다 훨씬 안전하게 사용할 수 있습니다. 해시 기반 컬렉션 내부에 저장될 때 상태가 변경될 위험 역시 없습니다.
	
	- ***Q. 단점은 없나요?***
	
		String 클래스는 객체의 상태가 다를 때마다 매번 인스턴스를 생성합니다. 따라서 임시로 사용되는 인스턴스들이 너무 많습니다. 즉 GC의 대상이 너무 많아집니다. 이 점은 자바 설계 당시 예측됐던 문제기 때문에 상수 풀에 문자열 리터럴을 저장해 사용하는 것을 통해 개선이 가능합니다. 하지만 문자열 리터럴로 String 인스턴스를 생성하지 않고 new 연산자를 사용하는 방식은 주의를 기울일 필요가 없습니다.
	
		JDK 7 이전에는 문자열이 저장되는 SCP가 Java Heap 내부의 PermGen Space에 위치했었습니다. 해당 영역은 Java Heap에 비해서 제한되어 있어 많은 수의 문자열 리터럴이 생산되는 경우 공간이 부족해 `java.lang.OutOfMemoryError`가 발생하는 리스크가 존재했었습니다. 다행히 JDK 7부터는 이 점을 고려해 기존 PermGen에 비해 훨씬 큰 일반 Heap 영역으로 SCP의 위치를 옮겼습니다. 
	
		String은 확장이 제한된다는 단점도 존재합니다. final 클래스는 확장이 불가능하니까요. 하지만 큰 단점으로 보이진 않습니다.

---

### Q&A: String class

- ***Q. String 클래스는 어떤 자료형을 사용해 문자를 저장하나요?***
	
	Java 8까지의 `char`형은 UTF-16기반의 2byte를 참조했습니다. 따라서 영어를 사용하더라도 기본적으로 2byte를 사용했죠. 하지만 Java 9부터는 문자열에 따라 Latin-1(1byte)와 UTF-16(2byte)로 나누어지며, byte 배열을 사용해 저장하도록 변경됐습니다. 이 때문에 Java 9부터는 char 연산을 수행하는 클래스가 `StringLatin1` 클래스와 `StringUTF16` 클래스로 나눠지게 됐습니다. 관련 내용은 [JEP 254에 명시된 Compact String 자료](https://openjdk.org/jeps/254)를 통해 확인할 수 있습니다.
	
	계기는 JVM 내부의 힙 메모리의 대부분을 String 자료형이 사용하며 대부분 영어로 작성되어 있기 때문에 굳이 UTF-16을 사용해 1바이트를 낭비하지말자는 것입니다. Java 9부터 새롭게 생성되는 String 클래스는 문자열의 내용에 따라 ISO-8859-1/Latin-1(문자당 1바이트) 또는 UTF-16(문자당 2바이트)으로 인코딩된 문자를 저장합니다. String 클래스는 이를 저장하기 위해 `coder`와  *`COMPACT_STRINGS`* 인스턴스 변수를 통해 갖고 있습니다. 
	
	- ***Q. StringUTF16, StringLatin1은 어떻게 다른가요?***
	
		`hashcode(byte[] value)` 메서드 내부 구현이 다릅니다. `StringfUTF16` 클래스에서는 인자로 들어온 바이트 배열 길이에 우측 쉬프트 연산을 1번 취한 뒤, 해당 값만큼 배열을 순회하며 `h = 31 * h + getChar(value, idx);` 연산을 수행한 뒤 반환합니다. 반면 `StringLatin1`에서는 바이트 배열(인자)를 순회하며 `h = 31 * h + (v & 0xff);` 연산을 수행합니다. 여기서 Oxff(255)와 AND 연산을 수행하는 이유는 더해주는 값을 양수로 보장(음수는 8비트 기준 MSB가 1, 여기에 255(11111111) AND 연산을 수행하면 MSB가 0으로 변경)하기 위함입니다. 
	
	- ***Q. StringBuilder, StringBuffer에 대해서 설명해주세요.***
	
		`StringBuilder`는 불변 객체인 `String`과는 다르게 가변 객체입니다. `StringBuffer`는 동기화를 보장하는 특징이 있습니다.
	
		- ***Q. String 클래스에서 '+'연산을 하지 말라고들 하는데요. 왜 그런걸까요?***
	
			String 인스턴스는 불변 객체라는 특성 때문에 더하기 연산 시에 더하기의 연산자가 된 인스턴스들은 그대로 버려지는 문제가 발생합니다. 임시적이지만 메모리 낭비를 유발하고 추후 GC의 대상이 됩니다. `StringBuffer`와 `StringBuilder`는 이러한 단점을 보완하기 위해 나온 클래스로 String과는 다르게 변경이 가능한(mutable) 객체입니다. 두 클래스가 제공하는 메서드는 동일하며 `StringBuffer`는 멀티스레딩 환경에서 Thread Safe 하다는 특징을 갖습니다. 다만 멀티스레딩 환경을 보장하기 때문에 성능 면에서 StringBuilder가 빠릅니다.
	
			JDK 5부터 내부적으로 새로운 인스턴스가 반복적으로 생성되고 GC 됩니다. 만약 단순 리터럴 스트링만 더한다면 내부적으로 컴파일러가 새로운 인스턴스를 생성하지 않고 StringBuilder의 append() 메서드로 변환해줍니다. 즉 일반적인 상황에서는 '+' 연산을 해도 성능에 영향이 없습니다. 
	
			하지만 for 루프와 같은 반복작업에서는 StringBuilder 인스턴스로 변경해주긴 하지만, 새로운 StringBuilder 인스턴스를 생성합니다. 따라서 기존 String이 갖던 문제와 동일한 현상이 발생합니다. 따라서 반복문 안에서는 String 클래스의 + 연산을 하지 않고 StringBuilder의 append() 메서드를 사용하는 것이 좋습니다.	
