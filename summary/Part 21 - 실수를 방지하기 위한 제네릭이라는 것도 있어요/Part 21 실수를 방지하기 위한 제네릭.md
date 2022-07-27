# Part 21: 실수를 방지하기 위한 제네릭이라는 것도 있어요

### 개요

자바의 제네릭 Generic에 대해 알아봅니다.

---

### 왜 제네릭을 사용할까요?

- 자바 프로그램을 작성하며 우린 수많은 타입들을 마주하고 타입 형변환을 진행합니다. 이 때 여러 문제들이 발생할 수 있는데요. 제네릭은 **타입 형변환에서 발생할 수 있는 문제점을 컴파일 타임 시점에 점검**할 수 있도록 해줍니다.
    - 클래스 선언 시 정의되는 인스턴스 필드와 메서드에서 사용되는 타입을 꺽쇠를 통해 지정할 수 있습니다. 꺽쇠 안의 타입을 표현하는 이름은 무엇이 오든 상관없지만 자바에서 정의한 기본 규칙은 존재합니다.
        - E: 요소 (Element, Java Collection Framework에서 주로 사용됨)
        - K: 키
        - N: 숫자
        - T: 타입
        - V: 값
        - S,U,V: 두 번째, 세 번째, 네 번째에 선언된 타입
    - 동일한 메서드 시그니처에서 인자를 변환하는 것이 메서드 오버로딩이라면 제네릭은 클래스의 타입 오버로딩이라고 볼 수 있지 않을까 싶습니다.

---

### 제네릭의 ?

- 제네릭에서 꺽쇠 안의 타입은 기본적으로 어떤 타입이든 상관이 없습니다. 하지만 매개변수로 사용될 때는 같은 클래스라도 제네릭 타입이 다른 경우를 고려해야 합니다. 이 때 사용되는 것이 **? 기호를 통한 wildcard 타입**입니다.
    - wildcard는 메소드의 매개변수로만 사용하는 것이 권장됩니다.

---

### 제네릭 선언에 사용하는 타입도 범위 지정이 가능합니다

- 앞서 살펴본 제네릭 타입에서는 모든 타입이 지정한 가능한 일반 타입과 와일드카드 타입을 살펴봤습니다. 여기서 타입을 제한할 수 있는 와일드카드 기능이 하나 더 있습니다. 바로 **Bounded Wildcards** 입니다.
    - ? wildcard는 어떤 타입이 오더라도 상관이 없었던 반면 바운디드 와일드카드는 특정 타입의 자식 클래스로 타입을 제한합니다.

---

### 메소드를 제네릭하게 선언하기

- 메서드의 매개변수를 와일드카드로 선언하면 다른 제네릭 타입을 가진 객체를 받을 수 있었습니다. 하지만 받더라도 내부 인스턴스 필드 값을 변경하는 것은 불가능했습니다.
    - 타입이 ? 으로 선언되어 명시적인 타입이 정해져 있지 않기 때문이죠. 따라서 이 경우 추가로 ? 타입의 매개변수를 선언해 값을 할당할 수 있습니다.
        
        ```java
        public static void main(String[] args) {
            CarWildcardSample sample = new CarWildcardSample();
            sample.genericMethod(new WildcardGeneric<String>());
        }
        
        private <T> void genericMethod(WildcardGeneric<T> c){
        		c.setWildcard("A"); // java: incompatible types: java.lang.String cannot be converted to T
        }
        
        private <T> void genericMethodWithAdditionalValue(WildcardGeneric<T> c, T addValue){
        		c.setWildcard(addValue);
            T wildcard = c.getWildcard();
            System.out.println(wildcard);
        }
        ```