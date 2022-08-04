package part25;

import java.time.LocalTime;

public class DaemonThreadSample extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println(LocalTime.now());
        }
    }
}
