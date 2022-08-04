package part25.daemon;

import java.time.LocalTime;

public class EndlessThreadSample extends Thread {

    @Override
    public void run(){
        try {
            System.out.println(String.format("I'm gonna sleep after %s", LocalTime.now()));
            Thread.sleep(1000L);
            System.out.println("I'm wake up!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        EndlessThreadSample sample = new EndlessThreadSample();
        sample.run(); // 일반 스레드가 아니라면 메인 메서드는 스레드의 동작이 끝날 때까지 종료되지 않는다.
        System.out.println(String.format("%s is ended!", Thread.currentThread().getName()));
        State state = Thread.currentThread().getState();
    }
}
