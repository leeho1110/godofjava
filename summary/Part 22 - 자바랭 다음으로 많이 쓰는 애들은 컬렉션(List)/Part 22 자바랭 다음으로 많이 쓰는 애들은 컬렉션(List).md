# Part 22: 자바랭 다음으로 많이 쓰는 애들은 컬렉션 (1)

### 개요

java.lang 패키지만큼 자바 프로그램을 작성하며 숱하게 쓰이는 Java Collection Framework에 대해서 알아봅니다.

---

### 자바 컬렉션

- 자바는 자료구조를 컬렉션 프레임워크로 제공합니다. 제공하는 자료구조는 List, Set, Queue, Map이 있으며 이 중 List,Set, Queue는 Collection 인터페이스를 구현하며 Map은 별도의 인터페이스로 선언되어 있습니다.
    - 이전엔 데이터를 담는 바구니로 배열을 사용했습니다. 하지만 배열은 초기화 시 크기를 반드시 지정해야 합니다. 하지만 담고자 하는 데이터의 크기를 알 수 없다면 어떡할까요? 컬렉션 프레임워크는 이런 문제점을 해결해줍니다.
        - 혹여나 배열을 Integer.MAX_VALUE로 초기화하는 바보짓은 하지 말길 바랍니다. 이는 엄청난 메모리 낭비를 유발합니다.
    - Map은 단일 데이터 형태로 저장되는 List, Set, Queue와는다르게 Key-Value 쌍으로 저장됩니다.
        - Key, Value 중 어떤 값을 기준으로 Iterating할지 결정할 수 없어 Iterator 인터페이스를 상속하지 않는게 아닐까요?
- Collection 인터페이스는 Iterable 인터페이스를 확장합니다. 이는 Collection 인터페이스가 Iterator 인터페이스를 사용해 데이터에 순차적으로 접근할 수 있다는 의미입니다.
    - Iterable 인터페이스는 Iterator 인터페이스 타입을 반환하는 `iterator()` 메서드 하나만 선언되어 잇습니다.
    - Iterator 인터페이스는 총 4개의 메서드를 갖습니다.
        - 추가 데이터의 존재 여부를 확인하는 hasNext()
        - 현재 위치를 다음으로 넘기고 값을 리턴하는 next()
        - 데이터를 삭제하는 remove()
        - 모든 요소가 처리되거나 예외가 던져질 때까지 인자로 들어온 action을 수행하는 forEachRemaining() → Java 8부터

---

### List 인터페이스와 그 동생들

- 컬렉션 프레임워크 중 List 인터페이스를 구현한 클래스는 매우 많습니다. 그 중 일반적으로 사용되는 구현체는 ArrayList, Vector, Stack, LinkedList 등이 있습니다.
    - 실무를 하며 대부분 조회가 잦은 케이스는 ArrayList, 삽입과 수정이 잦은 케이스는 LinkedList를 사용했었습니다.
    - 이 중 ArrayList는 일반 배열과는 다르게 “확장 가능한 배열"입니다. Vector도 ArrayList와 비슷하지만 **Thread-safe**합니다.
        - 따라서 멀티쓰레드 환경에서 ArrayList를 사용할 때는 주의해야합니다.
        - `Collections.synchronizedList()`를 통해 쓰레드-세이프한 배열을 생성할 수 있습니다.
- ArrayList는 최초 10개의 저장 공간을 가지며, 요소의 갯수가 저장공간 크기를 넘어가는 순간 **현재 크기의 50%를 추가 확장**합니다.
    
    ```java
    public class ArrayList<E> extends AbstractList<E>
            implements List<E>, RandomAccess, Cloneable, java.io.Serializable
    {
    
    		private static final int DEFAULT_CAPACITY = 10; // 최초 사이즈
    		...
    		private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    		...
    		transient Object[] elementData; // non-private to simplify nested class access
    		
    		/**
         * Constructs an empty list with an initial capacity of ten.
         */
    		public ArrayList() {
            this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        }
    }
    ```
    
    - ArrayList의 기본 생성자는 DEFUALT_CAPACITY 크기의 저장 공간을 갖는 *`DEFAULTCAPACITY_EMPTY_ELEMENTDATA`* 배열을 elementData에 넣어줍니다.
    
    ```java
    ...
    public boolean add(E e) {
        modCount++;
        add(e, elementData, size);
        return true;
    }
    
    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }
    ```
    
    - add() 메서드를 통해 추가되는 요소들은 인스턴스 필드 중 elementData에 추가됩니다.
        - modCount는 ArrayList가 구조적으로 변경된 횟수입니다.
    - 매개변수 s는 ArrayList의 size를 의미합니다. size가 저장된 데이터의 길이가 같아지면 grow() 메서드를 호출해 크기를 확장합니다.
    
    ```java
    private Object[] grow() {
        return grow(size + 1);
    }
    
    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData,
                                           newCapacity(minCapacity));
    }
    
    private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        **int newCapacity = oldCapacity + (oldCapacity >> 1);**
        if (newCapacity - minCapacity <= 0) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
            ? newCapacity
            : hugeCapacity(minCapacity);
    }
    ```
    
    - minCapacity는 최소 용량을 의미합니다. 이 값은 현재 사이즈에서 1이 더해진 값을 넣어줍니다.
    - Arrays.copyOf() 메서드를 통해 newCapacity 크기를 갖는 새로운 배열에 elementData를 넣은 뒤 재할당합니다.
    - 현재 크기의 50%를 확장하는 부분은 newCapacity 변수를 초기화하는 부분을 보면 알 수 있습니다.
        - elementData 크기에 우측 시프트 연산을 수행해 기존 크기가 2로 나눠진 값을 더해줍니다.
- toArray() 메서드를 통해 ArrayList를 배열로 변환할 수 있습니다.
    
    ```java
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }
    
    ```
    
    - 인자로 들어온 배열의 크기가 ArrayList의 크기보다 작은 경우 Arrays.copyOf()를 통해 새로운 배열을 생성해 반환합니다.
    - 아닌 경우 Syste.arraycopy() 메서드를 통해 배열을 복사해 반환합니다.

---

### Stack 클래스는 뭐가 다른데?

- 일반적으로 LIFO 특성을 갖는 자료구조로 Stack을 많이 알고 있습니다. 하지만 자바의 컬렉션 프레임워크에서 LIFO 특성을 위해서라면 보다 좋은 성능을 갖는 ArrayDeque 클래스가 권장됩니다. 하지만 쓰레드-세이프한 Stack과는 다르게 ArrayDeque는 그렇지 않다는 점을 주의해야 합니다.
    - Stack은 Vector 클래스를 상속합니다. 하지만 이는 불필요한 인터페이스를 상속하는 문제점을 대표하는 경우 중 하나입니다.
        - Vector는 LIFO 특성을 갖지 않습니다. 따라서 임의의 인덱스에 요소를 삽입할 수 있는 add() 메서드를 갖습니다. Stack은 알다시피 LIFO 특성을 갖기 때문에 반드시 top에 요소를 삽입해야 합니다.
        - 하지만 안타깝게도 Stack 클래스가 Vector 클래스를 상속받기 때문에 Stack에서 add() 메서드를 사용해 임의의 인덱스에 요소를 삽입할 수 있습니다.
        - 즉 퍼블릭 인터페이스의 잘못된 상속으로 인해 Stack의 정책을 깨버리게 되는 문제점이 존재합니다.