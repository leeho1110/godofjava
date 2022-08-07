package part25.controlMethodOfObject;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RunObjectThreads {
    public static void main(String[] args) {
        RunObjectThreads sample = new RunObjectThreads();
//        sample.checkThreadState2();
        sample.checkThreadState3();
    }

    private void checkThreadState2() {
        Object monitor = new Object();
        StateThread thread = new StateThread(monitor);

        try {
            System.out.println("thread state= " + thread.getState());
            thread.start();
            System.out.println("thread state(after start)="+thread.getState());

            Thread.sleep(100);
            System.out.println("thread state(after 0.1sec)="+thread.getState());

            synchronized (monitor){
                monitor.notify(); // [2] StateThread 클래스에서 무한정 대기하고 있는 monitor를 대기 상태에서 깨워줌
            }

            System.out.println("Main Thread go sleep at " + LocalDateTime.now()); // Main Thread go sleep at 2022-08-07T13:49:25.344528
            Thread.sleep(1000);
            System.out.println("Main Thread wake up " + LocalDateTime.now()); // Main Thread wake up 2022-08-07T13:49:25.448075

            System.out.println("thread state(after notify)="+thread.getState());

            thread.join();
            System.out.println("thread state(after join)="+thread.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkThreadState3() {
        Object monitor = new Object();
        StateThread thread = new StateThread(monitor);
        StateThread thread2 = new StateThread(monitor);

        try {
            System.out.println("thread state= " + thread.getState());
            System.out.println("thread2 state= " + thread2.getState());

            thread.start();
            thread2.start();

            System.out.println("thread state(after start)="+thread.getState());
            System.out.println("thread2 state(after start)="+thread2.getState());

            Thread.sleep(100);
            System.out.println("thread state(after 0.1sec)="+thread.getState());
            System.out.println("thread state(after 0.1sec)="+thread2.getState());

            synchronized (monitor){
                monitor.notify(); // 먼저 대기하고 있는 쓰레드 중 하나만 깨워준다. thread2 부터 깨운다.
                monitor.notify(); // 그래서 thread1까지 깨우기 위해 한번 더 notify() 해줘야 한다.

                monitor.notifyAll(); // 한번에 다 깨우는 방법도 있다.
            }
            // monitor.notify(); -> IllegalMonitorStateException 예외 반환
            /*
                만약 synchronized block 밖에서 notify 하려고 하면 IllegalMonitorStateException 예외가 반환된다. 왜 그럴까요?

                notify() 메서드에서는 만약 현재 스레드가 이 오브젝트의 모니터의 주인이 아닌 경우 발생합니다.
                synchronized 블록 밖의 스레드는 메인 스레드입니다.
                thread1, thread2는 각각 start()로 시작되었기 때문에 아마 thread-0, thread-1 쓰레드가 실행시킬테고 주인은 이 둘입니다.
                따라서 메인 스레드가 접근해 notify() 메서드를 호출했을 때 예외가 반환된 것입니다.
             */

            System.out.println("thread state(after notify)="+thread.getState());
            System.out.println("thread2 state(after notify)="+thread2.getState());

            thread.join();
            System.out.println("thread state(after join)="+thread.getState());

            thread2.join();
            System.out.println("thread2 state(after join)="+thread2.getState());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
