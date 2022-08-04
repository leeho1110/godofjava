package part25.synchronizedsample;

public class SynchronizedLineCommonCalculate implements Calculate {
    private int amount;
    private int interest;

    private Object interestLocker = new Object();
    private Object amountLocker = new Object();


    public SynchronizedLineCommonCalculate() {
        this.amount = 0;
    }

    public void addInterest(int value){
        synchronized (interestLocker){
            interest += value;
        }
    }

    public void plus(int value) {
        synchronized (amountLocker){
            amount += value;
        }
    }

    public void minus(int value) {
        amount -= value;
    }

    public int getAmount() {
        return amount;
    }
}
