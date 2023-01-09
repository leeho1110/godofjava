# Part 23: 자바랭 다음으로 많이 쓰는 애들은 컬렉션 (1)

### 개요

컬렉션 프레임워크 중 Set, Queue에 대해서 알아봅니다.

---

### Set이 왜 필요할까?

- Set는 순서가 존재하지 않으며 중복된 요소를 저장하지 않는 자료구조입니다. 자바의 컬렉션 프레임워크에서 Set 인터페이스를 구현한 주요 클래스는 HashSet, TreeSet, LinkedHashSet이 있습니다.
    - 세 개의 클래스 중 성능은 HashSet > TreeSet > LinkedHashSet 순으로 좋습니다.
        - TreeSet과 LinkedHashSet의 성능이 떨어지는 이유는 **값이 정렬**되기 때문입니다.
        - TreeSet은 red-black 트리 타입으로 값이 저장됩니다.

---

### HashSet에 대해서 파헤쳐보자

- HashSet는 이전 장에서 학습했던 List와 달리 순서가 없습니다. 따라서 List에서 지원하는 순서가 필요한 `get(int index)`, `indexOf(Object o)`와 같은 메서드는 존재하지 않습니다.
- HashSet은 디폴트로 16개의 데이터 저장 공간과 0.75의 로드 팩터(load factor)를 갖는 객체를 생성합니다.
    - 로드팩터는 **저장된 데이터 수/저장공간**으로 HashSet 내부에 데이터가 얼마나 차있는지 나타냅니다.
    - 데이터를 저장하다 만약 로드 팩터보다 커지면 저장 공간의 크기가 증가되며 해시 재정리 작업이 필요해집니다. 재정리 작업에서 내부의 자료 구조를 다시 생성하게 되는데 이것이 성능에 영향을 미칩니다.
        - 그렇다고 로드 팩터를 너무 크게 설정하게 되면 데이터를 탐색하는데 시간이 오래 걸립니다.

---

### Queue는 왜 필요할까?

- 앞서 소개한 LinkedList 클래스는 자신의 순서를 포인터를 통해 확인합니다. 반면 ArrayList는 길게 늘어뜨린 철도처럼 요소들이 저장됩니다.
    - ArrayList는 중간의 요소가 제거되거나 추가되면 앞뒤의 요소들이 모두 밀려나거나 당겨져야 합니다. 즉 특정 범위의 데이터의 위치값을 모두 바꿔야하는 동작이 추가로 필요하죠. 하지만 LinkedList는 포인터만 한칸 더 앞뒤에 있던 요소들로 바꿔주면 끝입니다.
        - 이러한 특성때문에 삽입과 삭제가 잦은 경우 LinkedList를 사용하고 조회가 잦은 경우는 ArrayList를 사용하는 것이 **메모리 공간의 효율성 측면**에서 좋습니다.
- LinkedList는 List 외에도 Queue ← Deque(Double Ended Queue) 인터페이스도 구현합니다.
    - Deque는 Queue에서 맨 앞, 맨 뒤에 값을 넣거나 빼는 작업을 용이하게 하도록 만든 인터페이스입니다.
        - Queue의 주요 메서드는 add, offer, remove, poll 등이 있습니다. Deque는 addFirst, addLast, offerFirst, offerLast, removeFirst, removeLast, pollFirst, pollLast 등의 메서드를 갖습니다.
