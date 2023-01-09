# Part 15: String

### 개요

String 클래스에 대해 알아봅니다.

---

### String 클래스가 final이어야 하는 이유

- String 클래스는 자바의 대표적인 final 클래스입니다. 왜 String 클래스는 final로 선언되어 불변 상태를 유지해야만 할까요? 아마 무언가 우리에게 이점을 주기 때문일 것입니다. 그 이점이 무엇인지 확인해보시죠.
1. **String pool**
    - 사실 개발자들은 자바를 디자인할 때부터 String 클래스 프로그램에서 굉장히 많이 쓰여질 것이라고 예측했습니다. 따라서 설계 단계부터 최적화를 시키고자 노력했습니다. 그리고 최적화의 핵심으로 떠오른 방법이 바로 String Constant Pool이었습니다.
        - String 객체를 생성하여 공유하는 방법을 통해 매번 객체가 생성되고 소멸되는 자원을 줄였습니다.
        - 공유라는 행위는 같은 것을 나눠쓴다는 것을 의미합니다. 한정된 자원을 나눠씀으로써 자원을 효율적으로 사용할 수 있습니다.
            - 하지만 우리가 도서관에서 책을 대여해서 보고있는데 누군가가 책을 찢어간 경우 역시 심심찮게 있을 겁니다. 즉 공유는 자원을 효율적으로 사용한다는 장점과 변경에 예민하다는 단점을 동시에 갖습니다.
            - 따라서 String은 이런 책의 훼손같은 단점을 극복하기 위해 책이 변하지 않도록 코팅해버린 것입니다.
    - String Literal은 매번 인스턴스가 생성되지 않고 한번 생성된 후 상수 풀에 저장되어 참조됩니다. 만약 String이 변경 가능하다면 어떤 일이 벌어질까요?
        
        ```java
        String a = "Test";
        String b = "Test";
        b = b.toUppderCase();
        ```
        
    - 이렇게 데이터를 변경된다면 어떤 일이 일어날까요? **a뿐만 아니라 동일한 애플리케이션 내에 Test를 참조하는 모든 변수가 TEST로 변경**됩니다. 이는 프로그램 내에서 치명적인 오류를 발생시킬 것이 틀림없습니다.
    - String 클래스가 불변인 것과 상수 풀을 사용하는 것은 이렇듯 상호 보완적인 관계에 있습니다. 불변이지 않으면 상수 풀을 사용할 수 없고, 상수 풀을 사용하더라도 불변이지 않으면 문제가 발생하죠.
2. **Security**
- String이 불변 객체인 이유 중 핵심은 바로 **보안**입니다. 자바는 모든 서비스 수준에서 안전한 환경을 제공하겠다는 분명한 목표를 갖습니다. 이 목표를 지키기 위한 보안 영역에서 String 클래스는 굉장히 중요한 역할을 합니다.
- 많은 자바 클래스 내에서 String 타입의 파라미터가 사용됩니다.
    - 네트워크 커넥션을 맺을 때 호스트 이름이나 포트 번호 등과 같은 정보들을 String 인자로 넘깁니다.
    - 데이터베이스 커넥션을 맺을 때 데이터베이스 URL, 호스트, 비밀번호 정보도 String 인자로 넘깁니다.
    - File I/O에서 디렉토리의 패스와 파일명 역시 String 인자로 넘깁니다.
- 만약 String이 불변 객체가 아니라면 위 케이스들에서 치명적인 보안 문제가 발생합니다.
    - 예를 들어 사용자가 시스템의 특정 파일에 접근할 수 있는 권한을 받았다고 가정하겠습니다. 이 때 String이 변경 가능하다면 권한을 가진 채로 경로를 변경해 접근해버릴지도 모릅니다. 이는 중대한 보안 문제를 일으킵니다.
    - 네트워크, 데이터베이스와 같은 시스템 연결에서도 문자열 값의 변경은 이러한 보안 위협을 발생시킵니다. 변경 가능한 String 클래스는 String 타입의 매개인자를 사용하는 Reflection에서도 보안의 영향을 끼칠 수 있습니다.
3. **Use of String in Class Loading Mechanism**
    - String 클래스는 클래스 로딩 메커니즘 안에서도 많이 사용됩니다. 만약 String이 변경 가능하다면 클래스 로딩 시점에 악의적으로 로드되는 클래스명을 변경할 수 있습니다. 예를 들면 java.io.Reader를 com.unknown.DataStolenReader처럼 말이죠. String 클래스를 불변으로 만드는 것을 통해 우린 JVM이 올바른 클래스를 로드하는지에 대해 걱정하지 않아도 됩니다.
4. ****Multithreading Benefits****
    - 자바에서 동시성 및 멀티스레딩은 핵심 중에 핵심입니다. 따라서 String 객체를 멀티스레딩 환경에서 어떻게 보호할 수 있는지 꼭 필요한 연구과제였습니다. String 클래스는 앞서 말했듯 설계 단계부터 사용빈도가 아주 높을 것으로 예상되었습니다. 따라서 차라리 애초에 불변으로 만들어 동기화에 대한 이슈를 걱정하지 않고 사용하도록 만들었습니다.
        - 불변이라는 간단한 특징 하나로 자연스럽게 읽기만 가능하다는 특징을 가지기 때문에 복잡하고 오류가 발생하기 쉬운 동시성 코드들이 훨씬 쉬워집니다.
5. ****Optimization and Performance(Caching)****
    - String 클래스는 불변임을 보장하기 때문에 hashcode() 메서드가 호출될 경우 해당 값을 캐싱해놓았다가 반환합니다.
    - 이는 String이 Hashtable, HashMap과 같은 해시 기반 컬렉션에서 키로 사용될 때 성능의 향상을 가능케 합니다.
        - HashMap의 키가 무조건 불변해야한다는 제약사항은 없지만 키가 변경 가능한 객쳋인 것보다 훨씬 안전하게 사용할 수 있습니다.
        - 해시 기반 컬렉션 내부에 저장될 때 상태가 변경될 위험 역시 없습니다.

---

### String 클래스가 final일 때 생기는 단점

- 지금까지 String 클래스가 불변 객체임을 통해 얻는 이점을 확인했습니다. 하지만 단점 역시 존재합니다.
    - String 클래스는 객체의 상태가 다를 때마다 매번 인스턴스를 생성합니다. 따라서 임시로 사용되는 인스턴스들이 너무 많습니다. 즉 GC의 대상이 너무 많아집니다. 이 점은 자바 설계 당시 예측됐던 문제기 때문에 상수 풀에 문자열 리터럴을 저장해 사용하는 것을 통해 개선이 가능합니다.
        - 하지만 문자열 리터럴로 String 인스턴스를 생성하지 않고 new 연산자를 사용하는 방식은 주의를 기울일 필요가 없습니다.
        - JDK 7 이전에는 문자열이 저장되는 SCP가 Java Heap 내부의 PermGen Space에 위치했었습니다. 해당 영역은 Java Heap에 비해서 제한되어 있어 많은 수의 문자열 리터럴이 생산되는 경우 공간이 부족해 java.lang.OutOfMemoryError가 발생하는 리스크가 존재했었습니다.
        - 다행히 JDK 7부터는 이 점을 고려해 기존 PermGen에 비해 훨씬 큰 일반 Heap 영역으로 SCP의 위치를 옮겼습니다.
    - String은 확장이 제한된다는 단점도 존재합니다. final 클래스는 확장이 불가능하니까요. 하지만 큰 단점으로 보이진 않습니다.

---

### String 클래스가 구현한 세 개의 인터페이스

- String 클래스는 총 세 개의 인터페이스를 구현합니다.
    - Serializable
        - 이 인터페이스는 놀랍게도 구현해야할 메서드가 없습니다. 대신 implements 선언을 해놓으면 **해당 객체를 파일로 저장하거나 다른 서버에 전송할 수 있는 상태**가 됩니다. 추후 27장에서 다시 다룹니다.
    - Comparable
        - compareTo()라는 하나의 메서드만 가지는 인터페이스입니다. 매개 변수와 현재 객체가 같은 지 비교할 때 사용되는 메서드입니다. equals()는 비교의 결과를 boolean 타입으로 반환하는데 compareTo()는 int 타입으로 반환합니다.
        - 결과가 같으면 0, 알파벳 순서 상으로 앞에 있으면 -1, 뒤에 있으면 1을 반환합니다.
    - CharSequence
        - 문자열을 다루기 위한 클래스라는 것을 명시적으로 나타내기 위해 사용됩니다. 자세한 내용은 추후 다시 다룹니다.

---

### intern()

- String 클래스는 상수 풀에 저장되고 참조된다고 말씀드렸습니다. intern() 메서드는 상수 풀에 문자열 리터털을 할당하는 메서드입니다.
    - 하지만 일반적으로 new 연산자를 사용해 인스턴스를 생성한 경우에도 자바는 내부적으로 상수 풀에 존재 여부를 체크하고 없다면 상수 풀에 할당해줍니다. 즉 어떻게 생성하든 상수 풀에 문자열 리터럴은 저장됩니다.
    - 따라서 강제로 intern() 메서드를 통해 강제 할당하는 행위는 해당 영역을 GC하는 단계를 거치게 합니다. 이 작업으로 인한 성능 저하가 발생할 수도 있으니 절대로 수행해서는 안됩니다.
    - 문자열 리터럴을 사용하는 경우 자동으로 String interning이 발생하므로 굳이 intern() 메서드를 사용할 필요가 없습니다.

---

### StringBuffer, StringBuilder

- String 인스턴스는 불변 객체라는 특성 때문에 더하기 연산 시에 더하기의 연산자가 된 인스턴스들은 그대로 버려지는 문제가 발생한다. 이는 임시적이지만 메모리 낭비를 유발하고 추후 GC의 대상이 된다. 이런 단점을 보완하기 위해 나온 클래스로 String과는 다르게 변경이 가능한 객체다.
    - 두 클래스가 제공하는 메서드는 동일하며 StringBuffer는 StringBuilder와 달리 멀티스레딩 환경에서 Thread Safe 하다는 특징을 갖는다.
        - 다만 멀티스레딩 환경을 보장하기 때문에 성능 면에서 StringBuilder가 빠르다
    - 더하기 연산 대신 append() 메서드를 통해 문자열 컨캣이 가능하며 JDK 5부터는 String도 컴파일 시 자동으로 StringBuilder로 변환되어 연산됩니다.
        - 소스 코드
            
            ```java
            public class StringTest {  
                public static void main(String[] args) {  
                    String str0 = "It's a string....";  
                    String str1 = "It's" + " a string" + "....";  
                    String str2 = "It's a string...." + str0 + "000";  
            
                    str2 = str0 + str1 + "1111" ;        
                    str2 = str2 + "1111";  
                    str2 += "1111";        
            
                    for (int i=0;i<10;i++){  
                        str2 = str2 + "1111";  
                        str2 += "1111";        
                    }  
                }  
            }
            ```
            
        - JDK 1.5 컴파일
            
            ```java
            public class StringTest{  
                public StringTest(){} // 자동으로 컴파일러가 생성자를 생성
            
                public static void main(String args[])    {  
                    String str0 = "It's a string....";  
            
            				// 문자열 리터럴끼리의 더하기 연산의 경우 그냥 리터럴을 합쳐줌
                    String str1 = "It's a string....";  
            				
            				// String 인스턴스는 StringBuilder 객체로 변환(새롭게 인스턴스 생성)한 뒤 append를 통해 더하기 연산
                    String str2 = (new StringBuilder("It's a string....")).append(str0).append("000").toString();  
                    str2 = (new StringBuilder(String.valueOf(str0))).append(str1).append("1111").toString();  
                    str2 = (new StringBuilder(String.valueOf(str2))).append("1111").toString();  
                    str2 = (new StringBuilder(String.valueOf(str2))).append("1111").toString();  
            	
            				// 반복문 내부에서 역시도 객체를 참조하여 연산시 새로운 StringBuilder 인스턴스를 생성한 뒤 연산
                    for(int i = 0; i < 10; i++){  
                        str2 = (new StringBuilder(String.valueOf(str2))).append("1111").toString();  
                        str2 = (new StringBuilder(String.valueOf(str2))).append("1111").toString();  
                    }  
                }  
            }
            ```
            
        - for 루프와 같은 반복작업에서는 StringBuilder 인스턴스로 변경해주긴 하지만, 새로운 StringBuilder 인스턴스를 생성합니다. 따라서 사실상 String의 문제와 동일합니다. 따라서 반복문 안에서는 String 클래스의 + 연산을 하지 않고 StringBuilder의 append() 메서드를 사용하는 것이 바람직해 보입니다.
- 만약 위 클래스들을 매개변수로 받는 작업을 진행할 때에는 CharSequence 타입으로 받는 것이 권장됩니다.
    - 일반적으로 String 타입으로 매개변수를 받을 때 StringBuilder, StringBuffer에서 toString()으로 String 인스턴스를 만들어 전달하는데 이렇게 쓸데없이 생성하지말고 CharSequence 타입으로 그냥 전달하라는 의미인 것 같습니다.
    - ‘자바 성능 튜닝 이야기’라는 서적에서도 나온다고 하네요.
- 동시성 문제가 존재하는 경우 StringBuffer를 사용하는 것을 절대 잊어선 안됩니다.

---

### *Ref*

- [https://www.java67.com/2014/01/why-string-class-has-made-immutable-or-final-java.html](https://www.java67.com/2014/01/why-string-class-has-made-immutable-or-final-java.html)
- [https://gist.github.com/benelog/b81b4434fb8f2220cd0e900be1634753](https://gist.github.com/benelog/b81b4434fb8f2220cd0e900be1634753)
