package part25;

import part24.TreeMapSample;

public class RunMultipleThreadsSample {
    public static void main(String[] args) {
        RunMultipleThreadsSample sample = new RunMultipleThreadsSample();
        sample.runMultipleThreads();
    }

    private void runMultipleThreads() {
        RunnableSample[] runnables = new RunnableSample[5];
        ThreadSample[] threads = new ThreadSample[5];

        for (int i = 0; i < 5; i++) {
            runnables[i] = new RunnableSample();
            threads[i] = new ThreadSample();

            new Thread(runnables[i]).start();
            threads[i].start();
        }
        System.out.println("RunMultipleThreadsSample.runMultipleThreads() method is ended");
    }
}
