# Part 2: Hello God Of Java

### 개요

자바를 실행할 수 있는 환경을 준비해봅니다.

---

### java, javac

- 자바는 컴파일 언어입니다. 따라서 컴파일 후 실행할 수 있습니다.
    - javac: 자바 소스 코드 파일을 컴파일합니다.
    - java: 자바 클래스 파일을 실행합니다.
    - 윈도우에 환경변수를 저장해 직접 JRE가 설치되어 있는 디렉토리로 이동하지 않고도 java, javac 명령어를 실행할 수 있습니다.
- 자바 컴파일러는 자바 소스 코드를 JVM이 해석할 수 있는 바이트코드로 변환합니다.
    - JVM은 바이트 코드를 바이너리 코드로 해석해 실행합니다.
    - JVM은 바이트 코드를 해석할 때 인터프리터 방식을 사용합니다. 이 점때문에 다른 언어에 비해 속도가 느립니다. 따라서 이를 JIT 컴파일러를 통해 성능 이슈를 개선합니다.
    - 여기서 JIT 컴파일러는 JVM 스펙을 어느 벤더에서 구현했느냐에 따라 조금씩 상이합니다.
        - 현재 JVM 구현체를 제공하는 벤더는 IBM, Oracle, SAP 등이 있습니다.

---

### main()

- 자바 프로그램의 시작점은 `public static void main(String[] args) {}` 입니다.
    - 자바 VM은 프로그램을 시작할 때 위 main() 메서드를  찾습니다. 만약 메인 메서드가 없다면 JVM은 프로그램을 실행하지 않으며 아래와 같은 error를 반환합니다.
        - `error: can't find main(String[]) method in class: part2.NoMain`
    - 메인 메서드가 public static void main(String[] args)인 이유
        - public → JVM이 이 메서드가 시작지점인지를 확인하기 위해선 메서드를 찾고 접근할 수 있어야 합니다. 만약 pirvate, protected, package private 접근 제어자를 가지게 되면 JVM에게 보이지 않습니다. private, protected로 메인 메서드의 접근 제어자를 변경하면 컴파일 시 `error: 'main' method is not declared 'public static’` 에러가 발생합니다.
        - static → 메인 메서드도 메서드입니다. 정적 메서드는 클래스 인스턴스를 만들지 않고도 호출이 가능하지만 인스턴스 메서드는 그렇지 않습니다. 따라서 객체를 생성하지 않은채 프로그램이 시작점이 되는 메인 메서드는 static이여야 합니다. 만약 static으로 선언하지 않는 경우 `error: 'main' method is not declared 'public static’` 에러가 발생합니다.
        - void → void로 선언하지 않는 경우 `error: 'main' method is not declared with a return type of 'void’` 에러가 발생합니다.
        - String[] args → 인자를 선언하지 않는 경우 `error: can't find main(String[]) method in class: part2.NoStringArgsMain` 에러가 발생합니다.
    - JVM이 프로그램을 시작할 때 메인 메서드보다 먼저 시작하는 것이 하나 있습니다. 바로 static block입니다.