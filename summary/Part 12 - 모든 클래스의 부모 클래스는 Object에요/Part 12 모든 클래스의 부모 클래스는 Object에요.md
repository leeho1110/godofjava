# Part 12: 모든 클래스의 부모 클래스는 Object에요

### 개요

모든 클래스으 부모 클래스이자 루트 클래스인 Object 클래스에 대해 알아봅니다.

---

### Object 클래스

- Object 클래스는 클래스 상속 관계의 최상위 루트에 있는 클래스입니다. 따라서 모든 클래스들의 부모 클래스입니다.
    - 우리가 일반적으로 클래스를 하나 생성하면 기본으로 주어지는 메서드들이 존재합니다. 이 메서드들은 사실 그냥 주어지는 것이 아닌 Object 클래스에 정의된 메서드들입니다.
        - `public int hashCode()`
        - `public final [Class](https://docs.oracle.com/javase/7/docs/api/java/lang/Class.html)<?> getClass()`
        - `protectedObject clone() throws CloneNotSupportedException`
        - `public boolean equals([Object](https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html) obj)`
        - `public [String](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html) toString()`
        - `public final void notify()`
        - `public final void notifyAll()`
        - `public final void wait() throws [InterruptedException](https://docs.oracle.com/javase/7/docs/api/java/lang/InterruptedException.html)`
        - `public final void wait(long timeout) throws [InterruptedException](https://docs.oracle.com/javase/7/docs/api/java/lang/InterruptedException.html)`
        - `public final void wait(long timeout, int nanos) throws [InterruptedException](https://docs.oracle.com/javase/7/docs/api/java/lang/InterruptedException.html)`
        - `protected void finalize() throws [Throwable](https://docs.oracle.com/javase/7/docs/api/java/lang/Throwable.html)`
- toString()
    - 일반적으로 참조 자료형에 대해서는 `getClass().getName() + ‘@’ + Integer.toHexString(hashCode())` 형태의 문자열이 출력됩니다.
    - 만약 객체의 내부 상태값들을 알고 싶은 경우 재정의하여 사용하면 됩니다.
- equals()
    - == 연산의 경우 참조 자료형은 값이 아닌 객체의 주소값을 비교합니다.
    - equals() 역시 일반적으로 hashCode()의 결과값을 기준으로 비교합니다.
    - 만약 값을 비교하고 싶다면 toString()처럼 재정의하여 사용하면 됩니다. 재정의하려는 경우 지켜야할 다섯가지 조건이 존재합니다.
        - 재귀 → x.equals(x)는 항상 true
        - 타동성 → x.equals(y)가 true이고 y.equals(z)가 true라면 x.equals(y)도 반드시 true
        - 대칭 → x.equals(y)가 true라면 y.equals(x)도 true
        - 일관 → 몇 번을 수행하더라도 x.equals(x) 결과는 항상 true 이거나 항상 false
- hashcode()
    - 기본적으로 객체의 메모리 주소를 16진수로 표현한 int 타입으로 리턴합니다.