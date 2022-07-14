# Part 16: 클래스 안에 클래스

### 개요

자바의 내부(innter) 클래스, 익명(anonymous) 클래스에 대해 알아봅니다.

---

### 중첩 클래스(Nested Class)

- 자바에서는 클래스 안에 클래스를 선언할 수 있습니다. 이런 클래스들을 Nested Class, 중첩 클래스라고 부릅니다.
    - 중첩 클래스의 존재 이유는 다음과 같습니다.
        - 소스의 가독성과 유지보수성을 향상시킵니다. → Static Nested Class에 해당
        - 한 곳에서만 사용되는 제한적인 클래스를 논리적으로 묶어서 처리해야할 때 필요합니다. → Static Nested Class에 해당
        - 클래스의 내부 구현을 감추는 캡슐화를 필요로 할 때 사용합니다.
    - 선언 방법에 따라 정적 중첩 클래스(Static nested class)와 내부 클래스(Inner class)로 구분됩니다. 둘의 차이는 static 선언 여부입니다.
    - static이 선언되지 않는 내부 클래스는 이름에 따라 다시 두가지로 나뉩니다. 이름이 있는 내부 클래스는 로컬 내부 클래스(Local inner class), 이름이 없으면 익명 내부 클래스(Anonymous inner class)라 부릅니다.

---

### 정적 중첩 클래스(Static nested class)

- 정적 중첩 클래스를 생성하는 이유는 클래스를 묶어서 관리하기 위해서입니다.
    - 의미가 모호한 클래스는 어느 클래스와 논리적인 연관성이 있는지 파악하기 어려울 수 있습니다.
        
        ```java
        public class University {
        		static class Student {}
        }
        
        public class School {
        		static class Student {}
        }
        ```
        
        - ex. Student 클래스와 School, University 클래스
    - 겉으로는 이름과 의미가 유사하지만 내부 구현이 달라야 하는 경우 사용됩니다.
- 정적 중첩 클래스는 감싸고 있는 클래스의 static 변수만 참조할 수 있습니다.

---

### 내부 클래스(Inner Class)와 익명 클래스(Anonymous Class)

- 정적 중첩 클래스와 내부 클래스의 차이는 static 선언 여부와 생성하는 방식입니다.
    - 정척 중첩 클래스는 클래스를 감싸는 바깥 클래스의 인스턴스를 생성하지 않고도 생성할 수 있습니다. 하지만 내부 클래스는 바깥 클래스의 인스턴스를 생성한 뒤, 이 인스턴스를 이용해 인스턴스를 생성해야 합니다.
    - 이런 내부 클래스는 클래스의 공통 작업을 수행할 때 외부에서 재사용될 필요가 없는 경우 사용합니다.
        - GUI 관련 프로그램을 만들 때 리스너를 생성하기 위해 사용됩니다.
- 클래스를 참조 변수에 할당하지 않고 바로 생성해 사용하는 클래스를 익명 클래스라고 합니다.
    
    ```java
    public interface Anonymous {
        void doSomething();
    }
    public class InnerClass {
    		public void makeAnonymous(Anonymous anonymous) {}
    }
    
    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        InnerClass.InnerClassSample innerClassSample = innerClass.new InnerClassSample();
    
        innerClass.makeAnonymous(new Anonymous() {
            @Override
            public void doSomething() {
            }
        });
    }
    ```
    
    - 이를 통해 간단한 방법으로 객체를 생성할 수 있습니다. 템플릿 콜백 패턴에서 콜백 객체를 전달하기 위한 방법으로 위같은 익명 클래스를 사용할 수 있습니다.
- 익명 클래스와 내부 클래스 모두 다른 클래스에서 재사용하지 않는 경우에만 생성해야 합니다.
- 내부 클래스와 익명 클래스는 자신을 감싸는 클래스의 어떤 변수라도 참조할 수 있습니다. 반대로 감싸는 클래스에서 내부, 익명 클래스의 필드에 대한 참조 역시 가능합니다.