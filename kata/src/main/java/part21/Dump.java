package part21;

public class Dump<T extends Car> {
    private T parentCar;

    public T getParentCar() {
        return parentCar;
    }

    public void setParentCar(T parentCar) {
        this.parentCar = parentCar;
    }

    public static void main(String[] args) {
        Dump dump = new Dump();
        dump.setParentCar(new Bus("tayo"));

        // java: incompatible types: part21.Formula cannot be converted to part21.Car
        // dump.setParentCar(new Formula());
    }
}
