package part25;

public class SleepThread extends Thread {
    long sleepTime;

    public SleepThread(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    public void run(){
        try {
            System.out.println("SleepThread start!");
            System.out.println("sleepThread sleeping " + getName());
            Thread.sleep(sleepTime);

            Thread thread = Thread.currentThread();
            System.out.println("thread.getName() = " + thread.getName());
            thread.checkAccess();

            System.out.println("sleepThread stopping " + getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
