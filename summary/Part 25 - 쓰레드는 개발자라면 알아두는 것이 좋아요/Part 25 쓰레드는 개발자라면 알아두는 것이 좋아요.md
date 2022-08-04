# Part 25: 쓰레드는 개발자라면 알아두는 것이 좋아요

### 개요

자바의 쓰레드에 대해서 알아봅니다. 웹 애플리케이션의 동작 구조에서 쓰레드의 역할은 정말 중요합니다.

---

### 쓰레드란?

- 쓰레드란 프로세스 내에서 명령을 수행하는 부하라고 생각하면 됩니다.
    - 프로세스는 반드시 하나 이상의 쓰레드를 가지지만, 쓰레드가 여러 프로세스에 의해 공유되진 않습니다.
        
        <p align="center"><img src="img/process-thread.png"></p>
        
    - 프로세스는 프로그램이 메모리에 올라간 상태를 말합니다.
        - Process is program in execution
        - *운영체제는 메모리에 프로그램을 어떻게 올릴까?*
        - *프로세스 내에서 쓰레드는 어떻게 생성될까?*
- 쓰레드가 필요한 이유는 무엇일까요?
    - 하드웨어에서 기술 발전의 이유를 살펴보면 대부분 **자원의 효율적인 활용을 위해서** 입니다.
    - JVM에서 하나의 프로세스를 생성하기 위해서 일반적으로 32~64MB의 물리 메모리를 점유한다고 합니다. 하지만 쓰레드는 하나당 1MB 이내의 메모리를 사용하기 때문에 보다 효율적인 자원 사용이 가능합니다.
        - 서버 환경에서 클라이언트 요청을 처리하는 기술은 자원을 효율적으로 사용하도록 CGI Program→ Java Servlet 순서로 발전했습니다.
        - CGI 프로그램은 클라이언트의 요청이 새로운 프로세스를 통해 처리하는데 이는 자원 소모가 너무 큽니다. 반면 서블릿은 하나의 프로세스 안에서 여러 쓰레드를 생성해 요청을 처리하기 때문에 **프로세스 생성에 필요한 자원 - 쓰레드 생성에 필요한 자원** 만큼을 절약할 수 있습니다.

---

### Runnable Interfcae, Thread Class

- Runnable 인터페이스를 구현하거나 Thread 클래스를 상속해 쓰레드 생성이 가능합니다.
    - 왜 두 가지 방법이 존재할까요?
        - 만약 Thread 클래스만 존재한다면 다중 상속이 불가능하기 때문에 부모 클래스를 확장하는 클래스는 쓰레드를 생성할 수 없어집니다. 따라서 이를 극복하기 위해 Runnable 인터페이스를 제공하고 있습니다.
    - start() 메서드를 통해 쓰레드가 코드를 수행하도록 명령할 수 있습니다.
        - start()는 스레드가 실행을 시작하게 하는 메서드로써 JVM은 start()가 호출될 때 스레드의 run() 메서드를 호출합니다.
        - 결과적으로 Thread의 start()을 호출한 current 메서드와 run() 메서드를 실행하는 other 메서드, 두 개의 스레드를 동시에 시작합니다. 한 번 이상 start()하는 것은 허용되지 않습니다. 특히 스레드가 실행을 완료한 뒤엔 스레드가 다시 실행되지 않을수도 있습니다.
        - start()는 VM이 생성하거나 설정한 메인 메서드 스레드나 시스템 그룹 스레드들에는 호출되지 않습니다.
        
        ```java
        public
        class Thread implements Runnable {
        
        /*
        		Causes this thread to begin execution; the Java Virtual Machine calls the run method of this thread.
        
        		The result is that two threads are running concurrently: the current thread (which returns from the call to the start method) and the other thread (which executes its run method).
        		It is never legal to start a thread more than once. In particular, a thread may not be restarted once it has completed execution.
        		
        		Throws: IllegalThreadStateException – if the thread was already started.
        		See Also: run(), stop()
        */ㄴ
        public synchronized void start() {
                /**
                 * This method is not invoked for the main method thread or "system"
                 * group threads created/set up by the VM. Any new functionality added
                 * to this method in the future may have to also be added to the VM.
                 *
                 * A zero status value corresponds to state "NEW".
                 */
                if (threadStatus != 0)
                    throw new IllegalThreadStateException();
        
                /* Notify the group that this thread is about to be started
                 * so that it can be added to the group's list of threads
                 * and the group's unstarted count can be decremented. */
                group.add(this);
        
                boolean started = false;
                try {
                    start0();
                    started = true;
                } finally {
                    try {
                        if (!started) {
                            group.threadStartFailed(this);
                        }
                    } catch (Throwable ignore) {
                        /* do nothing. If start0 threw a Throwable then
                          it will be passed up the call stack */
                    }
                }
            }
        ```
        
- 쓰레드도 이름이 있을까요?
    - 쓰레드에게 이름을 지정하지 않으면 쓰레드는 생성된 순서에 따라 ‘Thread-정수값’을 갖게 됩니다. 물론 지정할수도 있습니다.
- 여러 쓰레드들을 한 가지 목적을 위해 묶어놓을 수 있을까요?
    - ThreadGroup 클래스를 통해 할 수 있습니다. 이것이 왜 필요하고 어떤 메서드를 제공하는지는 조금 뒤에 알아보겠습니다.
    - Thread는 생성자의 stackSize 인자를 통해 스택의 크기를 임의로 지정할 수 있습니다.
        - 여기서 언급되는 스택은 ‘Stack Frame’을 의미합니다. JVM이 프로세스를 실행하면 할당받은 메모리는 여러 공간으로 분리되어 사용됩니다. 이 때 한 공간이 Runtime Data Aread인데요. 여기엔 명령어를 수행하는 쓰레드들이 여러개 생성됩니다. 각 쓰레드는 다른 쓰레드와 공유하지 않는 각자만의 스택(프레임을 담는 바구니)을 갖습니다. 이름처럼 스택 자료구조의 특성을 갖지만, 컬렉션 프레임워크에서 말하는 스택 자료구조는 아니라는 것을 기억하면 됩니다.

---

### 데몬 스레드와 비데몬 스레드, 우선순위

- Thread 클래스의 주요 메서드는 두 가지 성격을 갖습니다. 쓰레드의 내부 속성을 지정하고 확인하거나, 상태를 통제합니다.
    - 여기서 말하는 속성이란 이름, 우선 순위, 데몬-비데몬 여부를 의미합니다.
    - 상태란 ‘쓰레드의 움직임 순간 포착’입니다.
        - 모두 알다시피 CPU는 한번에 하나의 일만 수행합니다. 여러 개의 쓰레드가 실행될 때에도 마찬가지인데요. 물론 멀티코어라면 동시에 수행될 수 있겠지만 하나의 코어는 하나의 명령어만을 수행된다는 사실에는 변함이 없습니다.
        - 쓰레드가 어떤 행동을 하고 있느냐에 따라 열거형 클래스 State 클래스를 통해 6개의 상태 *`NEW,* *RUNNABLE,* *BLOCKED,* *WAITING,* *TIMED_WAITING,* *TERMINATED`* 로 구분됩니다.
- 언급했던 것처럼 쓰레드는 한번에 하나만 실행될 수 있기 때문에 CPU에 의해 실행되는 순서가 존재하며, 속성에 따라 **우선순위**도 존재합니다.
    - 우선순위는 `MIN_PRIORITY(1)`, `NORM_PRIORITY(5)`, `MAX_PRIORITY(10)`의 상수 형태로 존재하고 값이 클수록 우선순위가 높아집니다.
        - 디폴트 값을 유지하는 것이 권장됩니다.
- 쓰레드는 데몬 스레드와 비데몬 스레드로 나눠집니다. 우리가 일반적으로 main() 메서드를 통해 프로그램을 수행하는 스레드는 일반(비데몬) 스레드입니다.
    - 데몬 스레드의 라이프사이클은 동시에 수행되는 비데몬 스레드에 의존적입니다. 쉽게 말하자면 동시에 수행되는 다른 일반 스레드가 종료되면 멈춰 버립니다.
    - 데몬 스레드가 필요한 이유는 모니터링이나 GC와 같은 부가 작업을 하기 위해서입니다.

---

### 참고자료

- [PHP도 CGI 인가요?](https://kldp.org/node/73386)