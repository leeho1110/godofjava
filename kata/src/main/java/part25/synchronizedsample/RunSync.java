package part25.synchronizedsample;

public class RunSync {
    public static void main(String[] args) {
        RunSync runSync = new RunSync();
        runSync.runCommonCalculate();
        runSync.runSynchronizedCommonCalculate();
    }

    public void runCommonCalculate(){
        CommonCalculate commonCalculate = new CommonCalculate();

        ModifyAmountThread amountThread1 = new ModifyAmountThread(commonCalculate,true);
        ModifyAmountThread amountThread2 = new ModifyAmountThread(commonCalculate,true);

        amountThread1.start();
        amountThread2.start();

        try {
            amountThread1.join();
            amountThread2.join();

            System.out.println(String.format("Final value is %s", commonCalculate.getAmount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void runSynchronizedCommonCalculate(){
        SynchronizedMethodCommonCalculate synchronizedCommonCalculate = new SynchronizedMethodCommonCalculate();

        ModifyAmountThread amountThread1 = new ModifyAmountThread(synchronizedCommonCalculate,true);
        ModifyAmountThread amountThread2 = new ModifyAmountThread(synchronizedCommonCalculate,true);

        amountThread1.start();
        amountThread2.start();

        try {
            amountThread1.join();
            amountThread2.join();

            System.out.println(String.format("Final value is %s", synchronizedCommonCalculate.getAmount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
