# Part 20: 가장 많이 쓰는 패키지는 자바랭

### 개요

자바에서 가장 많이 사용되는 패키지 `java.lang` 에 대해서 알아봅니다.

---

### 숫자를 처리하는 클래스들

- 자바에선 숫자를 표현하기 위해 제공하는 기본 자료형 외에 객체 타입의 클래스도 제공합니다.
    - Character, Boolean을 제외하고 숫자를 처리하는 클래스를 우린 Wrapper class라고 부르며, 모두 Number라는 추상 클래스를 extends 합니다.
        
        ```java
        /* 
        
        The abstract class Number is the superclass of platform classes representing numeric values that are
        convertible to the primitive types byte, double, float, int, long, and short. The specific semantics of 
        the conversion from the numeric value of a particular Number implementation to a given primitive type is
        defined by the Number implementation in question. For platform classes, the conversion is often
        analogous to a narrowing primitive conversion or a widening primitive conversion as defined in 
        The Java™ Language Specification for converting between primitive types. Therefore, conversions may 
        lose information about the overall magnitude of a numeric value, may lose precision, and may even return a
        result of a different sign than the input. See the documentation of a given Number implementation for conversion details.
        
        Since: 1.0
        Author: Lee Boynton, Arthur van Hoff
        jls    5.1.2 Widening Primitive Conversions
        jls    5.1.2 Widening Primitive Conversions
        */
        public abstract class Number implements java.io.Serializable { ... }
        
        ```
        
        - 참조 자료형이지만 자바 컴파일러에서 자동으로 형변환을 해주기 때문에 **기본 자료형처럼 사용**할 수 있습니다.
    - 숫자를 처리하는 참조 자료형은 왜 필요한 걸까요? 이유는 아래와 같습니다.
        - 매개 변수를 참조 자료형으로만 받는 메소드 처리
        - 제네릭과 같은 기본 자료형을 사용하지 않는 기능을 사용하기 위해
        - 클래스에 선언된 상수 값을 사용하기 위해(*ex. MIN_VALUE, MAX_VALUE)*
        - 문자열 → 숫자, 숫자 → 문자열 변환, 2,8,10,16 진수 변환을 쉽게 처리하려고
    - 돈 계산과 같은 중요한 연산에서 반드시 정수형은 BigInteger, 소수형은 BigDecimal을 사용해야 합니다.

---

### System Class

- 신기하게도 System은 생성자가 없고 err(PrintStream), in(InputStream), out(PrintStream)의 static 변수가 선언되어 있습니다. 우리가 콘솔창에 어떤 데이터를 출력할 때 주로 사용하는 `System.out.println()` 메서드는인스턴스 변수 out의 메서드 println()을 사용하는 것입니다.
    - 이 외에도 System 클래스는 아래와 같은 역할들을 수행합니다.
        - 시스템 속성(Property)값 관리
        - 시스템 환경(Environment)값 조회
        - GC 수행 → 관련 메서드는 절대 수행 X
        - JVM 종료 → 관련 메서드는 절대 수행 X
        - 현재 시간 조회
        - 기타 등등
- Properties
    - Hashtable를 상속하는 클래스로 자바 프로그램을 실행할 때 생성되는 객체들입니다. 언제든지 JVM 내에서 꺼내서 사용할 수 있습니다.
    - `System.getProperties()` 메서드를 통해 시스템에서 유지중인 프로퍼티들을 가져올 수 있습니다.
        
        ```java
        for (Map.Entry<Object, Object> entry : System.getProperties().entrySet()) {
            System.out.println("entry." + entry.getKey() + "= " + entry.getValue());
        }
        ```
        
- Environmet
    - 환경값 env는 대부분 OS, 장비와 관련된 것으로 읽는 것만 가능합니다.
- System.out
    - print(), println() 메서드의 오버로딩된 리스트를 살펴보면 byte, short 타입을 매개변수로 받는 메서드가 없습니다. 하지만 더 많은 수를 표현할 수 있는 int를 매개변수로 갖는 메서드가 존재하고 알아서 처리해주기 때문에 신경쓰지 않아도 됩니다.
    - 객체를 출력할 때는 toString()보다 valueOf()를 사용하는 것이 NPE를 발생시키지 않기 때문에 훨씬 안전합니다.