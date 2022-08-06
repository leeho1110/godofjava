package part25;

public class RunSupportThreads {
    public static void main(String[] args) {
        RunSupportThreads sample = new RunSupportThreads();
        sample.checkThreadState1();
    }

    private void checkThreadState1() {
        SleepThread sleepThread = new SleepThread(2000);

        try {
            System.out.println("sleepThread state= " + sleepThread.getState());
            sleepThread.start();
            System.out.println("sleepThread state(after start)= " + sleepThread.getState());

            Thread.sleep(1000);
            System.out.println("thread state(after 1sec)= " + sleepThread.getState());

            sleepThread.join();
            sleepThread.interrupt();
            System.out.println("thread state(after join)= " + sleepThread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
