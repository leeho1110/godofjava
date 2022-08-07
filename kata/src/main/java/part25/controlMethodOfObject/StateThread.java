package part25.controlMethodOfObject;

import java.time.LocalDateTime;

public class StateThread extends Thread {

    private Object monitor;

    public StateThread(Object monitor) {
        this.monitor = monitor;
    }

    public void run() {
        System.out.println("StateThread run!");
        try {
            for (int i = 0; i < 10000; i++) { // 1000으로 줄였을 때는 너무 빠르게 수행되어 state가 WAITING 상태로 나옴
                String a = "A";
            }
            synchronized (monitor) {
                monitor.wait(); // [1] StateThread가 대기 상태에 진입
            }

            System.out.println(getName() + " is notified!"); // [3] 만약 RunObjectThreads에서 notify 해주지 않으면 영원히 실행되지 않음

            System.out.println("StateThread go sleep at " + LocalDateTime.now()); // StateThread go sleep at 2022-08-07T13:49:25.344481
            Thread.sleep(5000);
            System.out.println("StateThread wake up " + LocalDateTime.now()); // StateThread wake up 2022-08-07T13:49:30.352592
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
