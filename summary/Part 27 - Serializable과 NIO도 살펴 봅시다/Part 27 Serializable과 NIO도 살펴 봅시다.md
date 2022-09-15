# Part 27. Serializable과 NIO도 살펴 봅시다

### 개요

애플리케이션 내 클래스들을 다른 서버로 보내거나 받는 경우 혹은 파일에 작성할 필요가 있을 때 필요한 직렬화를 가능케 하는 인터페이스 Serializable을 알아봅니다. 이전 장에서 성능 개선을 위해 등장한 NIO도 같이 알아봅니다.

---

### serialVersionUID

- 개요에서 직렬화는 애플리케이션 내부에 있는 객체들을 다른 곳에 전송한다고 말했습니다. 이는 다른 서버에는 저희가 보내고자 하는 객체의 정보를 모를 수도 있다는 의미입니다.
    - 이 때 서버간 교환되는 데이터, 즉 객체의 버전을 판단하는 기준점이 바로 serialVersionUID 입니다.
    - 운영 상황에서 객체의 변경이 일어났음에도 해당 UID 값이 명시적으로 선언되어 있는 경우 문제가 발생할 수 있습니다.
        - 직렬화된 객체를 읽어오는 클래스에 변경이 일어난 경우 `java.io.InvalidClassException` 가 발생합니다.
            
            ```java
            java.io.InvalidClassException: part27.SerialDto; local class incompatible: stream classdesc serialVersionUID = -472947747300743388, local class serialVersionUID = 446293548755684409
            ```
            
        - 최근 IDE에서는 자동으로 serialVersionUID 을 생성해주기도 합니다. 위에서 스택트레이스에 노출된 UID들은 IDE가 생성한 임의값입니다.

---

### transient

- 이 키워드가 명시된 인스턴스 필드는 직렬화 대상에서 제외됩니다.
    - 예를 들어 패스워드나 보안상 문제가 되는 변수를 객체에 저장해야하는 경우 사용할 수 있습니다.

