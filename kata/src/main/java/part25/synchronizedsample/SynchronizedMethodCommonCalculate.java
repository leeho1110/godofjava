package part25.synchronizedsample;

public class SynchronizedMethodCommonCalculate implements Calculate {
    private int amount;

    public SynchronizedMethodCommonCalculate() {
        this.amount = 0;
    }

    public synchronized void plus(int value) {
        amount += value;
    }

    public synchronized void minus(int value) {
        amount -= value;
    }

    public int getAmount() {
        return amount;
    }
}
