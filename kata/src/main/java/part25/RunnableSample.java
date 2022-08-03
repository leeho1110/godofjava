package part25;

import java.time.LocalTime;

public class RunnableSample implements Runnable {

    @Override
    public void run() {
        System.out.println(String.format("RunnableSample thread Id is [%d] and run at %s",
                Thread.currentThread().getId(), LocalTime.now()));
        System.out.println("RunnableSample thread end!");
    }

    public static void main(String[] args) {
        long mainThreadId = Thread.currentThread().getId();
        System.out.println("mainThreadId = " + mainThreadId);

        RunnableSample sample = new RunnableSample();
        sample.run();
    }
}
