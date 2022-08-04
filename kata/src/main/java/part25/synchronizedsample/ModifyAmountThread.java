package part25.synchronizedsample;

public class ModifyAmountThread extends Thread {
    private Calculate calculate;
    private boolean addFlag;

    public ModifyAmountThread(Calculate calculate, boolean addFlag){
        this.calculate = calculate;
        this.addFlag = addFlag;
    }

    public void run(){
        for (int i = 0; i < 10000; i++) {
            if(addFlag){
                calculate.plus(1);
            } else {
                calculate.minus(1);
            }
        }
    }

    public static void main(String[] args) {
        CommonCalculate calculate = new CommonCalculate();

        ModifyAmountThread amountThread1 = new ModifyAmountThread(calculate,true);
        ModifyAmountThread amountThread2 = new ModifyAmountThread(calculate,true);

        amountThread1.start();
        amountThread2.start();

        try {
            amountThread1.join();
            amountThread2.join();

            System.out.println(String.format("Final value is %s", calculate.getAmount()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
