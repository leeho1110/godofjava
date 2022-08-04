package part25;

import part25.daemon.DaemonThreadSample;

public class RunDaemonThread {
    public static void main(String[] args) {
        RunDaemonThread thread = new RunDaemonThread();
        thread.runDaemonThread();
    }

    public void runDaemonThread(){
        DaemonThreadSample daemonThread = new DaemonThreadSample();
        daemonThread.setDaemon(true);
        daemonThread.start(); // 데몬 스레드인 경우 메인 메서드에서 수행되는 다른 메서드가 없기 때문에 바로 종료된다.
    }
}
