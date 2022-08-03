package part25;

import java.time.LocalTime;

public class ThreadSample extends Thread {

    public void run(){
        System.out.println(String.format("ThreadSample thread Id is [%d] and run at %s",
                Thread.currentThread().getId(), LocalTime.now()));
        System.out.println("ThreadSample thread end!");
    }

    public static void main(String[] args) {
        long mainThreadId = Thread.currentThread().getId();
        System.out.println("mainThreadId = " + mainThreadId);

        ThreadSample sample = new ThreadSample();
        sample.run();
    }
}
