# Part 17: 어노테이션이라는 것도 알아야 합니다

### 개요

자바의 어노테이션에 대해서 알아봅니다.

---

### 어노테이션이란

- 어노테이션이란 JDK 5부터 지원하는 클래스, 메서드, 필드, 변수에 붙는 주석을 말합니다. Annotation의 뜻도 주석이며, 메타데이터라고 불리기도 합니다.
    - 어노테이션의 용도는 다음과 같습니다.
        - 컴파일러에게 정보 전달
        - 컴파일 시점과 설치 시의 작업 지정
        - 실행 시 별도 처리가 필요한 경우 마킹
- 자바에서 빌트인으로 제공하는 일반적인 어노테이션은 총 3개입니다. 어노테아션을 생성하기 위한 메타 어노테이션도 존재하는데 이것은 4개가 제공됩니다.
    - 일반 어노테이션의 종류는 다음과 같습니다.
        - @Override: 부모 클래스의 메서드를 오버라이딩한 메서드라고 알려줍니다.
        - @Deprecated: 클래스나 메서드가 deprecate되어 더이상 사용하지 않는다는 것이라고 알려줍니다.
        - @SupressWarnings: 경고를 억제하기 위해 사용합니다.
    - 메타 어노테이션의 종류는 다음과 같습니다.
        1. @Target
            - 어노테이션 적용 대상을 결정합니다.
            - CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHID, PACKAGE, PARAMETER, TYPE
        2. `@Retention`
            - 어노테이션 정보의 라이프사이클을 선언합니다.
            - SOURCE(컴파일 타임 시점까지), CLASS(가상 머신 전까지), RUNTIME(실행시 가상 머신에 으해 참조 가능)
        3. @Documented
            - 어노테이션이 Javadocs(API) 문서에 포함된다는 것을 의미합니다.
        4. @Inherited
            - 모든 자식 클래스에서 부모 클래스의 어노테이션을 사용할 수 있다는 것을 의미합니다.
- @interface를 통해 임의의 어노테이션을 생성할 수 있습니다.
    
    ```java
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface UserAnnotation {
    		public int number();
    		public String text() default "Test Annotation";
    }
    ```
    
- 자바 리플렉션에서 제공하는 Class, Method 클래스를 통해 선언된 어노테이션의 애트리뷰트 값을 확인할 수 있습니다.
- 어노테이션은 상속이 불가능합니다.