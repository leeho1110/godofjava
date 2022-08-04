package part25.synchronizedsample;

public class CommonCalculate implements Calculate{
    private int amount;

    public CommonCalculate() {
        this.amount = 0;
    }

    public void plus(int value) {
        amount += value;
    }

    public void minus(int value) {
        amount -= value;
    }

    public int getAmount() {
        return amount;
    }
}
