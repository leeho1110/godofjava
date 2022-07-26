# Part 19: 이쯤에서 자바의 역사와 JVM에 대해서 알아보자

### 개요

지금까지 자바의 역사와 JVM에 대해서 알아봅니다.

---

### 자바 언어의 특징

- 자바는 “단순하고, 객체지향이며, 친숙"해야 한다.
    - 자바는 객체지향으로 디자인된 언어다. 객체지향 언어의 특징을 지원할 수 있는 여러 구조들을 지원한다. 하지만 개발자가 객체지향적으로 개발하지 않으면 전혀 언어의 이점을 살릴 수 없다.
- 자바는 “견고하며, 보안상 안전"하다.
- 자바는 “아키텍처에 중립적이어야 하며 포터블"해야 한다.
    - JVM 덕분에 하드웨어와 소프트웨어 아키텍쳐에 따른 데이터 타입의 호환성에도 문제가 발생하지 않는다.
- 자바는 “높은 성능”을 제공해야 한다.
- 자바는 “인터프리트 언어이며, 쓰레드를 제공하고, 동적인 언어"이다.

---

### 자바의 버전별 차이

- JDK 1.1에서 추가된 것들 (1997.02.19)
    - AWT(Abstract Window Toolkit)의 이벤트 모델의 확장 및 변경
    - 내부 클래스(Inner Class) 추가
    - JavaBeans, JDBC(Java Database Connectivity), RMI
- JDK 1.2에서 달라진 것들과 추가된 것들 (1998.12.08)
    - JIT 컴파일러가 Sun JVM(Oracle)에 처음으로 추가
- JDK 1.3에서 추가된 것들 (2000.05.08)
    - HotSpot JVM 추가
    - JNDI(Java Naming and Directory Interface)가 코어 라이브러리에 추가
        - 객체를 쉽게 찾을 수 있도록 도와주는 이름을 지정하고, 지정한 이름으로 객체를 찾는 것
- JDK 1.4에서 추가된 것들 (2002.02.06)
    - Perl 언어의 정규 표현식을 따르는 정규 표현식(Regular expression) 추가
    - NIO(New Input/Output)라는 non-blocking 추가
    - 각종 로그를 처리하기 위한 logging API 추가
- Java 5 버전에서 추가 및 향성된 점들 (2004.09.30)
    - Java 5는 이전 변화들과 달리 매우 많은 변화가 있었다. Java 5 버전과 그 이전을 사용하는 시스템을 구분 짓는 계기가 되었다.
    - 보다 안전하게 컬렉션 데이터를 처리할 수 있는 제네릭(Generic) 추가
    - 어노테이션(annotation)이라고 불리는 메타데이터 기능 추가
    - 기본 자료형(int)과 그 기본 자료형을 객체로 다루는 클래스(Integer, Wrapper Class)간의 데이터 변환이 자동으로 발생하는 autoboxing 및 unboxing 기능 추가
    - 상수 타입을 나타내는 enum 추가
    - 매개 변수의 개수를 가변적으로 선언할 수 있는 varargs 추가
        - `public void varargsMethod(int arg1, String … args)`
    - 향상된 for 루프 추가
    - static import 추가
    - 쓰레드 처리를 쉽게 할 수 있는 concurrent 패키지(java.util.concurrent) 추가
    - 스트림, 버퍼로 들어오는 데이터 파싱을 간편하게 할 수 있는 Scanner 클래스 추가
- Java 6 버전에서 향상된 점들 (2006.12.11)
    - 목적성과 확장성을 위한 업데이트
- Java 7에서 향상된 점들 (2011.07.28)
    - 30,31장에서 자세히
- Java 8에서 추가된 점들 (2014.05.18)
    - 32,33장에서 자세히

---

### JIT 컴파일러란 무엇일까?

- Just-In-Time 컴파일러로 동적 변환을 수행하는 컴파일러입니다. JIT 컴파일러는 자바 컴파일러가 컴파일한 바이트 코드를 **JVM에서 기계어로 변환할 때 사용**됩니다.

---

### HotSpot

- HotSpot JVM은 클라이언트, 서버 컴파일러를 제공합니다.
    - 클라이언트 컴파일러는 단일 CPU를 위해, 서버 컴파일러는 그 외의 환경을 위해 제공됩니다. 둘을 결정하는 기준은 아래와 같고 일반적으로는 자바가 스스로 결정합니다. 물론 자바 실행시 `-server` 옵션을 통해 명시적으로 지정할 수도 있습니다.
        - 2개 이상의 물리적 프로세서
        - 2GB 이상의 물리적 메모리

---

### Garbage Collect

- 자바에선 C와 다르게 개발자가 직접 메모리 누수(Memory leak)이 발생하지 않도록 메모리 관리를 수행하지 않아도 됩니다. JVM 내의 가비지 컬렉터가 메모리(이 중 heap 영역) 관리를 해주기 때문이죠.
    - GC의 대상이 되는 Heap 영역은 Young(Eden, 두 개의 Survivor), Old, Perm 영역으로 나눠집니다. GC는 수행되는 영역에 따라 Minor GC, Full GC로 나뉩니다.
    - Minor GC(Young GC)의 수행과정은 아래와 같습니다.
        1. Eden 영역에서 객체가 생성됩니다.
        2. Eden 영역이 꽉 차면 살아있는 객체만 Survivor 영역으로 복사되고, 다시 Eden 영역을 채우게 됩니다.
        3. Survivor 영역이 꽉 차게 되면 다른 Survivor 영역으로 객체가 복사됩니다. 이때 Eden 영역에 있는 객체들 중 살아있는 객체들도 다른 Survivor 영역으로 갑니다. **즉 Survivor 영역의 둘 중 하나는 반드시 비어 있어야만 합니다.**
    - Full GC는 Old 영역이 가득 차면 발생합니다. 다른 말로는 Major GC 라고도 합니다.
- Young GC는 일반적으로 GC가 수행되는 공간이 더 작고 객체를 처리하는 방식이 다르기 때문에 Full GC보다 소요시간이 적습니다. 하지만 Heap 영역 전체를 Young 영역으로 만들면 장애가 발생할 확률이 매우 높습니다.
- GC는 Oracle JDK에서 제공하는 4가지와 Java 7부터 추가된 G1을 포함해 총 5가지가 존재합니다.
    - Serial GC
        - 클라이언트용 장비에 최적화된 GC기 때문에 WAS로 사용하는 JVM에서는 사용해선 안됩니다. 성능이 매우 느려 애플리케이션의 성능이 매우 저하됩니다.
    - Parallel Young Generation Collector
    - Parallel Old Generation Collector
    - Goncurrent Mark & Sweep Collector(CMS)
    - G1(Garbage First)
- 자세한 내용은 Naver D2에서 제공하는 [Java Garbage Collection](https://d2.naver.com/helloworld/1329)에서 확인할 수 있다.